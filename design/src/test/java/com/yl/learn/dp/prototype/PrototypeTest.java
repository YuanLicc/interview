package com.yl.learn.dp.prototype;

import com.yl.learn.dp.prototype.imp.PrototypeImpl;
import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class PrototypeTest extends TestCase {

    public void testPrototype() {
        Prototype prototype = new PrototypeImpl("YuanLi");
        PrintUtil.println(prototype == prototype.deepClone());
    }

}
