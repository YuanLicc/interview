package com.yl.learn.defau;

import com.yl.learn.util.util.PrintUtil;

public interface Say {

    default void say() {
        PrintUtil.println("say something");
    }

    void sayLoudly();
}
