package com.yl.learn.concurrent;

import com.yl.learn.concurrent.exercise.AbcCas;
import junit.framework.TestCase;

public class AbcTest extends TestCase {

    public void test() {
        AbcCas abcCas = new AbcCas();
        new Thread(() -> {abcCas.println(1);}).start();
        new Thread(() -> {abcCas.println(2);}).start();
        new Thread(() -> {abcCas.println(3);}).start();
    }
}
