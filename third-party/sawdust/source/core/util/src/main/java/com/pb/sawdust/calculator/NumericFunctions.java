package com.pb.sawdust.calculator;

import com.pb.sawdust.util.Range;
import static com.pb.sawdust.util.Range.*;
import com.pb.sawdust.util.format.TextFormat;

import java.util.*;

import static java.lang.Math.*;

/**
 * The {@code NumericFunctions} class contains interfaces and methods related to numerical functions.
 * 
 * @author crf <br/>
 *         Started: Sep 17, 2009 4:21:38 PM
 */
public class NumericFunctions {


    /**
     * Recursively apply a two-argument numeric function to a series of {@code byte}s, starting from the "left".  That is,
     * if the function is {@code f(x,y)} and the arguments are <code>a1</code>, <code>a2</code>, and <code>a3</code>, in
     * that order, then the result of this method would be {@code f(f(a1,a2),a3)}.
     *
     * @param function
     *        The function to apply.
     *
     * @param values
     *        The values the function will be applied to.
     *
     * @return the result of applying {@code function} to {@code values} recursively.
     *
     * @throws IllegalArgumentException if {@code values.length < 2}.
     */
    public static byte foldLeft(NumericFunction2 function, byte ... values) {
        if (values.length <= 1)
            throw new IllegalArgumentException("Values must contain at least two elements, found " + values.length);
        byte result = values[0];
        for (int i = 1; i < values.length; i++)
            result = function.apply(result,values[i]);
        return result;
    }

    /**
     * Recursively apply a two-argument numeric function to a series of {@code byte}s, starting from the "right".  That is,
     * if the function is {@code f(x,y)} and the arguments are <code>a1</code>, <code>a2</code>, and <code>a3</code>, in
     * that order, then the result of this method would be {@code f(a1,f(a2,a3))}.
     *
     * @param function
     *        The function to apply.
     *
     * @param values
     *        The values the function will be applied to.
     *
     * @return the result of applying {@code function} to {@code values} recursively.
     *
     * @throws IllegalArgumentException if {@code values.length < 2}.
     */
    public static byte foldRight(NumericFunction2 function, byte ... values) {
        int len = values.length;
        if (len <= 1)
            throw new IllegalArgumentException("Values must contain at least two elements, found " + values.length);
        byte result = values[len-1];
        for (int i = len-2; i >= 0; i--)
            result = function.apply(values[i],result);
        return result;
    }

    /**
     * Recursively apply a two-argument numeric function to a series of {@code short}s, starting from the "left".  That is,
     * if the function is {@code f(x,y)} and the arguments are <code>a1</code>, <code>a2</code>, and <code>a3</code>, in
     * that order, then the result of this method would be {@code f(f(a1,a2),a3)}.
     *
     * @param function
     *        The function to apply.
     *
     * @param values
     *        The values the function will be applied to.
     *
     * @return the result of applying {@code function} to {@code values} recursively.
     *
     * @throws IllegalArgumentException if {@code values.length < 2}.
     */
    public static short foldLeft(NumericFunction2 function, short ... values) {
        if (values.length <= 1)
            throw new IllegalArgumentException("Values must contain at least two elements, found " + values.length);
        short result = values[0];
        for (int i = 1; i < values.length; i++)
            result = function.apply(result,values[i]);
        return result;
    }

    /**
     * Recursively apply a two-argument numeric function to a series of {@code short}s, starting from the "right".  That is,
     * if the function is {@code f(x,y)} and the arguments are <code>a1</code>, <code>a2</code>, and <code>a3</code>, in
     * that order, then the result of this method would be {@code f(a1,f(a2,a3))}.
     *
     * @param function
     *        The function to apply.
     *
     * @param values
     *        The values the function will be applied to.
     *
     * @return the result of applying {@code function} to {@code values} recursively.
     *
     * @throws IllegalArgumentException if {@code values.length < 2}.
     */
    public static short foldRight(NumericFunction2 function, short ... values) {
        int len = values.length;
        if (len <= 1)
            throw new IllegalArgumentException("Values must contain at least two elements, found " + values.length);
        short result = values[len-1];
        for (int i = len-2; i >= 0; i--)
            result = function.apply(values[i],result);
        return result;
    }

    /**
     * Recursively apply a two-argument numeric function to a series of {@code int}s, starting from the "left".  That is,
     * if the function is {@code f(x,y)} and the arguments are <code>a1</code>, <code>a2</code>, and <code>a3</code>, in
     * that order, then the result of this method would be {@code f(f(a1,a2),a3)}.
     *
     * @param function
     *        The function to apply.
     *
     * @param values
     *        The values the function will be applied to.
     *
     * @return the result of applying {@code function} to {@code values} recursively.
     *
     * @throws IllegalArgumentException if {@code values.length < 2}.
     */
    public static int foldLeft(NumericFunction2 function, int ... values) {
        if (values.length <= 1)
            throw new IllegalArgumentException("Values must contain at least two elements, found " + values.length);
        int result = values[0];
        for (int i = 1; i < values.length; i++)
            result = function.apply(result,values[i]);
        return result;
    }

    /**
     * Recursively apply a two-argument numeric function to a series of {@code int}s, starting from the "right".  That is,
     * if the function is {@code f(x,y)} and the arguments are <code>a1</code>, <code>a2</code>, and <code>a3</code>, in
     * that order, then the result of this method would be {@code f(a1,f(a2,a3))}.
     *
     * @param function
     *        The function to apply.
     *
     * @param values
     *        The values the function will be applied to.
     *
     * @return the result of applying {@code function} to {@code values} recursively.
     *
     * @throws IllegalArgumentException if {@code values.length < 2}.
     */
    public static int foldRight(NumericFunction2 function, int ... values) {
        int len = values.length;
        if (len <= 1)
            throw new IllegalArgumentException("Values must contain at least two elements, found " + values.length);
        int result = values[len-1];
        for (int i = len-2; i >= 0; i--)
            result = function.apply(values[i],result);
        return result;
    }

    /**
     * Recursively apply a two-argument numeric function to a series of {@code long}s, starting from the "left".  That is,
     * if the function is {@code f(x,y)} and the arguments are <code>a1</code>, <code>a2</code>, and <code>a3</code>, in
     * that order, then the result of this method would be {@code f(f(a1,a2),a3)}.
     *
     * @param function
     *        The function to apply.
     *
     * @param values
     *        The values the function will be applied to.
     *
     * @return the result of applying {@code function} to {@code values} recursively.
     *
     * @throws IllegalArgumentException if {@code values.length < 2}.
     */
    public static long foldLeft(NumericFunction2 function, long ... values) {
        if (values.length <= 1)
            throw new IllegalArgumentException("Values must contain at least two elements, found " + values.length);
        long result = values[0];
        for (int i = 1; i < values.length; i++)
            result = function.apply(result,values[i]);
        return result;
    }

    /**
     * Recursively apply a two-argument numeric function to a series of {@code long}s, starting from the "right".  That is,
     * if the function is {@code f(x,y)} and the arguments are <code>a1</code>, <code>a2</code>, and <code>a3</code>, in
     * that order, then the result of this method would be {@code f(a1,f(a2,a3))}.
     *
     * @param function
     *        The function to apply.
     *
     * @param values
     *        The values the function will be applied to.
     *
     * @return the result of applying {@code function} to {@code values} recursively.
     *
     * @throws IllegalArgumentException if {@code values.length < 2}.
     */
    public static long foldRight(NumericFunction2 function, long ... values) {
        int len = values.length;
        if (len <= 1)
            throw new IllegalArgumentException("Values must contain at least two elements, found " + values.length);
        long result = values[len-1];
        for (int i = len-2; i >= 0; i--)
            result = function.apply(values[i],result);
        return result;
    }

    /**
     * Recursively apply a two-argument numeric function to a series of {@code float}s, starting from the "left".  That is,
     * if the function is {@code f(x,y)} and the arguments are <code>a1</code>, <code>a2</code>, and <code>a3</code>, in
     * that order, then the result of this method would be {@code f(f(a1,a2),a3)}.
     *
     * @param function
     *        The function to apply.
     *
     * @param values
     *        The values the function will be applied to.
     *
     * @return the result of applying {@code function} to {@code values} recursively.
     *
     * @throws IllegalArgumentException if {@code values.length < 2}.
     */
    public static float foldLeft(NumericFunction2 function, float ... values) {
        if (values.length <= 1)
            throw new IllegalArgumentException("Values must contain at least two elements, found " + values.length);
        float result = values[0];
        for (int i = 1; i < values.length; i++)
            result = function.apply(result,values[i]);
        return result;
    }

    /**
     * Recursively apply a two-argument numeric function to a series of {@code float}s, starting from the "right".  That is,
     * if the function is {@code f(x,y)} and the arguments are <code>a1</code>, <code>a2</code>, and <code>a3</code>, in
     * that order, then the result of this method would be {@code f(a1,f(a2,a3))}.
     *
     * @param function
     *        The function to apply.
     *
     * @param values
     *        The values the function will be applied to.
     *
     * @return the result of applying {@code function} to {@code values} recursively.
     *
     * @throws IllegalArgumentException if {@code values.length < 2}.
     */
    public static float foldRight(NumericFunction2 function, float ... values) {
        int len = values.length;
        if (len <= 1)
            throw new IllegalArgumentException("Values must contain at least two elements, found " + values.length);
        float result = values[len-1];
        for (int i = len-2; i >= 0; i--)
            result = function.apply(values[i],result);
        return result;
    }

    /**
     * Recursively apply a two-argument numeric function to a series of {@code double}s, starting from the "left".  That is,
     * if the function is {@code f(x,y)} and the arguments are <code>a1</code>, <code>a2</code>, and <code>a3</code>, in
     * that order, then the result of this method would be {@code f(f(a1,a2),a3)}.
     *
     * @param function
     *        The function to apply.
     *
     * @param values
     *        The values the function will be applied to.
     *
     * @return the result of applying {@code function} to {@code values} recursively.
     *
     * @throws IllegalArgumentException if {@code values.length < 2}.
     */
    public static double foldLeft(NumericFunction2 function, double ... values) {
        if (values.length <= 1)
            throw new IllegalArgumentException("Values must contain at least two elements, found " + values.length);
        double result = values[0];
        for (int i = 1; i < values.length; i++)
            result = function.apply(result,values[i]);
        return result;
    }

    /**
     * Recursively apply a two-argument numeric function to a series of {@code double}s, starting from the "right".  That is,
     * if the function is {@code f(x,y)} and the arguments are <code>a1</code>, <code>a2</code>, and <code>a3</code>, in
     * that order, then the result of this method would be {@code f(a1,f(a2,a3))}.
     *
     * @param function
     *        The function to apply.
     *
     * @param values
     *        The values the function will be applied to.
     *
     * @return the result of applying {@code function} to {@code values} recursively.
     *
     * @throws IllegalArgumentException if {@code values.length < 2}.
     */
    public static double foldRight(NumericFunction2 function, double ... values) {
        int len = values.length;
        if (len <= 1)
            throw new IllegalArgumentException("Values must contain at least two elements, found " + values.length);
        double result = values[len-1];
        for (int i = len-2; i >= 0; i--)
            result = function.apply(values[i],result);
        return result;
    }

    public static NumericFunction1 collapsedFunction(NumericFunction2 function, double dc, boolean firstArgumentConstant) {
        return collapsedFunction(function,dc,0,true,firstArgumentConstant);
    }

    public static NumericFunction1 collapsedFunction(NumericFunction2 function, long lc, boolean firstArgumentConstant) {
        return collapsedFunction(function,0.0,lc,false,firstArgumentConstant);
    }

    private static NumericFunction1 collapsedFunction(NumericFunction2 function, double dc, long lc, final boolean useDouble, final boolean firstArgumentConstant) {
        final double dv = useDouble ? dc : (double) lc;
        final long lv = useDouble ? (long) dc : lc;
        final NumericFunction2 nf = firstArgumentConstant ? NumericFunction2.mirror(function) : function;
        return new NumericFunction1.FlexFunction1() {
            @Override
            public long apply(long x) {
                return nf.apply(x,lv);
            }

            @Override
            public double apply(double x) {
                return nf.apply(x,dv);
            }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                String originalFormat = nf.getSymbolicFormat(argumentFormat);
                String placeholder = "(-yeslp=)"; //sufficiently random
                String arg1Format = argumentFormat.getFormat(1);
                String arg2Format = argumentFormat.getFormat(2);
                if (firstArgumentConstant) {
                    originalFormat = originalFormat.replace(arg2Format,placeholder);
                } else {
                    originalFormat = originalFormat.replace(arg1Format,placeholder).replace(arg2Format,arg1Format);
                }
                originalFormat = String.format(originalFormat,useDouble ? (Number) dv : (Number) lv);
                return originalFormat.replace(placeholder,arg1Format);
            }
        };
    }

    private static class CompositeNumericFunctionParameter extends CompositeNumericFunction {
        private CompositeNumericFunctionParameter(String name) {
            super(name + " (Numeric Function Parameter)");
        }
    }

    /**
     * The default {@code NumericFunctionN} used to specify parameters in the {@code CompositeNumericFunction} constructor.
     */
    public static final CompositeNumericFunction PARAMETER = new CompositeNumericFunctionParameter("PARAMETER");

    /**
     * Get a {@code NumericFunctionN} used to specify parameters in the {@code CompositeNumericFunction} constructor.
     *
     * @param parameterName
     *        The name of the parameter.
     *
     * @return a composite numeric function parameter named {@code parameterName}.
     */
    public static NumericFunctionN parameter(String parameterName) {
        return new CompositeNumericFunctionParameter(parameterName);
    }

    /**
     * Get a numeric function built from other numeric functions. The composite function is specified as a combination
     * of {@code NumericFunctionN} functions and parameters (indicated by {@link com.pb.sawdust.calculator.NumericFunctions#PARAMETER})
     * listed in reverse-polish notation.  For example, to specify the function {@code f(x,y,z) = (x+y)*z}, the following call
     * would be made (this assumes {@code import static com.pb.sawdust.calculator.NumericFunctions.*}):
     * <pre>
     *     <code>compositeNumericFunction(PARAMETER,PARAMETER,ADD,PARAMETER,MULTIPLY);</code>
     * </pre>
     *
     * @param reversePolishFunctions
     *        The functions and parameters specified in reverse-polish notation.
     *
     * @return the composite function built from {@code reversePolishFunctions}.
     */
    public static NumericFunctionN compositeNumericFunction(NumericFunctionN ... reversePolishFunctions) {
        return new CompositeNumericFunction(reversePolishFunctions);
    }

    /**
     * Get a numeric function built from other numeric functions. The composite function is specified as a combination
     * of {@code NumericFunctionN} functions and parameters (indicated by {@link com.pb.sawdust.calculator.NumericFunctions#PARAMETER})
     * listed in reverse-polish notation.  For example, to specify the function {@code f(x,y,z) = (x+y)*z}, the following call
     * would be made (this assumes {@code import static com.pb.sawdust.calculator.NumericFunctions.*}):
     * <pre>
     *     <code>compositeNumericFunction(PARAMETER,PARAMETER,ADD,PARAMETER,MULTIPLY);</code>
     * </pre>
     *
     * @param reversePolishFunctions
     *        The functions and parameters specified in reverse-polish notation.
     *
     * @return the composite function built from {@code reversePolishFunctions}.
     */
    public static NumericFunctionN compositeNumericFunction(List<NumericFunctionN> reversePolishFunctions) {
        return new CompositeNumericFunction(reversePolishFunctions.toArray(new NumericFunctionN[reversePolishFunctions.size()]));
    }

    private static class CompositeNumericFunction extends NumericFunctionN {
        private static final String ARGUMENT_PLACEHOLDER_PREFIX = "%%ARG_%%";

        private final ThreadLocal<byte[]> byteStack;
        private final ThreadLocal<short[]> shortStack;
        private final ThreadLocal<int[]> intStack;
        private final ThreadLocal<long[]> longStack;      
        private final ThreadLocal<float[]> floatStack;
        private final ThreadLocal<double[]> doubleStack;
        private final NumericFunctionN[] functions;
        private final int[] fPointers;
        private final int[] pPointers;
        private final String prettyString;
        private final String symbolicTemplate;

        private CompositeNumericFunction(String parameterName) {
            byteStack = null;
            shortStack = null;
            intStack = null;
            longStack = null;  
            floatStack = null;
            doubleStack = null;
            functions = null;
            fPointers = null;
            pPointers = null;
            prettyString = parameterName;
            symbolicTemplate = parameterName;
        }

        private CompositeNumericFunction(NumericFunctionN ... reversePolishFunctions) {
            if (reversePolishFunctions.length < 1)
                throw new IllegalArgumentException("Composite numeric function must be composed of at least one argument.");
            if (!(reversePolishFunctions[0] instanceof CompositeNumericFunctionParameter))
                throw new IllegalArgumentException("Composite numeric function's first (reverse polish) argument must be a parameter: " + reversePolishFunctions[0]);
            if (reversePolishFunctions.length == 1)
                reversePolishFunctions = new NumericFunctionN[] {reversePolishFunctions[0],NumericFunctions.getPlaceholderFunction("")};
            List<NumericFunctionN> funcs = new LinkedList<NumericFunctionN>();
            Map<Integer,Integer> pPoints = new HashMap<Integer,Integer>();
            Map<Integer,Integer> fPoints = new HashMap<Integer,Integer>();

            Deque<Integer> stack = new LinkedList<Integer>();
            StringBuilder s = new StringBuilder("Numeric function N [reverse polish]:\n\t");

            Deque<String> symbolicStack = new LinkedList<String>();
            TextFormat format = new TextFormat(TextFormat.Conversion.STRING);

            int counter = 0;
            int parameterCount = 0;
            for (NumericFunctionN nf : reversePolishFunctions) {
                if (nf instanceof CompositeNumericFunctionParameter) {
                    stack.push(parameterCount++);
                    symbolicStack.push(ARGUMENT_PLACEHOLDER_PREFIX + parameterCount); //parameters indexed by 1 in here
                } else {
                    funcs.add(nf);
                    int[] args = new int[nf.getArgumentCount()];
                    for (int i : new Range(args.length-1,-1)) //when popped they are in reverse order of application
                        args[i] = stack.pop();
                    for (int i : args)
                        if (i < 0)
                            //function
                            fPoints.put(-1*i-1,counter++);
                        else 
                            //parameter
                            pPoints.put(i,counter++);
                    stack.push(-1*funcs.size());

                    String symbolicFunction = nf.getSymbolicFormat(format);
                    for (int i : range(nf.getArgumentCount(),0))  //reverse order of application
                        symbolicFunction = symbolicFunction.replace(format.getFormat(i),symbolicStack.pop());
                    symbolicStack.push("(" + symbolicFunction + ")"); //todo: someday remove parentheses where possible - need order of operations information to do this
                }
                s.append("\n\t").append(nf);
            }
            prettyString = s.toString();
            symbolicTemplate = symbolicStack.pop();

            fPoints.put(-1 * stack.pop() - 1, counter);
            if (stack.size() != 0)
                throw new IllegalArgumentException("Function list invalid, all function results are not used.");
            final int count = 1+counter;                                
            byteStack = new ThreadLocal<byte[]>() {
                public byte[] initialValue() {
                    return new byte[count];
                }
            };                       
            shortStack = new ThreadLocal<short[]>() {
                public short[] initialValue() {
                    return new short[count];
                }
            };                       
            intStack = new ThreadLocal<int[]>() {
                public int[] initialValue() {
                    return new int[count];
                }
            };
            longStack = new ThreadLocal<long[]>() {
                public long[] initialValue() {
                    return new long[count];
                }
            };                          
            floatStack = new ThreadLocal<float[]>() {
                public float[] initialValue() {
                    return new float[count];
                }
            };                     
            doubleStack = new ThreadLocal<double[]>() {
                public double[] initialValue() {
                    return new double[count];
                }
            };
            functions = funcs.toArray(new NumericFunctionN[funcs.size()]);
            pPointers = new int[pPoints.size()];
            for (Integer i : pPoints.keySet()) 
                pPointers[i] = pPoints.get(i);                           
            fPointers = new int[fPoints.size()];
            for (Integer i : fPoints.keySet()) 
                fPointers[i] = fPoints.get(i);
        }

        public int getArgumentCount() {
            return pPointers.length;
        }     

        protected byte applyUncheckedByte(int start, byte ... values) {
            byte[] stack = byteStack.get();
            for (int pPointer : pPointers)
                stack[pPointer] = values[start++];
            int point = 0;
            for (int i = 0; i < fPointers.length; i++) {
                stack[fPointers[i]] = functions[i].applyUncheckedByte(point,stack);
                point += functions[i].getArgumentCount();
            }
            return stack[stack.length-1];
        }   

        protected short applyUncheckedShort(int start, short ... values) {
            short[] stack = shortStack.get();
            for (int pPointer : pPointers)
                stack[pPointer] = values[start++];
            int point = 0;
            for (int i = 0; i < fPointers.length; i++) {
                stack[fPointers[i]] = functions[i].applyUncheckedShort(point,stack);
                point += functions[i].getArgumentCount();
            }
            return stack[stack.length-1];
        }   

        protected int applyUncheckedInt(int start, int ... values) {
            int[] stack = intStack.get();
            for (int pPointer : pPointers)
                stack[pPointer] = values[start++];
            int point = 0;
            for (int i = 0; i < fPointers.length; i++) {
                stack[fPointers[i]] = functions[i].applyUncheckedInt(point,stack);
                point += functions[i].getArgumentCount();
            }
            return stack[stack.length-1];
        }   

        protected long applyUncheckedLong(int start, long ... values) {
            long[] stack = longStack.get();
            for (int pPointer : pPointers)
                stack[pPointer] = values[start++];
            int point = 0;
            for (int i = 0; i < fPointers.length; i++) {
                stack[fPointers[i]] = functions[i].applyUncheckedLong(point,stack);
                point += functions[i].getArgumentCount();
            }
            return stack[stack.length-1];
        }    

        protected float applyUncheckedFloat(int start, float ... values) {
            float[] stack = floatStack.get();
            for (int pPointer : pPointers)
                stack[pPointer] = values[start++];
            int point = 0;
            for (int i = 0; i < fPointers.length; i++) {
                stack[fPointers[i]] = functions[i].applyUncheckedFloat(point,stack);
                point += functions[i].getArgumentCount();
            }
            return stack[stack.length-1];
        } 

        protected double applyUncheckedDouble(int start, double ... values) {
            double[] stack = doubleStack.get();
            for (int pPointer : pPointers)
                stack[pPointer] = values[start++];
            int point = 0;
            for (int i = 0; i < fPointers.length; i++) {
                stack[fPointers[i]] = functions[i].applyUncheckedDouble(point,stack);
                point += functions[i].getArgumentCount();
            }
            return stack[stack.length-1];
        }   

        //todo: think of a better way to apply NumericValuesProvider so that data calls are not into array but direct and recursive
        protected byte applyUncheckedByte(int start, NumericValuesProvider values) {
            byte[] stack = byteStack.get();
            for (int pPointer : pPointers)
                stack[pPointer] = values.getByte(start++);
            int point = 0;
            for (int i = 0; i < fPointers.length; i++) {
                stack[fPointers[i]] = functions[i].applyUncheckedByte(point,stack);
                point += functions[i].getArgumentCount();
            }
            return stack[stack.length-1];
        }   

        protected short applyUncheckedShort(int start, NumericValuesProvider values) {
            short[] stack = shortStack.get();
            for (int pPointer : pPointers)
                stack[pPointer] = values.getShort(start++);
            int point = 0;
            for (int i = 0; i < fPointers.length; i++) {
                stack[fPointers[i]] = functions[i].applyUncheckedShort(point,stack);
                point += functions[i].getArgumentCount();
            }
            return stack[stack.length-1];
        }   

        protected int applyUncheckedInt(int start, NumericValuesProvider values) {
            int[] stack = intStack.get();
            for (int pPointer : pPointers)
                stack[pPointer] = values.getInt(start++);
            int point = 0;
            for (int i = 0; i < fPointers.length; i++) {
                stack[fPointers[i]] = functions[i].applyUncheckedInt(point,stack);
                point += functions[i].getArgumentCount();
            }
            return stack[stack.length-1];
        }   

        protected long applyUncheckedLong(int start, NumericValuesProvider values) {
            long[] stack = longStack.get();
            for (int pPointer : pPointers)
                stack[pPointer] = values.getLong(start++);
            int point = 0;
            for (int i = 0; i < fPointers.length; i++) {
                stack[fPointers[i]] = functions[i].applyUncheckedLong(point,stack);
                point += functions[i].getArgumentCount();
            }
            return stack[stack.length-1];
        }    

        protected float applyUncheckedFloat(int start, NumericValuesProvider values) {
            float[] stack = floatStack.get();
            for (int pPointer : pPointers)
                stack[pPointer] = values.getFloat(start++);
            int point = 0;
            for (int i = 0; i < fPointers.length; i++) {
                stack[fPointers[i]] = functions[i].applyUncheckedFloat(point,stack);
                point += functions[i].getArgumentCount();
            }
            return stack[stack.length-1];
        } 

        protected double applyUncheckedDouble(int start, NumericValuesProvider values) {
            double[] stack = doubleStack.get();
            for (int pPointer : pPointers)
                stack[pPointer] = values.getDouble(start++);
            int point = 0;
            for (int i = 0; i < fPointers.length; i++) {
                stack[fPointers[i]] = functions[i].applyUncheckedDouble(point,stack);
                point += functions[i].getArgumentCount();
            }
            return stack[stack.length-1];
        }   

        public String toString() {
            return prettyString;
        }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            if (functions == null)
                return prettyString;
            String format = symbolicTemplate;
            for (int i : range(1,getArgumentCount()+1))
                format = format.replace(ARGUMENT_PLACEHOLDER_PREFIX + i,argumentFormat.getFormat(i));
            return format;
        }
    }

    //function 0

    /**
     * Get a constant-valued numeric function.  This (zero-argument) function can be used in the
     * {@code CompositeNumericFunction} constructor to specify constant values.
     *
     * @param value
     *        The constant value.
     *
     * @return a function which always returns {@code value}.
     */
    public static NumericFunction0 constant(final double value) {
        return new NumericFunction0.FlexFunction0("constant") {

            @Override
            protected long getLongValue() {
                return (long) value;
            }

            @Override
            protected double getDoubleValue() {
                return value;
            }
        };
    }

    /**
     * Get a constant-valued numeric function.  This (zero-argument) function can be used in the
     * {@code CompositeNumericFunction} constructor to specify constant values.
     *
     * @param value
     *        The constant value.
     *
     * @return a function which always returns {@code value}.
     */
    public static NumericFunction0 constant(final long value) {
        return new NumericFunction0.FlexFunction0("constant") {

            @Override
            protected long getLongValue() {
                return value;
            }

            @Override
            protected double getDoubleValue() {
                return (double) value;
            }
        };
    }


    //function 1

    /**
     * Get a placeholder ("do-nothing") function with a given name. This method can be useful when a calculation will
     * involve processes which occur outside of the scope of the numeric function calculations, but whose occurance
     * need to be noted/annotated in some fashion. The returned function will pass through any argument unchanged.
     *
     * @param name
     *        The name for the function.
     *
     * @return a placeholder function named {@code name}.
     */
    public static NumericFunction1 getPlaceholderFunction(String name) {
        return new NumericFunction1.FlexFunction1(name) {
            public int apply(int x) { return x; }
            public long apply(long x) {  return x; }
            public float apply(float x) {  return x; }
            public double apply(double x) {  return x; }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return getName() + "(" + argumentFormat.getFormat(1) + ")";
            }
        };
    }

    /**
     * The function which returns argument unchanged.
     */
    public static final NumericFunction1 PASS = getPlaceholderFunction("pass");

    /**
     * The function which returns the result of an argument times {@code -1}.
     */
    public static final NumericFunction1 NEGATE = new NumericFunction1.FlexFunction1("negate") {
        public int apply(int x) {  return -x; }
        public long apply(long x) {  return -x; }
        public float apply(float x) {  return -x; }
        public double apply(double x) {  return -x; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder("-1*").append(argumentFormat.getFormat(1)).toString();
        }
    };

    /**
     * The function which returns the absolute value of an argument.
     */
    public static final NumericFunction1 ABS = new NumericFunction1.FlexFunction1("abs") {
        public int apply(int x) {  return abs(x); }
        public long apply(long x) {  return abs(x); }
        public float apply(float x) {  return abs(x); }
        public double apply(double x) {  return abs(x); }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder("|").append(argumentFormat.getFormat(1)).append("|").toString();
        }
    };

    /**
     * The function which returns the result of the number {@code e} to the power of the argument.
     */
    public static final NumericFunction1 EXP = new NumericFunction1.DecimalFunction1("exp") {
        public double apply(double x) {  return exp(x); }
    };

    /**
     * The function which returns the natural logarithm of the argument.
     */
    public static final NumericFunction1 LOG = new NumericFunction1.DecimalFunction1("log") {
        public double apply(double x) {  return log(x); }
    };

    /**
     * Minimum value that will be returned by {@link #ZERO_SAFE_LOG}.
     */
    public static final double ZERO_SAFE_LOG_MIN = -999;

    /**
     * The function which returns the natural logarithm of the argument, unless the argument is less than or equal to
     * {@link #ZERO_SAFE_LOG_MIN}, in which case {@code ZERO_SAFE_LOG_MIN} is returned. If the argument is less than
     * zero, then the normal log function will be applied.
     */
    public static final NumericFunction1 ZERO_SAFE_LOG = boundedSafeLog(ZERO_SAFE_LOG_MIN);

    /**
     * Get a function which returns the natural logarithm of its argument, unless that (non-negative) argument is less
     * then a cutoff, in which case it returns a specified lower bound. Specifically, if the argument is non-negative
     * but less than <code>exp(lowerBound)</code> then the function returns <code>lowerBound</code>. This prevents situations
     * where very small numbers can produce errors (especially when used in other calculations) when taking their natural
     * logarithm. Negative numbers will be run through the natural logarithm function as usual (producing <code>NaN</code>).
     *
     * @param lowerBound
     *        The lower bound for the function's return value.
     *
     * @return a natural logarithm function bounded at {@code lowerBound}.
     */
    public static NumericFunction1 boundedSafeLog(final double lowerBound) {
        final double cutoff = exp(lowerBound); //so if anything is below cutoff (but non-negative), then
                                               //returns log(cutoff) = log(exp(lowerBound)) = lowerBound
        return new NumericFunction1.DecimalFunction1("log bounded at " + lowerBound) {
            public double apply(double x) { return (x >= 0 && x <= cutoff) ? lowerBound : log(x); }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return "log (" + argumentFormat.getFormat(1) + ") bounded at " + lowerBound;
            }
        };
    }

    /**
     * The function which returns the ceiling (next highest integer) of the argument.
     */
    public static final NumericFunction1 CEIL = new NumericFunction1.DecimalFunction1("ceil") {
        public double apply(double x) {  return ceil(x); }
    };

    /**
     * The function which returns the floor (next lowest integer) of the argument.
     */
    public static final NumericFunction1 FLOOR = new NumericFunction1.DecimalFunction1("floor") {
        public double apply(double x) {  return floor(x); }
    };

    /**
     * The function which returns the result of rounding the argument.
     */
    public static final NumericFunction1 ROUND = new NumericFunction1.DecimalFunction1("round") {
        public float apply(float x) {  return round(x); }
        public double apply(double x) {  return round(x); }
    };

    /**
     * The function which returns the signum of the argument.  That is, the value {@code Math.signum(x)}.
     */
    public static final NumericFunction1 SIGN = new NumericFunction1.DecimalFunction1("sign") {
        public float apply(float x) {  return signum(x); }
        public double apply(double x) {  return signum(x); }
    };

    //function 2
    /**
     * The function which returns the addition of two arguments.
     */
    public static final NumericFunction2 ADD = new NumericFunction2.FlexFunction2("add") {
        public int apply(int x, int y) {  return x+y; }
        public long apply(long x, long y) { return x+y; }
        public float apply(float x, float y) { return x+y; }
        public double apply(double x, double y) { return x+y; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append("+").append((argumentFormat.getFormat(2))).toString();
        }
    };

    /**
     * The function which returns subtraction of two arguments.
     */
    public static final NumericFunction2 SUBTRACT = new NumericFunction2.FlexFunction2("subtract") {
        public int apply(int x, int y) {  return x-y; }
        public long apply(long x, long y) { return x-y; }
        public float apply(float x, float y) { return x-y; }
        public double apply(double x, double y) { return x-y; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append("-").append((argumentFormat.getFormat(2))).toString();
        }
    };    

    /**
     * The function which return the multiplication of two arguments.
     */
    public static final NumericFunction2 MULTIPLY = new NumericFunction2.FlexFunction2("multiply") {
        public int apply(int x, int y) {  return x*y; }
        public long apply(long x, long y) { return x*y; }
        public float apply(float x, float y) { return x*y; }
        public double apply(double x, double y) { return x*y; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append("*").append((argumentFormat.getFormat(2))).toString();
        }
    };

    /**
     * The function which returns the division of two arguments.
     */
    public static final NumericFunction2 DIVIDE = new NumericFunction2.FlexFunction2("divide") {
        public int apply(int x, int y) {  return x/y; }
        public long apply(long x, long y) { return x/y; }
        public float apply(float x, float y) { return x/y; }
        public double apply(double x, double y) { return x/y; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append("/").append((argumentFormat.getFormat(2))).toString();
        }
    };

    /**
     * The function which returns the division of two arguments, unless both arguments are zero, in which case 0 is returned.
     */
    public static final NumericFunction2 ZERO_SAFE_DIVIDE = new NumericFunction2.FlexFunction2("zero_safe_divide") {
        public int apply(int x, int y) {  return y == 0 && x == y ? 0 : x/y; }
        public long apply(long x, long y) { return y == 0L && x == y ? 0L : x/y; }
        public float apply(float x, float y) { return y == 0.0f && x == y ? 0.0f : x/y; }
        public double apply(double x, double y) { return y == 0.0 && x == y ? 0.0 : x/y; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append("/").append((argumentFormat.getFormat(2))).toString();
        }
    };

    /**
     * The function which returns the division of two arguments, unless the denominator is zero, in which case 0 is returned.
     */
    public static final NumericFunction2 ZERO_SAFE_DENOMINATOR_DIVIDE = new NumericFunction2.FlexFunction2("zero_safe_denominator_divide") {
        public int apply(int x, int y) {  return y == 0 ? 0 : x/y; }
        public long apply(long x, long y) { return y == 0L ? 0L : x/y; }
        public float apply(float x, float y) { return y == 0.0f ? 0.0f : x/y; }
        public double apply(double x, double y) { return y == 0.0 ? 0.0 : x/y; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append("/").append((argumentFormat.getFormat(2))).toString();
        }
    };

    /**
     * The function returns the modulo division (%) of two arguments.
     */
    public static final NumericFunction2 MODULO_DIVIDE = new NumericFunction2.FlexFunction2("moduulo_divide") {
        public int apply(int x, int y) {  return x%y; }
        public long apply(long x, long y) { return x%y; }
        public float apply(float x, float y) { return x%y; }
        public double apply(double x, double y) { return x%y; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append("%").append((argumentFormat.getFormat(2))).toString();
        }
    };

    /**
     * The function which returns the hypotenuse of two arguments. That is, the value {@code Math.hypot(x,y)}.
     */
    public static final NumericFunction2 HYPOT = new NumericFunction2.DecimalFunction2("hypot") {
        public double apply(double x, double y) { return hypot(x,y); }
    };

    /**
     * The function which returns the maximum of two arguments.
     */
    public static final NumericFunction2 MAX = new NumericFunction2.FlexFunction2("max") {
        public int apply(int x, int y) {  return max(x,y); }
        public long apply(long x, long y) { return max(x,y); }
        public float apply(float x, float y) { return max(x,y); }
        public double apply(double x, double y) { return max(x,y); }
    };

    /**
     * The function which returns the minimum of two arguments.
     */
    public static final NumericFunction2 MIN = new NumericFunction2.FlexFunction2("min") {
        public int apply(int x, int y) {  return min(x,y); }
        public long apply(long x, long y) { return min(x,y); }
        public float apply(float x, float y) { return min(x,y); }
        public double apply(double x, double y) { return min(x,y); }
    };

    /**
     * The function which returns the result of the first argument raised to the power of the second.
     */
    public static final NumericFunction2 POWER = new NumericFunction2.DecimalFunction2("power") {
        public double apply(double x, double y) { return pow(x,y); }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append("^").append((argumentFormat.getFormat(2))).toString();
        }
    };

    /**
     * The function which returns the first argument unless it is "not-a-number" (NaN), in which case it returns the second.
     */
    public static final NumericFunction2 NAN_TO_VALUE = new NumericFunction2.DecimalFunction2("nan_to_value") {
        public double apply(double x, double y) { return Double.isNaN(x) ? y : x;}
    };

    /**
     * The function which returns the argument unless it is "not-a-number" (NaN), in which case it returns zero.
     */
    public static final NumericFunction1 NAN_TO_ZERO = new NumericFunction1.DecimalFunction1("nan_to_zero") {
        public double apply(double x) { return Double.isNaN(x) ? 0.0 : x;}
    };



    private static final double NUMERIC_TRUE = 1.0;
    private static final double NUMERIC_FALSE = 0.0;
    private static final long LONG_NUMERIC_TRUE = 1L;
    private static final long LONG_NUMERIC_FALSE = 0L;

    /**
     * The (numeric boolean) function which returns 1 if the argument is "not-a-number" (NaN), 0 if not.
     */
    public static final NumericFunction1 IS_NAN = new NumericFunction1.DecimalFunction1("is_nan") {
        public double apply(double x) { return Double.isNaN(x) ? NUMERIC_TRUE : NUMERIC_FALSE; }
    };

    /**
     * The (numeric boolean) function which returns 1 if the argument is infinite, 0 if not.
     */
    public static final NumericFunction1 IS_INFINITE = new NumericFunction1.DecimalFunction1("is_infinite") {
        public double apply(double x) { return Double.isInfinite(x) ? NUMERIC_TRUE : NUMERIC_FALSE; }
    };

    /**
     * The (numeric boolean) function which returns 1 if both arguments are (numerically) true, 0 otherwise.
     */
    public static final NumericFunction2 AND = new NumericFunction2.DecimalFunction2("and") {
        public double apply(double x, double y) { return x != NUMERIC_FALSE && y != NUMERIC_FALSE ? NUMERIC_TRUE : NUMERIC_FALSE; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append("and").append((argumentFormat.getFormat(2))).toString();
        }
    };

    /**
     * The (numeric boolean) function which returns 1 if either argument is (numerically) true, 0 otherwise.
     */
    public static final NumericFunction2 OR = new NumericFunction2.DecimalFunction2("or") {
        public double apply(double x, double y) { return x != NUMERIC_FALSE || y != NUMERIC_FALSE ? NUMERIC_TRUE : NUMERIC_FALSE; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append("or").append((argumentFormat.getFormat(2))).toString();
        }
    };

    /**
     * The (numeric boolean) function which returns 0 if the argument is (numerically) true, 1 otherwise.
     */
    public static final NumericFunction1 NOT = new NumericFunction1.DecimalFunction1("not") {
        public double apply(double x) { return x == NUMERIC_FALSE ? NUMERIC_TRUE : NUMERIC_FALSE; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder("not").append((argumentFormat.getFormat(1))).toString();
        }
    };

    /**
     * The (numeric boolean) function which returns 1 if the first argument is equal to the second, 0 if not.
     */
    public static final NumericFunction2 EQUAL = new NumericFunction2.DecimalFunction2("equal") {
        public double apply(double x, double y) { return x == y ? NUMERIC_TRUE : NUMERIC_FALSE; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append("==").append((argumentFormat.getFormat(2))).toString();
        }
    };

    /**
     * The (numeric boolean) function which returns 1 if the first argument is not equal to the second, 0 oherwise.
     */
    public static final NumericFunction2 NOT_EQUAL = new NumericFunction2.DecimalFunction2("not_equal") {
        public double apply(double x, double y) { return x != y ? NUMERIC_TRUE : NUMERIC_FALSE; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append("!=").append((argumentFormat.getFormat(2))).toString();
        }
    };

    /**
     * The (numeric boolean) function which returns 1 if the first argument is greater than the second, 0 if not.
     */
    public static final NumericFunction2 GREATER_THAN = new NumericFunction2.DecimalFunction2("greater_than") {
        public double apply(double x, double y) { return x > y ? NUMERIC_TRUE : NUMERIC_FALSE; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append(">").append((argumentFormat.getFormat(2))).toString();
        }
    };  

    /**
     * The (numeric boolean) function which returns 1 if the first argument is greater than or equal to the second, 0 if not.
     */
    public static final NumericFunction2 GREATER_THAN_OR_EQUAL = new NumericFunction2.DecimalFunction2("greater_than_or_equal") {
        public double apply(double x, double y) { return x >= y ? NUMERIC_TRUE : NUMERIC_FALSE; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append(">=").append((argumentFormat.getFormat(2))).toString();
        }
    };      

    /**
     * The (numeric boolean) function which returns 1 if the first argument is less than the second, 0 if not.
     */
    public static final NumericFunction2 LESS_THAN = new NumericFunction2.DecimalFunction2("less_than") {
        public double apply(double x, double y) { return x < y ? NUMERIC_TRUE : NUMERIC_FALSE; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append("<").append((argumentFormat.getFormat(2))).toString();
        }
    };  

    /**
     * The (numeric boolean) function which returns 1 if the first argument is less than or equal to the second, 0 if not.
     */
    public static final NumericFunction2 LESS_THAN_OR_EQUAL = new NumericFunction2.DecimalFunction2("less_than_or_equal") {
        public double apply(double x, double y) { return x <= y ? NUMERIC_TRUE : NUMERIC_FALSE; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append("<=").append((argumentFormat.getFormat(2))).toString();
        }
    };

    /**
     * The function which returns the first argument if the second is equal to 1, 0 if not.
     */
    public static final NumericFunction2 BOOLEAN_PASS = new NumericFunction2.FlexFunction2("boolean_pass") {
        public double apply(double x, double y) { return y == NUMERIC_TRUE ? x : NUMERIC_FALSE; }
        public long apply(long x, long y) { return y == LONG_NUMERIC_TRUE ? x : LONG_NUMERIC_FALSE; }

        public String getSymbolicFormat(TextFormat argumentFormat) {
            return new StringBuilder(argumentFormat.getFormat(1)).append(" if ").append((argumentFormat.getFormat(2))).toString();
        }
    };

    /**
     * Get a function which returns 1 if the argument is found in the array of values, 0 if not.
     *
     * @param values
     *        The values the argument will be checked against.
     *
     * @return a function which indicates if the argument is found in a series of values.
     */
    public static NumericFunction1 inValues(final long ... values) {
        return new NumericFunction1.IntegralFunction1(" in " + Arrays.toString(values)) {
            public long apply(long x) {
                for (long listItem : values)
                    if (x == listItem)
                        return LONG_NUMERIC_TRUE;
                return LONG_NUMERIC_FALSE;
            }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return new StringBuilder(argumentFormat.getFormat(1)).append(getName()).toString();
            }
        };
    }

    /**
     * Get a function which returns 1 if the argument is found in the array of values, 0 if not.
     *
     * @param values
     *        The values the argument will be checked against.
     *
     * @return a function which indicates if the argument is found in a series of values.
     */
    public static NumericFunction1 inValues(final double ... values) {
        return new NumericFunction1.DecimalFunction1(" in " + Arrays.toString(values)) {
            public double apply(double x) {
                for (double listItem : values)
                    if (x == listItem)
                        return NUMERIC_TRUE;
                return NUMERIC_FALSE;
            }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return new StringBuilder(argumentFormat.getFormat(1)).append(getName()).toString();
            }
        };
    }

    /**
     * Get a (numeric boolean) function which returns 1 if the argument is on <code>(lower,upper)</code>, 0 if not.
     * 
     * @param lower
     *        The (exclusive) lower bound for the range.       
     * 
     * @param upper
     *        The (exclusive) upper bound for the range.
     * 
     * @return a function which indicates that the argument is within the specified range.
     */
    public static NumericFunction1 withinRange(final long lower, final long upper) {
        return new NumericFunction1.IntegralFunction1(" on (" + lower + "," + upper + ")") {
            public long apply(long x) { return x > lower && x < upper ? LONG_NUMERIC_TRUE : LONG_NUMERIC_FALSE; }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return new StringBuilder(argumentFormat.getFormat(1)).append(getName()).toString();
            }
        };
    }

    /**
     * Get a (numeric boolean) function which returns 1 if the argument is on <code>[lower,upper)</code>, 0 if not.
     *
     * @param lower
     *        The (inclusive) lower bound for the range.
     * 
     * @param upper
     *        The (exclusive) upper bound for the range.
     * 
     * @return a function which indicates that the argument is within the specified range.
     */
    public static NumericFunction1 withinLowerBoundedRange(final long lower, final long upper) {
        return new NumericFunction1.IntegralFunction1(" on [" + lower + "," + upper + ")") {
            public long apply(long x) { return x >= lower && x < upper ? LONG_NUMERIC_TRUE : LONG_NUMERIC_FALSE; }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return new StringBuilder(argumentFormat.getFormat(1)).append(getName()).toString();
            }
        };
    }

    /**
     * Get a (numeric boolean) function which returns 1 if the argument is on <code>(lower,upper]</code>, 0 if not.
     * 
     * @param lower
     *        The (exclusive) lower bound for the range.       
     * 
     * @param upper
     *        The (inclusive) upper bound for the range.
     * 
     * @return a function which indicates that the argument is within the specified range.
     */
    public static NumericFunction1 withinUpperBoundedRange(final long lower, final long upper) {
        return new NumericFunction1.IntegralFunction1(" on (" + lower + "," + upper + "]") {
            public long apply(long x) { return x > lower && x <= upper ? LONG_NUMERIC_TRUE : LONG_NUMERIC_FALSE; }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return new StringBuilder(argumentFormat.getFormat(1)).append(getName()).toString();
            }
        };
    }

    /**
     * Get a (numeric boolean) function which returns 1 if the argument is on <code>[lower,upper]</code>, 0 if not.
     * 
     * @param lower
     *        The (inclusive) lower bound for the range.       
     * 
     * @param upper
     *        The (inclusive) upper bound for the range.
     * 
     * @return a function which indicates that the argument is within the specified range.
     */
    public static NumericFunction1 withinBoundedRange(final long upper, final long lower) {
        return new NumericFunction1.IntegralFunction1(" on [" + lower + "," + upper + "]") {
            public long apply(long x) { return x >= lower && x <= upper ? LONG_NUMERIC_TRUE : LONG_NUMERIC_FALSE; }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return new StringBuilder(argumentFormat.getFormat(1)).append(getName()).toString();
            }
        };
    }

    /**
     * Get a (numeric boolean) function which returns 1 if the argument is on <code>(lower,upper)</code>, 0 if not.
     * 
     * @param lower
     *        The (exclusive) lower bound for the range.       
     * 
     * @param upper
     *        The (exclusive) upper bound for the range.
     * 
     * @return a function which indicates that the argument is within the specified range.
     */
    public static NumericFunction1 withinRange(final double lower, final double upper) {
        return new NumericFunction1.DecimalFunction1(" on (" + lower + "," + upper + ")") {
            public double apply(double x) { return x > lower && x < upper ? NUMERIC_TRUE : NUMERIC_FALSE; }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return new StringBuilder(argumentFormat.getFormat(1)).append(getName()).toString();
            }
        };
    }

    /**
     * Get a (numeric boolean) function which returns 1 if the argument is on <code>[lower,upper)</code>, 0 if not.
     * 
     * @param lower
     *        The (inclusive) lower bound for the range.       
     * 
     * @param upper
     *        The (exclusive) upper bound for the range.
     * 
     * @return a function which indicates that the argument is within the specified range.
     */
    public static NumericFunction1 withinLowerBoundedRange(final double lower, final double upper) {
        return new NumericFunction1.DecimalFunction1(" on [" + lower + "," + upper + ")") {
            public double apply(double x) { return x >= lower && x < upper ? NUMERIC_TRUE : NUMERIC_FALSE; }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return new StringBuilder(argumentFormat.getFormat(1)).append(getName()).toString();
            }
        };
    }

    /**
     * Get a (numeric boolean) function which returns 1 if the argument is on <code>(lower,upper]</code>, 0 if not.
     * 
     * @param lower
     *        The (exclusive) lower bound for the range.       
     * 
     * @param upper
     *        The (inclusive) upper bound for the range.
     * 
     * @return a function which indicates that the argument is within the specified range.
     */
    public static NumericFunction1 withinUpperBoundedRange(final double lower, final double upper) {
        return new NumericFunction1.DecimalFunction1(" on (" + lower + "," + upper + "]") {
            public double apply(double x) { return x > lower && x <= upper ? NUMERIC_TRUE : NUMERIC_FALSE; }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return new StringBuilder(argumentFormat.getFormat(1)).append(getName()).toString();
            }
        };
    }

    /**
     * Get a (numeric boolean) function which returns 1 if the argument is on <code>[lower,upper]</code>, 0 if not.
     * 
     * @param lower
     *        The (inclusive) lower bound for the range.       
     * 
     * @param upper
     *        The (inclusive) upper bound for the range.
     * 
     * @return a function which indicates that the argument is within the specified range.
     */
    public static NumericFunction1 withinBoundedRange(final double upper, final double lower) {
        return new NumericFunction1.DecimalFunction1(" on [" + lower + "," + upper + "]") {
            public double apply(double x) { return x >= lower && x <= upper ? NUMERIC_TRUE : NUMERIC_FALSE; }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return new StringBuilder(argumentFormat.getFormat(1)).append(getName()).toString();
            }
        };
    }
    /**
     * A (numeric boolean) function which returns 1 if argument 0 is on <code>(argument 1,argument 2)</code>, 0 if not.
     */
    public static NumericFunctionN WITHIN_RANGE = new SimpleCollapsibleFunction(new NumericFunctionN.FlexFunctionN(3,"within_range") {
            @Override
            protected long applyUncheckedLong(int start, long ... values) {
                return withinRange(values[start+1],values[start+2]).apply(values[start]);
            }

            @Override
            protected double applyUncheckedDouble(int start, double ... values) {
                return withinRange(values[start+1],values[start+2]).apply(values[start]);
            }

            @Override
            protected long applyUncheckedLong(int start, NumericValuesProvider values) {
                return withinRange(values.getLong(start+1),values.getLong(start+2)).apply(values.getLong(start));
            }

            @Override
            protected double applyUncheckedDouble(int start, NumericValuesProvider values) {
                return withinRange(values.getDouble(start+1),values.getDouble(start+2)).apply(values.getDouble(start));
            }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return new StringBuilder(argumentFormat.getFormat(1)).append(" on (").append(argumentFormat.getFormat(2)).append(",").append(argumentFormat.getFormat(3)).append(")").toString();
            }
        },new int[] {1,2}) {

        @Override
        protected NumericFunctionN collapseFunctionValuesCollapsed(NumericValuesProvider provider) {
            switch (provider.getValueTypePreference()) {
                case BYTE :
                case SHORT :
                case INT :
                case LONG : return withinRange(provider.getLong(0),provider.getLong(1));
                default : return withinRange(provider.getDouble(0),provider.getDouble(1));
            }
        }
    };


    /**
     * A (numeric boolean) function which returns 1 if argument 0 is on <code>[argument 1,argument 2)</code>, 0 if not.
     */
    public static NumericFunctionN WITHIN_LOWER_BOUNDED_RANGE = new SimpleCollapsibleFunction(new NumericFunctionN.FlexFunctionN(3,"within_lower_bounded_range") {
            @Override
            protected long applyUncheckedLong(int start, long ... values) {
                return withinLowerBoundedRange(values[start+1],values[start+2]).apply(values[start]);
            }

            @Override
            protected double applyUncheckedDouble(int start, double ... values) {
                return withinLowerBoundedRange(values[start+1],values[start+2]).apply(values[start]);
            }

            @Override
            protected long applyUncheckedLong(int start, NumericValuesProvider values) {
                return withinLowerBoundedRange(values.getLong(start+1),values.getLong(start+2)).apply(values.getLong(start));
            }

            @Override
            protected double applyUncheckedDouble(int start, NumericValuesProvider values) {
                return withinLowerBoundedRange(values.getDouble(start+1),values.getDouble(start+2)).apply(values.getDouble(start));
            }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return new StringBuilder(argumentFormat.getFormat(1)).append(" on [").append(argumentFormat.getFormat(2)).append(",").append(argumentFormat.getFormat(3)).append(")").toString();
            }
        },new int[] {1,2}) {

        @Override
        protected NumericFunctionN collapseFunctionValuesCollapsed(NumericValuesProvider provider) {
            switch (provider.getValueTypePreference()) {
                case BYTE :
                case SHORT :
                case INT :
                case LONG : return withinLowerBoundedRange(provider.getLong(0),provider.getLong(1));
                default : return withinLowerBoundedRange(provider.getDouble(0),provider.getDouble(1));
            }
        }
    };

    /**
     * A (numeric boolean) function which returns 1 if argument 0 is on <code>(argument 1,argument 2]</code>, 0 if not.
     */
    public static NumericFunctionN WITHIN_UPPER_BOUNDED_RANGE = new SimpleCollapsibleFunction(new NumericFunctionN.FlexFunctionN(3,"within_upper_bounded_range") {
            @Override
            protected long applyUncheckedLong(int start, long ... values) {
                return withinUpperBoundedRange(values[start+1],values[start+2]).apply(values[start]);
            }

            @Override
            protected double applyUncheckedDouble(int start, double ... values) {
                return withinUpperBoundedRange(values[start+1],values[start+2]).apply(values[start]);
            }

            @Override
            protected long applyUncheckedLong(int start, NumericValuesProvider values) {
                return withinUpperBoundedRange(values.getLong(start+1),values.getLong(start+2)).apply(values.getLong(start));
            }

            @Override
            protected double applyUncheckedDouble(int start, NumericValuesProvider values) {
                return withinUpperBoundedRange(values.getDouble(start+1),values.getDouble(start+2)).apply(values.getDouble(start));
            }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return new StringBuilder(argumentFormat.getFormat(1)).append(" on (").append(argumentFormat.getFormat(2)).append(",").append(argumentFormat.getFormat(3)).append("]").toString();
            }
        },new int[] {1,2}) {

        @Override
        protected NumericFunctionN collapseFunctionValuesCollapsed(NumericValuesProvider provider) {
            switch (provider.getValueTypePreference()) {
                case BYTE :
                case SHORT :
                case INT :
                case LONG : return withinUpperBoundedRange(provider.getLong(0),provider.getLong(1));
                default : return withinUpperBoundedRange(provider.getDouble(0),provider.getDouble(1));
            }
        }
    };

    /**
     * A (numeric boolean) function which returns 1 if argument 0 is on <code>[argument 1,argument 2]</code>, 0 if not.
     */
    public static NumericFunctionN WITHIN_BOUNDED_RANGE = new SimpleCollapsibleFunction(new NumericFunctionN.FlexFunctionN(3,"within_bounded_range") {
            @Override
            protected long applyUncheckedLong(int start, long ... values) {
                return withinBoundedRange(values[start+1],values[start+2]).apply(values[start]);
            }

            @Override
            protected double applyUncheckedDouble(int start, double ... values) {
                return withinBoundedRange(values[start+1],values[start+2]).apply(values[start]);
            }

            @Override
            protected long applyUncheckedLong(int start, NumericValuesProvider values) {
                return withinBoundedRange(values.getLong(start+1),values.getLong(start+2)).apply(values.getLong(start));
            }

            @Override
            protected double applyUncheckedDouble(int start, NumericValuesProvider values) {
                return withinBoundedRange(values.getDouble(start+1),values.getDouble(start+2)).apply(values.getDouble(start));
            }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return new StringBuilder(argumentFormat.getFormat(1)).append(" on [").append(argumentFormat.getFormat(2)).append(",").append(argumentFormat.getFormat(3)).append("]").toString();
            }
        },new int[] {1,2}) {

        @Override
        protected NumericFunctionN collapseFunctionValuesCollapsed(NumericValuesProvider provider) {
            switch (provider.getValueTypePreference()) {
                case BYTE :
                case SHORT :
                case INT :
                case LONG : return withinBoundedRange(provider.getLong(0), provider.getLong(1));
                default : return withinBoundedRange(provider.getDouble(0), provider.getDouble(1));
            }
        }
    };
    //todo: figure out how to deal with variable arguments, so that inValues can be applied

    //this is f(x,g(x)) for a given x

    /**
     * Get a function which will will compose a two-argument (<code>f(x,y)</code>) and one-argument (<code>g(x)</code>)
     * function in such a way that it returns <code>f(x,g(x))</code> for a given argument <code>x</code>.
     *
     * @param function2
     *        The two-argument function.
     *
     * @param function1
     *        The one-argument function.
     *
     * @return the functions which composes {@code function1} as the second argument to {@code function2}.
     */
    public static NumericFunction1 foldRecurse(final NumericFunction2 function2, final NumericFunction1 function1) {
        return new NumericFunction1.FlexFunction1(function2 + "(x," + function1 + "(x))") { //todo: poor name choice...
            public double apply(double x) { return function2.apply(x,function1.apply(x));}
            public long apply(long x) { return function2.apply(x,function1.apply(x));}

            public String getSymbolicFormat(TextFormat argumentFormat) {
                return function2.getSymbolicFormat(argumentFormat).replace(argumentFormat.getFormat(2),function1.getSymbolicFormat(argumentFormat));
            }
        };
    }

    /**
     * Get a function which returns its argument if the specified (boolean numeric) function evaluates to 1 for the argument,
     * 0 otherwise.
     *
     * @param booleanFunction
     *        The (boolean numeric) function used to test the argument.
     *
     * @return a function which will pass its argument if that argument passes {@code booleanFunction}.
     */
    public static NumericFunction1 booleanPass(NumericFunction1 booleanFunction) {
        return foldRecurse(BOOLEAN_PASS,booleanFunction);
    }

    /**
     * Get a function which returns the composition of two functions. That is, it returns the result of the outer function
     * applied to the result of the inner functions (<code>outer(inner(parameters ...))</code>).
     *
     * @param outer
     *        The outer function.
     *
     * @param inner
     *        The inner function.
     *
     * @return a function which composes {@code outer} with {@code inner}.
     */
    public static NumericFunctionN compose(final NumericFunction1 outer, final NumericFunctionN inner) {
        return new NumericFunctionN() {

            @Override
            public int getArgumentCount() {
                return inner.getArgumentCount();
            }

            @Override
            protected byte applyUncheckedByte(int start, byte... values) {
                return outer.apply(inner.applyUncheckedByte(start,values));
            }

            @Override
            protected short applyUncheckedShort(int start, short... values) {
                return outer.apply(inner.applyUncheckedShort(start,values));
            }

            @Override
            protected int applyUncheckedInt(int start, int... values) {
                return outer.apply(inner.applyUncheckedInt(start,values));
            }

            @Override
            protected long applyUncheckedLong(int start, long... values) {
                return outer.apply(inner.applyUncheckedLong(start,values));
            }

            @Override
            protected float applyUncheckedFloat(int start, float... values) {
                return outer.apply(inner.applyUncheckedFloat(start,values));
            }

            @Override
            protected double applyUncheckedDouble(int start, double... values) {
                return outer.apply(inner.applyUncheckedDouble(start,values));
            }

            @Override
            protected byte applyUncheckedByte(int start, NumericValuesProvider values) {
                return outer.apply(inner.applyUncheckedByte(start,values));
            }

            @Override
            protected short applyUncheckedShort(int start, NumericValuesProvider values) {
                return outer.apply(inner.applyUncheckedShort(start,values));
            }

            @Override
            protected int applyUncheckedInt(int start, NumericValuesProvider values) {
                return outer.apply(inner.applyUncheckedInt(start,values));
            }

            @Override
            protected long applyUncheckedLong(int start, NumericValuesProvider values) {
                return outer.apply(inner.applyUncheckedLong(start,values));
            }

            @Override
            protected float applyUncheckedFloat(int start, NumericValuesProvider values) {
                return outer.apply(inner.applyUncheckedFloat(start,values));
            }

            @Override
            protected double applyUncheckedDouble(int start, NumericValuesProvider values) {
                return outer.apply(inner.applyUncheckedDouble(start,values));
            }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                String outerFormat = outer.getSymbolicFormat(argumentFormat);
                return outerFormat.replace(argumentFormat.getFormat(1), inner.getSymbolicFormat(argumentFormat));
            }
        };
    }

    /**
     * Get a function which returns its second argument if the first resolves to (numerically) true, or its third
     * argument if the first resolves to (numerically) false. It is equivalent to the Java ternary statement, if
     * applied to a numeric boolean first argument: <code>arg1 ? arg2 : arg3</code>.
     */
    public static final NumericFunctionN TERNARY = new NumericFunctionN.FlexFunctionN(3,"ternary") {
        @Override
        protected long applyUncheckedLong(int start, long ... values) {
            return values[start] == LONG_NUMERIC_FALSE ? values[start+2] : values[start+1];
        }

        @Override
        protected double applyUncheckedDouble(int start, double ... values) {
            return values[start] == NUMERIC_FALSE ? values[start+2] : values[start+1];
        }                    
        
        @Override
        protected long applyUncheckedLong(int start, NumericValuesProvider values) {
            return values.getLong(start) == LONG_NUMERIC_FALSE ? values.getLong(start+2) : values.getLong(start+1);
        }

        @Override
        protected double applyUncheckedDouble(int start, NumericValuesProvider values) {
            return values.getDouble(start) == NUMERIC_FALSE ? values.getDouble(start+2) : values.getDouble(start+1);
        }
        
        public String getSymbolicFormat(TextFormat argumentFormat) {
            return "if " + argumentFormat.getFormat(1) + " then " + argumentFormat.getFormat(2) + " else " + argumentFormat.getFormat(3);
        }
    };

    /**
     * Get a function which returns its second argument if the first resolves to (numerically) true, or its third
     * argument if the first resolves to (numerically) false. It is equivalent to the Java ternary statement, if
     * applied to a numeric boolean first argument: <code>arg1 ? arg2 : arg3</code>. This function will only resolve
     * its second (third) argument if the first argument resolves to numerically true (numerically false).
     *
     * @param test
     *        The function representing the test case for the ternary operator.
     *
     * @param ifTrue
     *        The function to apply if {@code test} resolves to (numerically) true;
     *
     * @param ifFalse
     *        The function to apply if {@code test} resolves to (numerically) false;
     *
     * @return a ternary function which only resolves its arguments if necessary.
     */
    public static NumericFunctionN shortCircuitTernary(final NumericFunctionN test, final NumericFunctionN ifTrue, final NumericFunctionN ifFalse) {
        final int trueOffset = test.getArgumentCount();
        final int falseOffset = trueOffset+test.getArgumentCount();
        return new NumericFunctionN.FlexFunctionN(test.getArgumentCount()+ifTrue.getArgumentCount()+ifFalse.getArgumentCount(),"ternary") {
            
            @Override
            protected long applyUncheckedLong(int start, long ... values) {
                return test.applyUncheckedLong(start,values) == LONG_NUMERIC_FALSE ? ifFalse.applyUncheckedLong(start+falseOffset,values) : ifTrue.applyUncheckedLong(start+trueOffset,values);
            }

            @Override
            protected double applyUncheckedDouble(int start, double ... values) {
                return test.applyUncheckedDouble(start,values) == NUMERIC_FALSE ? ifFalse.applyUncheckedDouble(start+falseOffset,values) : ifTrue.applyUncheckedDouble(start+trueOffset,values);
            }         
            
            @Override
            protected long applyUncheckedLong(int start, NumericValuesProvider values) {
                return test.applyUncheckedLong(start,values) == LONG_NUMERIC_FALSE ? ifFalse.applyUncheckedLong(start+falseOffset,values) : ifTrue.applyUncheckedLong(start+trueOffset,values);
            }

            @Override
            protected double applyUncheckedDouble(int start, NumericValuesProvider values) {
                return test.applyUncheckedDouble(start,values) == NUMERIC_FALSE ? ifFalse.applyUncheckedDouble(start+falseOffset,values) : ifTrue.applyUncheckedDouble(start+trueOffset,values);
            }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                String trueFormat = ifTrue.getSymbolicFormat(argumentFormat);
                for (int i : range(ifTrue.getArgumentCount(),0))
                    trueFormat = trueFormat.replace(argumentFormat.getFormat(i),argumentFormat.getFormat(i+trueOffset));
                String falseFormat = ifFalse.getSymbolicFormat(argumentFormat);
                for (int i : range(ifFalse.getArgumentCount(),0))
                    falseFormat = falseFormat.replace(argumentFormat.getFormat(i),argumentFormat.getFormat(i+falseOffset));
                return "if (" + test.getSymbolicFormat(argumentFormat) + ") then (" + trueFormat + ") else (" + falseFormat + ")";
            }
        };
    }

    /**
     * Get a function which returns (numerically) true if all of its arguments are (numerically) true, or (numerically)
     * false if any of them are (numerically) false.
     *
     * @param variableCount
     *        The number of arguments the function takes.
     *
     * @return 1 if all of the arguments are (numerically) true, 0 otherwise.
     */
    public static NumericFunctionN filter(final int variableCount) {
        if (variableCount < 1)
            throw new IllegalArgumentException("Variable count must be greater than 0: " + variableCount);
        return new NumericFunctionN.FlexFunctionN(variableCount,variableCount + " filter") {

            @Override
            protected long applyUncheckedLong(int start, long ... values) {
                for (int i = start; i < start+variableCount; i++)
                    if (values[i] == LONG_NUMERIC_FALSE)
                        return LONG_NUMERIC_FALSE;
                return LONG_NUMERIC_TRUE;
            }

            @Override
            protected double applyUncheckedDouble(int start, double ... values) {
                for (int i = start; i < start+variableCount; i++)
                    if (values[i] == NUMERIC_FALSE)
                        return NUMERIC_FALSE;
                return NUMERIC_TRUE;
            }

            @Override
            protected long applyUncheckedLong(int start, NumericValuesProvider values) {
                for (int i = start; i < start+variableCount; i++)
                    if (values.getLong(i) == LONG_NUMERIC_FALSE)
                        return LONG_NUMERIC_FALSE;
                return LONG_NUMERIC_TRUE;
            }

            @Override
            protected double applyUncheckedDouble(int start, NumericValuesProvider values) {
                for (int i = start; i < start+variableCount; i++)
                    if (values.getDouble(i) == NUMERIC_FALSE)
                        return NUMERIC_FALSE;
                return NUMERIC_TRUE;
            }

            public String getSymbolicFormat(TextFormat argumentFormat) {
                StringBuilder format = new StringBuilder("(").append(argumentFormat.getFormat(1));
                for (int i = 1; i < variableCount; i++)
                    format.append(" & ").append(argumentFormat.getFormat(i+1));
                return format.append(")").toString();
            }
        };
    }
}