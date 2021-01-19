package com.yl.learn.concurrent;

import com.yl.learn.concurrent.user.User;
import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest extends TestCase {
    public void testAtomicReference() {

        AtomicReference<User> userAtomicReference = new AtomicReference<>();

        User userOne = new User("小红", "女");
        userAtomicReference.set(userOne);

        User userTwo = new User("小白", "男");

        userAtomicReference.compareAndSet(userOne, userTwo);

        PrintUtil.println(userAtomicReference.get().getName());

    }
}
