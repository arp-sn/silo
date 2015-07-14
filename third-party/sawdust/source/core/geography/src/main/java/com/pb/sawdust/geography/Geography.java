package com.pb.sawdust.geography;

import com.pb.sawdust.util.collections.GenericInjectiveMap;
import com.pb.sawdust.util.collections.InjectiveMap;

import java.util.*;

/**
 * The {@code Geography} class represents a collection of {@code GeographyElement}s. The elements within each geography
 * will all have unique identifiers, and the sum of the elements's sizes specifies the size of the geography. Though
 * the ordering of the elements in the geography is not enforced to be determinate, it generally should be so as to make
 * interoperability with classes using ordered {@code GeographicElement}s (such as {@code GeographicVector}s) consistent
 * and correct.
 * <p>
 * Given the fact that this class is essentially a container for objects which don't appear (at first glance) to have anything
 * specific to do with geographies, it may seem unclear why  this class is named {@code Geography}. The reason for this is
 * because it is intended to be used as an analogue for true geographies (<i>e.g.</i> TAZs or states), and, furthermore,
 * because they are used in geographic specific classes or functions, such as {@code GeographicMapping} or {@code GeographicNeighborhood}.
 * <p>
 * In some respects, a {@code Geography} is similar to a {@code Set<GeographicElement>}. In particular, two geographies
 * are equal if they contain the same elements (irregardless of ordering).
 *
 * @param <I>
 *        The type of the identifiers in the geographic elements.
 *
 * @param <G>
 *        The type of the geographic elements.
 *
 * @author crf
 *         Started 10/17/11 11:09 AM
 */
public class Geography<I,G extends GeographyElement<I>> {
    private final InjectiveMap<I,G> geography;
    private final double size;

    /**
     * Constructor specifying the elements held by the geography.
     *
     * @param elements
     *        The elements for the geography.
     *
     * @throws IllegalArgumentException if any the elements in {@code elements} do not all have unique identifiers.
     */
    public Geography(Collection<G> elements) {
        geography = new GenericInjectiveMap<>(new LinkedHashMap<I,G>(),new LinkedHashMap<G,I>()); //to preserve ordering
        double size = 0.0;
        for (G element : elements) {
            if (geography.put(element.getIdentifier(),element) != null)
                throw new IllegalArgumentException("Geographic elements must have unique identifiers (repeated identifier: " + element.getIdentifier());
            size += element.getSize();
        }
        this.size = size;
    }

    /**
     * Get the set of geographic elements held by this geography. Though ordering is not enforced (the returned collection
     * is a {@code Set}), if possible, a deterministic ordering should be preserved if possible.
     *
     * @return a set of this geography's elements.
     */
    public Set<G> getGeography() {
        return geography.values();
    }

    /**
     * Get the set of identifiers of the geographic elements held by this geography. Though ordering is not enforced (the
     * returned collection is a {@code Set}), if possible, a deterministic ordering should be preserved if possible.
     *
     * @return a set of identifiers for this geography's elements.
     */
    public Set<I> getIdentifiers() {
        return geography.keySet();
    }

    /**
     * Get the geographic element for the specified identifier.
     *
     * @param identifier
     *        The identifier.
     *
     * @return the geographic element corresponding to {@code identifier}.
     *
     * @throws IllegalArgumentException if no element in this geography has the identifier {@code identifier}.
     */
    public G getElement(I identifier) {
        if (!geography.containsKey(identifier))
            throw new IllegalArgumentException("Geographic element with specified identifier not found in this geography: " + identifier);
        return geography.get(identifier);
    }

    /**
     * Determine if this geography contains the specified geographic element.
     *
     * @param element
     *        The element in question.
     *
     * @return {@code true} if this geography contains {@code element}, {@code false} if not.
     */
    public boolean containsElement(G element) {
        return geography.containsValue(element);
    }

    /**
     * Get the number of geographic elements in this geography.
     *
     * @return the number of elements contained by this geography.
     */
    public double getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Geography geography1 = (Geography) o;

        return Double.compare(geography1.size,size) == 0 &&
               geography.equals(geography1.geography);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = geography.hashCode();
        temp = size != +0.0d ? Double.doubleToLongBits(size) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}