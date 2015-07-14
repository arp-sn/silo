package com.pb.sawdust.util;

import static com.pb.sawdust.util.Range.*;

/**
 * The {@code StringUtil} ...
 *
 * @author crf
 *         Started 1/24/12 9:04 AM
 */
public class StringUtil {

    private StringUtil() {}

    public static String repeat(String s, int n) {
        StringBuilder sb = new StringBuilder(s.length()*n);
        for (int i : range(n))
            sb.append(s);
        return sb.toString();
    }

    public static String repeat(char c, int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i : range(n))
            sb.append(c);
        return sb.toString();
    }

    public static String indent(String s, int indent, String indentString) {
        String end = s.contains("\n") ? "\n" : "\r";
        boolean indentEnd = !s.endsWith(end);
        indentString = repeat(indentString,indent);
        s = indentString + s.replace(end,end + indentString);
        if (!indentEnd)
            s = s.substring(0,s.length()-indentString.length()*indent);
        return s;
    }

    public static String indent(String s, int indent) {
        return indent(s,indent,"\t");
    }
}