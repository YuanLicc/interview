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
    
    private int printNum;
    
    public void println(int num) {
        while (true) {
            if (unsafe.compareAndSwapInt(this, stateOffset, 0, 1) &&
                printNum == num - 1) {
                PrintUtil.println(num);
                printNum = num;
                unsafe.compareAndSwapInt(this, stateOffset, 1, 0);
                return;
            }
            unsafe.compareAndSwapInt(this, stateOffset, 1, 0);
        }
    }
}
