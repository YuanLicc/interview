package com.yl.learn.algorithm.sort.select;

import com.yl.common.util.PrintUtil;
import com.yl.learn.algorithm.test.TestSuper;
import org.junit.Test;

import java.util.Arrays;

public class SelectSortTest extends TestSuper {

    int[] input = {0, 22, 11, 22, 33, 6, 3, 3};

    @Test
    public void test() {
        PrintUtil.template("Select sort (Double cycle) -> " + Arrays.toString(input), () -> {
            PrintUtil.println(Arrays.toString(SelectSort.selectSort(input)), "Result -> ", "");
        });
    }

}
