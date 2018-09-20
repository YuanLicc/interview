package com.yl.learn.algorithm.dynamic.longest;

import com.yl.common.util.PrintUtil;
import com.yl.learn.algorithm.dynamic.backpack.Backpack;
import com.yl.learn.algorithm.test.TestSuper;
import org.junit.Test;

import java.util.Arrays;

public class LongestSubstringTest extends TestSuper {

    String a = "abddca";
    String b = "dcadabd";

    @Test
    public void test() {
        PrintUtil.template(a + "\n" + b + "\nLongest common substring : ",() -> {
            Arrays.asList(LongestSubstring.longestSubstring(a, b)).stream()
                    .forEach((row) -> {
                        PrintUtil.println(Arrays.toString(row));
                    });
        });
    }

}
