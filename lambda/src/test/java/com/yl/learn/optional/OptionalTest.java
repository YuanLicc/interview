package com.yl.learn.optional;

import com.yl.learn.defau.Say;
import com.yl.learn.fina.Person;
import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.util.Optional;

public class OptionalTest extends TestCase {
    public void testOptional() {
        Optional<Integer> optionalInteger = Optional.empty();
        PrintUtil.println(optionalInteger.orElse(1));
        PrintUtil.println(optionalInteger.orElseGet(() -> 1));

        Optional<Integer> optionalInteger1 = Optional.of(21);
        PrintUtil.println(optionalInteger1.orElse(21));
        PrintUtil.println(optionalInteger1.orElseGet(() -> 1));

    }
}
