package com.pb.sawdust.util;

import java.util.EnumSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 * The {@code JavaType} enum provides a structure for differentiating between Java primitives and objects. Essentially,
 * there is one enum constant for each primitive type, as well as one representing a Java object. This enum will
 * generally be used when dealing with generics, which don't handle primitives, and especially with generics' iteractions
 * with arrays.
 *
 * @author crf <br/>
 *         Started: Jul 8, 2008 2:17:39 PM
 */
public enum JavaType {
    /**
     * Constant representing the {@code byte} primitive type.
     */
    BYTE(true,byte.class,Byte.class,'B',1,new Byte((byte) 0)),
    /**
     * Constant representing the {@code short} primitive type.
     */
    SHORT(true,short.class,Short.class,'S',2,new Short((short) 0)),
    /**
     * Constant representing the {@code int} primitive type.
     */
    INT(true,int.class,Integer.class,'I',4,0),
    /**
     * Constant representing the {@code long} primitive type.
     */
    LONG(true,long.class,Long.class,'J',8,0L),
    /**
     * Constant representing the {@code float} primitive type.
     */
    FLOAT(true,float.class,Float.class,'F',4,0.0f),
    /**
     * Constant representing the {@code double} primitive type.
     */
    DOUBLE(true,double.class,Double.class,'D',8,0.0),
    /**
     * Constant representing the {@code char} primitive type.
     */
    CHAR(true,char.class,Character.class,'C',2,'\u0000'),
    /**
     * Constant representing the {@code boolean} primitive type.
     */
    BOOLEAN(true,boolean.class,Boolean.class,'Z',8,false),
    /**
     * Constant representing the {@code Object} type (<i>i.e.</i> anything non-primitive).
     */
    OBJECT(false,Object.class,Object.class,'L',-1,null);

    private static final Map<Class,JavaType> classMap = new HashMap<>();
    private static final Map<Class,JavaType> primitiveClassMap = new HashMap<>();
    private static final Map<Character,JavaType> componentTypeMap = new HashMap<>();
    private static final Set<JavaType> numericTypes = EnumSet.of(BYTE,SHORT,INT,LONG,FLOAT,DOUBLE);

    static {
        for (JavaType type : values()) {
            classMap.put(type.getClassEquivalent(),type);
            primitiveClassMap.put(type.getClassEquivalent(),type);
            primitiveClassMap.put(type.getObjectEquivalent(),type);
            componentTypeMap.put(type.arrayComponentName,type);
        }
    }

    private final boolean isPrimitive;
    private final Class classEquivalent;
    private final Class objectEquivalent;
    private final char arrayComponentName;
    private final int primitiveSizeInBytes;
    private final Object defaultObject;

    private JavaType(boolean isPrimitive, Class classEquivalent, Class objectEquivalent, char arrayComponentName, int primitiveSizeInBytes, Object defaultObject) {
        this.isPrimitive = isPrimitive;
        this.classEquivalent = classEquivalent;
        this.objectEquivalent = objectEquivalent;
        this.arrayComponentName = arrayComponentName;
        this.primitiveSizeInBytes = primitiveSizeInBytes;
        this.defaultObject = defaultObject;
    }

    /**
     * Indicates whether this enum constant represents a primitive type or not.
     *
     * @return {@code true} if this enum constant represents a primitive type, {@code false} otherwise.
     */
    public boolean isPrimitive() {
        return isPrimitive;
    }

    /**
     * Get the class which corresponds to the type this enum constant represents. For {@code OBJECT}, this will return
     * {@code Object.class}; for all other constants, this method will return their primitive class instance.
     *
     * @return the class corresponding to the type this enum constant represents.
     */
    public Class getClassEquivalent() {
        return classEquivalent;
    }

    /**
     * Get the class which which corresponds to the object equivalent of the type this enum constant represents. For
     * example, {@code BYTE.getObjectEquivalent()} returns the {@code Byte.class} class. For the {@code OBJECT} type,
     * the object equivalent returned is {@code Object.class}.
     *
     * @return the class corresponding to this enum type's object equivalent.
     */
    public Class getObjectEquivalent() {
        return objectEquivalent;
    }

    /**
     * Indicates whether this java type is numeric or not. The numeric types are <code>BYTE</code>, <code>SHORT</code>,
     * <code>INT</code>, <code>LONG</code>, <code>FLOAT</code>, and <code>DOUBLE</code>.
     *
     * @return {@code true} if this type is a numeric type, {@code false} if not.
     */
    public boolean isNumeric() {
        return numericTypes.contains(this);
    }

    /**
     * Return the size in bytes of the primitive equivalent of this java type, as specified by the Java Language Specification.
     * For the {@code BOOLEAN} type, this returns the same as the {@code INT} type; even though the {@code boolean} size
     * is not strictly defined by the JLS, it generally maps to an {@code int} in a JVM.
     *
     * @return the size of this type's associated primitive.
     *
     * @throws IllegalArgumentException if this java type is <code>OBJECT</code>, as it has no associated primitive.
     */
    public int getPrimitiveSize() {
        if (this == OBJECT)
            throw new IllegalArgumentException("No primitive size associated with OBJECT");
        return primitiveSizeInBytes;
    }

    /**
     * Get the default value of this java type, as an object. For type with primitive equivalents, this is the (boxed)
     * object value of the default primitive value specified by the JLS. For the {@code OBJECT} type, this method
     * returns {@code null}.
     *
     * @return the default value of this java type.
     */
    public Object getDefaultObject() {
        return defaultObject;
    }

    /**
     * Get the type associated with a given class. If the class is a primitive, the appropriate {@code JavaType} is
     * returned, otherwise {@code OBJECT} is returned.
     *
     * @param type
     *        The class is question.
     *
     * @return the type corresponding to {@code type}.
     */
    public static JavaType getJavaType(Class<?> type) {
        if (classMap.containsKey(type))
            return classMap.get(type);
        return JavaType.OBJECT;
    }

    /**
     * Get the primtive type associated with a given class. If the class is a primitive, the appropriate {@code JavaType}
     * is returned; if the class is an object equivalent to a primitive class, the appropriate {@code JavaType} corresponding
     * to that primitive class is returned; otherwise {@code OBJECT} is returned.
     *
     * @param type
     *        The class is question.
     *
     * @return the type corresponding to {@code type}.
     */
    public static JavaType getPrimitiveJavaType(Class<?> type) {
        if (primitiveClassMap.containsKey(type))
            return primitiveClassMap.get(type);
        return JavaType.OBJECT;
    }

    /**
     * Determine the component type of an input array. If the input is not a primitive array, then this method will
     * return {@code OBJECT}, as {@code Object[]} is a supertype of all object arrays.
     *
     * @param array
     *        The input array.
     *
     * @return the component type {@code array}.
     *
     * @throws IllegalArgumentException if {@code array} is not a java array.
     */
    public static JavaType getComponentType(Object array) {
        Class arrayClass;
        if (!(arrayClass = array.getClass()).isArray())
            throw new IllegalArgumentException("Input to getComponentType must be java array.");
        Class componentType = arrayClass.getComponentType();
        if (componentType.isPrimitive())
            return classMap.get(componentType);
        else
            return OBJECT;
    }

    /**
     * Get the base component type of an array. The base component type of an array is the final type that the array
     * holds: for one dimensional arrays, this is the same as its componenet type; for multidimensional arrays this is
     * the type that the <i>multidimensional</i> array holds. For example, a {@code byte[][]} array will have a base type
     * of {@code BYTE}, though calling {@code getComponentType(Object)} on it would return {@code OBJECT} since its
     * component class is {@code byte[]}. If the array's base compnoent type not primitive, then {@code OBJECT} will
     * be returned.
     *
     * @param array
     *        The input array.
     *
     * @return the base component type of {@code array}.
     *
     * @throws IllegalArgumentException if {@code array} is not a java array.
     */
    public static JavaType getBaseComponentType(Object array) {
        Class arrayClass;
        if (!(arrayClass = array.getClass()).isArray())
            throw new IllegalArgumentException("Input to getComponentType must be java array.");
        String arrayType = arrayClass.getName();
        return componentTypeMap.get(arrayType.charAt(arrayType.lastIndexOf('[')+1));
    }

    /**
     * Get the type which represents a "widening" conversion when casting between primitives. That is, for the two types
     * being compared, get the type which the other would need to be cast to for a widening conversion. Widening means roughly
     * what the Java Language Specification specifies in section 5.1.  The only exceptions are that {@code BOOLEAN} is
     * always widened to the other type (the JLS doesn't allow casting to/from {@code boolean}s), and {@code CHAR} is always
     * widened to a numeric type (casting between {@code char} and {@code byte} or {@code short} is ambiguous). As it does
     * not apply here, passing {@code OBJECT} as either argument will cause an exception to be thrown.
     *
     * @param type1
     *        The first type.
     *
     * @param type2
     *        The second type.
     *
     * @return the type (among {@code type1} and {@code type2}) which represents the widening direction.
     *
     * @throws IllegalArgumentException if either argument is {@code OBJECT}.
     */
    public static JavaType getWideningType(JavaType type1, JavaType type2) {
        if (!type1.isPrimitive() || !type2.isPrimitive())
            throw new IllegalArgumentException("Widening only applies to primitives.");
        if (type1.isNumeric()) {
            if (type2.isNumeric())
                return type1.ordinal() > type2.ordinal() ? type1 : type2;
            else
                return type1;
        } else {
            if (type2.isNumeric())
                return type2;
            return type1 == BOOLEAN ? type2 : type1;
        }
    }
}