package com.pb.sawdust.model.models;

import com.pb.sawdust.tensor.alias.matrix.primitive.DoubleMatrix;
import com.pb.sawdust.tensor.alias.vector.primitive.DoubleVector;
import com.pb.sawdust.util.probability.AbstractDiscreteProbabilisticDistribution;
import com.pb.sawdust.util.probability.DiscreteProbabilisticDistribution;
import com.pb.sawdust.util.collections.LinkedSetList;
import com.pb.sawdust.util.collections.SetList;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The {@code AbstractChoiceSelector} ...
 *
 * @author crf
 *         Started 4/12/12 2:20 PM
 */
public abstract class AbstractChoiceSelector<C extends Choice> implements ChoiceSelector<C> {

    @Override
    public List<C> selectChoices(final Map<C,DoubleVector> probabilities) {
        final SetList<C> orderedChoices = new LinkedSetList<>(probabilities.keySet());
        final int size = probabilities.get(orderedChoices.get(0)).size(0);
        return selectChoices(orderedChoices,buildDistributionIterable(new ChoiceSelectorDistributionBuilder() {

            @Override
            public int getSize() {
                return size;
            }

            @Override
            public DiscreteProbabilisticDistribution getDistribution(int observation) {
                return getProbabilityDistribution(orderedChoices,probabilities,observation);
            }
        }));
    }

    @Override
    public List<C> selectChoices(final SetList<C> choices, final DoubleMatrix probabilities) {
        final int size = probabilities.size(0);
        return selectChoices(choices,buildDistributionIterable(new ChoiceSelectorDistributionBuilder() {

            @Override
            public int getSize() {
                return size;
            }

            @Override
            public DiscreteProbabilisticDistribution getDistribution(int observation) {
                return getProbabilityDistribution(probabilities,observation);
            }
        }));
    }

    public static Iterable<DiscreteProbabilisticDistribution> buildDistributionIterable(ChoiceSelectorDistributionBuilder builder) {
        return new DpdIterable(builder);
    }

    public static interface ChoiceSelectorDistributionBuilder {
        int getSize();
        DiscreteProbabilisticDistribution getDistribution(int observation);
    }

    private static class DpdIterable implements Iterable<DiscreteProbabilisticDistribution> {
        private final ChoiceSelectorDistributionBuilder builder;

        private final AtomicInteger count = new AtomicInteger();
        private final ThreadLocal<Boolean> incremented = new ThreadLocal<Boolean>() {
            @Override
            protected Boolean initialValue() {
                return false;
            }
        };
        private final ThreadLocal<DiscreteProbabilisticDistribution> elements = new ThreadLocal<>();

        private DiscreteProbabilisticDistribution getDistribution(int observation) {
            return builder.getDistribution(observation);
        }

        private DpdIterable(ChoiceSelectorDistributionBuilder builder) {
            this.builder = builder;
        }

        @Override
        public Iterator<DiscreteProbabilisticDistribution> iterator() {
            return new Iterator<DiscreteProbabilisticDistribution>() {
                @Override
                public boolean hasNext() {
                    if (incremented.get())
                        return true;
                    int c = count.get();
                    while (c < builder.getSize()) {
                        if (count.compareAndSet(c,c+1)) {
                            elements.set(getDistribution(c));
                            incremented.set(true);
                            break;
                        }
                        c = count.get();
                    }
                    return incremented.get();
                }

                @Override
                public DiscreteProbabilisticDistribution next() {
                    if (hasNext()) {
                        incremented.set(false);
                        return elements.get();
                    }
                    throw new NoSuchElementException();
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }

    public static DiscreteProbabilisticDistribution getProbabilityDistribution(final DoubleMatrix cumulativeProbabilityMatrix, final int observation) {
        return new AbstractDiscreteProbabilisticDistribution() {
            @Override
            public int getLength() {
                return cumulativeProbabilityMatrix.size(1);
            }

            @Override
            public double getCumulativeValue(int point) {
                return cumulativeProbabilityMatrix.getCell(observation,point);
            }
        };
    }

    public static <C extends Choice> DiscreteProbabilisticDistribution getProbabilityDistribution(final SetList<C> choiceOrder , final Map<C,DoubleVector> probabilities, final int observation) {
        final int length = probabilities.get(choiceOrder.get(0)).size(0);
        return new AbstractDiscreteProbabilisticDistribution() {
            @Override
            public int getLength() {
                return length;
            }

            @Override
            public double getCumulativeValue(int point) {
                return probabilities.get(choiceOrder.get(point)).getCell(observation);
            }
        };
    }
}