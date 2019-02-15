package com.yl.learn.interview.util;

public final class ObjectUtil {

    public static final String NULL = "NULL";

    public static String nullToString(Object o) {
        return o == null ? NULL : o.toString();
    }

}
