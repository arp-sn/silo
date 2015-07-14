package com.pb.sawdust.util.collections;

import java.util.Map;
import java.util.Set;

/**
 * An {@code InjectiveMap} is a map whose keys map to unique values. More specifically, if a key, {@code k}, in a
 * given map maps to a value, {@code v}, then another key in the same map, {@code k'}, can map to any object <i>except</i>
 * {@code v}. Another way of defining the injective map is that its keys and values each belong to a set. Mathematically
 * speaking, a standard {@code java.util.Map} can map many keys to one value, making it surjective, whereas this interface,
 * which only allows one key to any one value, is injective (hence the name).
 * <p>
 * Because of the restrictions desribed above, adding a new key-value pair into a map which already contains the map
 * causes a potential dilemma: if the pair is added, then the previously existing value, and hence its key, must be
 * removed, or, alternatively, the pair could not be added, preserving the already existing key-value mapping. While
 * map instances allow a previously existing key-value pair to be replaced, allowing a key to be removed (dissappear)
 * during a {@code put} operation would be unexpected and a potential source of bugs. Thus, the {@code put} methods (and
 * its derivatives) should throw an exception if the given value already exists. To allow the alternative behavior
 * (remove the existing key-value pair), the {@code forcePut} and {@code forcePutAll} methods are added in this interface.
 *
 * @param <K>
 *        The type of the keys held by this map.
 *
 * @param <V>
 *        The type of the values held by this map.
 *
 * @author crf <br/>
 *         Started: Jun 20, 2008 4:59:29 PM
 */
public interface InjectiveMap<K,V> extends Map<K,V> {

    /**
     * Get the values contained in this mapping. As the map is injective, the values are restricted to be in a
     * set (as opposed to a collection, in the parent {@code Map} interface).
     *
     * @return the set of values contained in this map.
     */
    Set<V> values();

    /**
     * Get the inverse of this map. This inverse will contain as values all of the keys in this map, and as keys all
     * of those keys' respective values. Because the map is injective, the inverse mapping is guaranteed to exist.
     *
     * @return the inverse injective map of this map.
     */
    InjectiveMap<V,K> inverse();

    /**
     * {@inheritDoc}
     *
     * Because putting an already existing value would possibly force the removal of a key, such a method invoacation
     * will cause an exception to be thrown. To get around this restriction, use the {@code forcePut(K,V)} method.
     *
     * @throws IllegalArgumentException if the specified {@code value} already exists in the map.
     */
    V put(K key, V value);

    /**
     * Associate a given key with a given value. This method will always ensure that the specified key-value pair
     * exists in map after this method's execution. This means that, in the case that the value is already used in
     * the map, another map key will be removed silently. To prevent such behavior, use the {@code put(K,V)} method.
     *
     * @param key
     *        The key to associate with the value.
     *
     * @param value
     *        The value to associate with the key.
     *
     * @return the previous value associated with {@code key}, or {@code null} if none existed.
     */
    V forcePut(K key,V value);

    /**
     * Get the key associated with a particular value in this map.
     *
     * @param value
     *        The value in question.
     *
     * @return the key associated with {@code value}.
     */
    K getKey(V value);

    /**
     * Remove this value, as well as its associated key, from this map.
     *
     * @param value
     *        The value to remove from this mapping.
     *
     * @return the key associated with {@code value} which was removed from this map.
     */
    K removeValue(Object value);

    /**
     * {@inheritDoc}
     *
     * Because putting an already existing value would possibly force the removal of a key, such a method invoacation
     * will cause an exception to be thrown. To get around this restriction, use the {@code forcePutAll(Map)} method.
     *
     * @throws IllegalArgumentException if one of the values in {@code m}  already exists in the map.
     */
    void putAll(Map<? extends K, ? extends V> m);

    /**
     * Put all of the mappings in a specified map into this map. If a give value already exists in thsi map, the current
     * key-value pair will be removed before the map is updated. This final state of this map may thus be affected by
     * the iteration order of {@code m}'s mappings.
     *
     * @param m
     *        The map containging the mappings to put in this map.
     */
    void forcePutAll(Map<? extends K, ? extends V> m);
}