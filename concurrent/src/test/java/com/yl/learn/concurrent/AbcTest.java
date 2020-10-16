package com.yl.learn.concurrent;

import com.yl.learn.concurrent.exercise.AbcCas;
import junit.framework.TestCase;

public class AbcTest extends TestCase {

    public void test() {
        AbcCas abcCas = new AbcCas();
        new Thread(() -> {abcCas.first();}).start();
        new Thread(() -> {abcCas.second();}).start();
        new Thread(() -> {abcCas.third();}).start();
    }
}
