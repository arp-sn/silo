package com.pb.sawdust.util.probability;

import com.pb.sawdust.util.Range;

import java.util.Collection;
import java.util.Random;

/**
 * The {@code Discretizer} class provides methods for discretizing (integerizing) sets of non-integer weights.
 *
 * @author crf
 *         Started 9/28/11 10:36 AM
 */
public class Discretizer {
    private final Random random;
    /**
     * Constructor specifying the random number generator used in the discretizer.
     *
     * @param random
     *        The random number generator.
     */
    public Discretizer(Random random) {
        this.random = random;
    }

    /**
     * Default constructor using a default random number generator.
     */
    public Discretizer() {
        this(new Random());
    }


    /**
     * Discretize a collection of weights to match a specified target.
     *
     * @param weights
     *        The weights.
     *
     * @param target
     *        The target value.
     */
    public void discretize(Collection<Weight> weights, int target) {
        discretize(weights);
        shiftDiscretely(weights,target);
    }

    /**
     * Discretize a collection of weights. The process first sets each weight to its integer floor value, retaining the
     * fractional value. The sum of the fractional values is then rounded to get the additional number of "weight units"
     * that need to be added. These are assigned (additively) to the various weights using a Monte Carlo procedure weighted
     * by the fractional value of the initial weight.
     *
     * @param weights
     *        The weights to discretize.
     */
    public void discretize(Collection<Weight> weights) {
        int[] bases = new int[weights.size()];
        double[] fractions = new double[weights.size()];
        double fractionSum = 0.0;
        int counter = 0;
        for (Weight weight : weights) {
            int base = (int) Math.floor(weight.getWeight());
            double fraction = weight.getWeight()-base;
            bases[counter] = base;
            fractions[counter++] = fraction;
            fractionSum += fraction;
        }
        if (fractionSum == 0.0)
            return;
        MonteCarlo mc = MonteCarlo.getMonteCarloFromDistribution(fractions,random);
        for (int i : Range.range((int) Math.round(fractionSum)))
            bases[mc.draw()]++;
        counter = 0;
        for (Weight weight : weights)
            weight.setWeight(bases[counter++]);
    }

    /**
     * Shift weight values by discrete amounts to match a specified target. This is intended to be used for weights which
     * have already been discretized; if the weights aren't integers, then the process will not end with the sum of the
     * weights matching the target exactly, and the weights will not be integerized in the process.
     * <p>
     * The process works by calculating the sum of the weights and then subtracting that from the target value to get the
     * number of "steps" (positive or negative) that need to be taken to match (or closely match) the target. These steps
     * are assigned (additively) to weights via a Monte Carlo procedure weighted by the weight's initial values.
     *
     * @param weights
     *        The weights.
     *
     * @param target
     *        The target value.
     */
    public void shiftDiscretely(Collection<Weight> weights, int target) {
        double[] distribution = new double[weights.size()];
        double sum = 0.0;
        int counter = 0;
        for (Weight weight : weights)
            sum += (distribution[counter++] = weight.getWeight());
        int s = target - (int) Math.round(sum);
        if (s == 0 || sum == 0.0)
            return; //already there or weights are in error
        MonteCarlo mc = MonteCarlo.getMonteCarloFromDistribution(distribution,random);
        int scale = s < 0 ? -1 : 1;
        for (int i : Range.range(s))
            distribution[mc.draw()] += scale;
        counter = 0;
        for (Weight weight : weights)
            weight.setWeight(distribution[counter++]);
    }

    /**
     * Scale weight values by a specified value and discretize. The process simply multiplies the weights by the scale value
     * and then rounds the result.
     *
     * @param weights
     *        The weights.
     *
     * @param scale
     *        The scale value.
     */
    public void scaleDiscretely(Collection<Weight> weights, double scale) {
        double sum = 0.0;
        for (Weight weight : weights)
            sum += weight.getWeight();
        shiftDiscretely(weights,(int) Math.round(sum * scale));
    }
}