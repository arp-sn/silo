package com.pb.sawdust.util.collections;

import com.pb.sawdust.util.array.ArrayUtil;

import java.util.*;
import java.util.Collection;
import java.util.Iterator;

/**
 * The {@code CollectionOrder} class provides methods for determining the sorting order of a collection. That is, given
 * a collection with a well defined iteration order, and a {@code Comparable} implementation on its contents, this class's
 * methods will return the order in which the collection's contents should be accessed to be correctly sorted.
 *
 * @author crf <br/>
 *         Started Nov 4, 2010 10:10:20 AM
 */
public class CollectionOrder {
    private CollectionOrder() {}

    //old version - seems to be a bit slower because I do my own sorting (slowly and poorly)
    private static <T extends Comparable<T>> int[] getOrder2(Iterable<T> collection, int size, Comparator<T> comparator) {
        final boolean comp = comparator == null;
        List<Integer> values = new LinkedList<Integer>();  //linked list fast for insertions
        List<T> sortedData = size < 0 ? new ArrayList<T>() : new ArrayList<T>(size); //array list not so fast for insertions, but fast for binary search
        int counter = 0;
        for (T dataValue : collection) {
            int insertionPoint = comp ? Collections.binarySearch(sortedData,dataValue,comparator) : Collections.binarySearch(sortedData,dataValue);
            if (insertionPoint < 0)
                insertionPoint = -1*(insertionPoint+1);
            sortedData.add(insertionPoint,dataValue);
            values.add(insertionPoint,counter++);
        }
        return ArrayUtil.toPrimitive(values.toArray(new Integer[values.size()]));
    }


    @SuppressWarnings("unchecked") //loosey goosey with the T[] arrays, but only used internally and won't throw any exceptions if used correctly
    private static <T extends Comparable<T>> int[] getOrder(Iterable<T> collection, int size, Comparator<T> comparator) {
        T[] sortedArray;
        if (size < 0) {
            List<T> sorted = new LinkedList<>();
            for (T t : collection)
                sorted.add(t);
            Collections.sort(sorted,comparator);
            sortedArray = sorted.toArray((T[]) new Comparable[sorted.size()]);
        } else {
            sortedArray = (T[]) new Comparable[size];
            int counter = 0;
            for (T t : collection)
                sortedArray[counter++] = t;
        }
        int[] order = new int[sortedArray.length];
        Arrays.fill(order,-1);
        int counter = 0;
        Comparator c = comparator != null ? comparator : new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 != null)
                    return o1.compareTo(o1);
                else if (o2 != null)
                    return -1*o2.compareTo(o1);
                else
                    return 0;
            }
        };
        for (T t : collection) {
            int location = Arrays.binarySearch(sortedArray,t,comparator);
            if (order[location] > -1) {
                int s = order.length;
                int high = location+1;
                int low = location-1;
                //repeat - search around to find spot - first go high, then low
                outer: while (true) {
                    while (true) {
                        if (high < s && c.compare(t,sortedArray[high]) == 0) {
                            if (order[high] == -1) {
                                location = high;
                                break outer;
                            }
                            high++;
                        } else {
                            break; //no more high
                        }
                    }
                    while (true) {
                        if (low > -1 && c.compare(t,sortedArray[low]) == 0) {
                            if (order[low] == -1) {
                                location = low;
                                break outer;
                            }
                            low--;
                        } else {
                            throw new IllegalStateException("Sort order undefined for some reason.");
                        }
                    }
                }
            }
            order[location] = counter++;
        }
        return order;
    }


    /**
     * Get the sorted order for a specified iterable collection, using the default {@code Comparable} implementation. The returned
     * array will list the (0-based) index order of the sorted elements in the collection.
     *
     * @param collection
     *        The iterable collection.
     *
     * @param <T>
     *        The type held by the collection.
     *
     * @return an array specifying the sorted order of {@code collection}.
     */
    public static <T extends Comparable<T>> int[] getOrder(Iterable<T> collection) {
        return getOrder(collection,-1,null);
    }

    /**
     * Get the sorted order for a specified collection, using the default {@code Comparable} implementation. The returned
     * array will list the (0-based) index order of the sorted elements in the collection.
     *
     * @param collection
     *        The collection.
     *
     * @param <T>
     *        The type held by the collection.
     *
     * @return an array specifying the sorted order of {@code collection}.
     */
    public static <T extends Comparable<T>> int[] getOrder(Collection<T> collection) {
        return getOrder(collection,collection.size(),null);
    }

    /**
     * Get the sorted order for a specified iterable collection, using a specific {@code Comparable} implementation. The returned
     * array will list the (0-based) index order of the sorted elements in the collection.
     *
     * @param collection
     *        The iterable collection.
     *
     * @param comparator
     *        The comparator to use to sort the elements.
     *
     * @param <T>
     *        The type held by the collection.
     *
     * @return an array specifying the sorted order of {@code collection} using {@code comparator}.
     */
    @SuppressWarnings("unchecked") //doing wild castings here that are invalid but are ignored by getOrder, so ok (this is to avoid code duplicaton)
    public static <T> int[] getOrder(Iterable<T> collection, Comparator<T> comparator) {
        return getOrder((Iterable<? extends Comparable>) collection,-1,(Comparator) comparator);
    }

    /**
     * Get the sorted order for a specified collection, using a specific {@code Comparable} implementation. The returned
     * array will list the (0-based) index order of the sorted elements in the collection.
     *
     * @param collection
     *        The collection.
     *
     * @param comparator
     *        The comparator to use to sort the elements.
     *
     * @param <T>
     *        The type held by the collection.
     *
     * @return an array specifying the sorted order of {@code collection} using {@code comparator}.
     */
    @SuppressWarnings("unchecked") //doing wild castings here that are invalid but are ignored by getOrder, so ok (this is to avoid code duplicaton)
    public static <T> int[] getOrder(Collection<T> collection, Comparator<T> comparator) {
        return getOrder((Iterable<? extends Comparable>) collection,collection.size(),(Comparator) comparator);
    }

    /**
     * Get the sorted order for a specified iterable collection, using a reference setlist to define the ordering relationships.
     * The returned array will list the (0-based) index order of the sorted elements in the collection.
     *
     * @param collection
     *        The iterable collection.
     *
     * @param reference
     *        The reference setlist. The order of the elements in this setlist will define the sorting for the collection.
     *
     * @param <T>
     *        The type held by the collection.
     *
     * @return an array specifying the sorted order of {@code collection} using {@code reference} to define the ordering.
     *
     * @throws IllegalArgumentException if any element in {@code collection} is not found in reference, or if the size of {@code collection}
     *                                  is not the same as {@code reference}. //todo: relax this latter restriction
     */
    public static <T> int[] getOrder(Iterable<T> collection, SetList<T> reference) {
        int counter = 0;
        int[] order = new int[reference.size()];
        boolean error = false;
        try {
            for (T element : collection)  {
                int index = reference.indexOf(element);
                if (index < 0)
                    throw new IllegalArgumentException("Collection element not found in reference: " + element);
                order[index] = counter++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            counter = 0;
            for (T element : collection)
                counter++;
            error = true;
        }
        if (error || counter < reference.size())
            throw new IllegalArgumentException(String.format("Iterable collection size (%d) is not equal to reference size (%d)",counter,reference.size()));
        return order;
    }

    /**
     * Get the sorted order for a specified collection, using a reference setlist to define the ordering relationships.
     * The returned array will list the (0-based) index order of the sorted elements in the collection.
     *
     * @param collection
     *        The collection.
     *
     * @param reference
     *        The reference setlist. The order of the elements in this setlist will define the sorting for the collection.
     *
     * @param <T>
     *        The type held by the collection.
     *
     * @return an array specifying the sorted order of {@code collection} using {@code reference} to define the ordering.
     *
     * @throws IllegalArgumentException if any element in {@code collection} is not found in reference, or if the size of {@code collection}
     *                                  is not the same as {@code reference}. //todo: relax this latter restriction
     */
    public static <T> int[] getOrder(Collection<T> collection, SetList<T> reference) {
        if (collection.size() != reference.size())
            throw new IllegalArgumentException(String.format("Collection size (%d) is not equal to reference size (%d)",collection.size(),reference.size()));
        int counter = 0;
        int[] order = new int[reference.size()];
        for (T element : collection) {
            int index = reference.indexOf(element);
            if (index < 0)
                throw new IllegalArgumentException("Collection element not found in reference: " + element);
            order[index] = counter++;
        }
        return order;
    }

    /**
     * Get an iterator over the elements in an iterable collection, sorted according to their natural order.
     *
     * @param collection
     *        The iterable collection.
     *
     * @param <T>
     *        The type held by the collection.
     *
     * @return a naturally sorted iterator over the elements in {@code collection}.
     */
    public static <T extends Comparable<T>> Iterator<T> getOrderedIterator(Iterable<T> collection) {
        return getOrderedIterator(collection,null);
    }

    /**
     * Get an iterator over the elements in a collection, sorted according to their natural order.
     *
     * @param collection
     *        The collection.
     *
     * @param <T>
     *        The type held by the collection.
     *
     * @return a naturally sorted iterator over the elements in {@code collection}.
     */
    public static <T extends Comparable<T>> Iterator<T> getOrderedIterator(Collection<T> collection) {
        return getOrderedIterator(collection);
    }

    /**
     * Get an iterator over the elements in an iterable collection, using a specific {@code Comparable} implementation.
     *
     * @param collection
     *        The iterable collection.
     *
     * @param comparator
     *        The comparator to use to sort the elements.
     *
     * @param <T>
     *        The type held by the collection.
     *
     * @return a naturally sorted iterator over the elements in {@code collection}.
     */
    public static <T extends Comparable<T>> Iterator<T> getOrderedIterator(Iterable<T> collection, final Comparator<T> comparator) {
        final List<T> test = new ArrayList<T>();
        for (T element : collection)
            test.add(element);

        return new Iterator<T>() {
            final int[] order = comparator == null ? getOrder(test) : getOrder(test,comparator);
            private int currentPoint = 0;

            @Override
            public boolean hasNext() {
                return currentPoint < order.length;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return test.get(order[currentPoint++]);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    /**
     * Get an iterator over the elements in a collection, using a specific {@code Comparable} implementation.
     *
     * @param collection
     *        The collection.
     *
     * @param comparator
     *        The comparator to use to sort the elements.
     *
     * @param <T>
     *        The type held by the collection.
     *
     * @return a naturally sorted iterator over the elements in {@code collection}.
     */
    public static <T extends Comparable<T>> Iterator<T> getOrderedIterator(Collection<T> collection, final Comparator<T> comparator) {
        return getOrderedIterator(collection,comparator);
    }
}