package com.yl.learn.interview.algorithm.tree;

import com.yl.learn.interview.tree.TreeBuilder;
import com.yl.learn.interview.tree.TreeNode;
import com.yl.learn.interview.util.PrintUtil;
import junit.framework.TestCase;

public class ReBuildTreeTest extends TestCase {

    private static Integer[] pre = {1,2,4,3,5,6};
    private static Integer[] in = {4,2,1,5,3,6};

    public void testReBuildTree() {

        TreeNode<Integer> tree =TreeBuilder.build(pre, in);
        PrintUtil.println(tree);

        PrintUtil.println(tree.breadthFirstTravelList());

        tree.breadthFirstTravel(treeNode -> {
            PrintUtil.print(treeNode.value);
        });

        PrintUtil.println(tree.inTravelListRecursion());

        tree.inTravelRecursion(node -> {
            PrintUtil.print(node.value);
        });

        PrintUtil.println(tree.inTravelListWhile());

        tree.inTravelWhile(node -> {
            PrintUtil.print(node.value);
        });

        PrintUtil.println(tree.preTravelListRecursion());

        tree.preTravelRecursion(node -> {
            PrintUtil.print(node.value);
        });

        PrintUtil.println(tree.preTravelListWhile());

        PrintUtil.printlnLine();
        tree.preTravelWhile(node -> {
            PrintUtil.print(node.value);
        });
    }
}
