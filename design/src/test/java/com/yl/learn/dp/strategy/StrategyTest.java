package com.yl.learn.dp.strategy;

import com.yl.learn.dp.strategy.imp.ArraySortStrategy;
import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class StrategyTest extends TestCase {
    public void testStrategy() {
        ArraySortAlgorithm algorithm1 = ArraySortStrategy.SELECT_SORT.algorithm();
        ArraySortAlgorithm algorithm2 = ArraySortStrategy.SELECT_SORT.algorithm();
        PrintUtil.println(algorithm1 == algorithm2);
    }
}
