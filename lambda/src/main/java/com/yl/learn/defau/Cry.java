package com.yl.learn.defau;

import com.yl.learn.util.util.PrintUtil;

public interface Cry {
    default void say() {
        PrintUtil.println("cry");
    }
}
