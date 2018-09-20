package com.yl.learn.algorithm.dynamic.longest;

import com.yl.common.util.PrintUtil;
import com.yl.learn.algorithm.test.TestSuper;
import org.junit.Test;

import java.util.Arrays;

public class LongestSubsequenceTest extends TestSuper {

    String a = "abddca";
    String b = "dcadabd";

    @Test
    public void test() {
        PrintUtil.template(a + "\n" + b + "\n longest common subsequence: ",() -> {
            Arrays.asList(LongestSubsequence.longestSubsequence(a, b)).stream()
                    .forEach((row) -> {
                        PrintUtil.println(Arrays.toString(row));
                    });
        });
    }

}
