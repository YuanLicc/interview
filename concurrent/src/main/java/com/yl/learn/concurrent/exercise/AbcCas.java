package com.yl.learn.concurrent.exercise;

import com.yl.learn.util.util.PrintUtil;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class AbcCas {
    private static final Unsafe unsafe;

    private final static long stateOffset;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset
                    (AbcCas.class.getDeclaredField("state"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    private volatile int state = 0;

    public void first() {
        while(!unsafe.compareAndSwapInt(this, stateOffset, 0, 1)) {
            //sleep
        }
        PrintUtil.println(1);
    }

    public void second() {
        while(!unsafe.compareAndSwapInt(this, stateOffset, 1, 2)) {
            //sleep
        }
        PrintUtil.println(2);
    }

    public void third() {
        while(!unsafe.compareAndSwapInt(this, stateOffset, 2, 0)) {
            //sleep
        }
        PrintUtil.println(3);
    }
}
