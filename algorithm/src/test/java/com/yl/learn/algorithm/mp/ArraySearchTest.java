package com.yl.learn.algorithm.mp;

import com.yl.common.util.PrintUtil;
import com.yl.learn.algorithm.pm.ArraySearch;
import com.yl.learn.algorithm.test.TestSuper;
import org.junit.Test;

public class ArraySearchTest extends TestSuper {

    @Test
    public void testIsContain() {

        char[] a = {'A', 'B', 'C', 'D'};

        char[] b = {'A', 'B', 'C'};

        char[] c = {'A', 'B', 'E'};

        PrintUtil.println(ArraySearch.isContains(a, b));

        PrintUtil.println(ArraySearch.isContains(a, c));

    }

}
