package com.yl.learn.algorithm.offer.node;

import com.yl.common.util.PrintUtil;
import com.yl.learn.algorithm.Node;
import com.yl.learn.algorithm.NodeUtils;
import com.yl.learn.algorithm.test.TestSuper;
import org.junit.Test;

public class NodeToReverseListTest extends TestSuper {


    private static final Node<Integer> node = NodeUtils.toNode(1, 2, 3, 4, 5);

    @Test
    public void testRecursion() {
        PrintUtil.template("Node to list and reverse it:", () -> {
            PrintUtil.println(NodeUtils.toString(node));

            PrintUtil.println(NodeToReverseList.toListRecursion(node));
        });
    }


    @Test
    public void testStack() {
        PrintUtil.template("Node to list and reverse it:", () -> {
            PrintUtil.println(NodeUtils.toString(node));

            PrintUtil.println(NodeToReverseList.toListStack(node));
        });
    }

}
