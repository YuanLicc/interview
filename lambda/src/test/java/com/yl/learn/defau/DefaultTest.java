package com.yl.learn.defau;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class DefaultTest extends TestCase {
    public void testDefault() {
        Say say = () -> {
            PrintUtil.println("loudly say");};
        say.sayLoudly();
        say.say();

        SayThanks sayThanks = () -> {PrintUtil.println("kkk");};
        sayThanks.say();
        sayThanks.sayLoudly();

        SayCry sayCry = () -> {PrintUtil.println("aaa");};
        sayCry.say();
        sayCry.sayLoudly();
    }
}
