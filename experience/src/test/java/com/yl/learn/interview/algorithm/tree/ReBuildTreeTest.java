package com.yl.learn.interview.algorithm.tree;

import com.yl.learn.util.tree.TreeBuilder;
import com.yl.learn.util.tree.TreeNode;
import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class ReBuildTreeTest extends TestCase {

    private static Integer[] pre = {1,2,4,3,5,6};
    private static Integer[] in = {4,2,1,5,3,6};

    public void testReBuildTree() {

        TreeNode<Integer> tree =TreeBuilder.build(pre, in);
        PrintUtil.println(tree);

        PrintUtil.printlnLine();
        PrintUtil.println(tree.breadthFirstTravelList());

        PrintUtil.printlnLine();
        tree.breadthFirstTravel(treeNode -> {
            PrintUtil.println(treeNode.value);
        });
        PrintUtil.printlnLine();

        PrintUtil.println(tree.inTravelListRecursion());

        PrintUtil.printlnLine();
        tree.inTravelRecursion(node -> {
            PrintUtil.println(node.value);
        });
        PrintUtil.printlnLine();

        PrintUtil.println(tree.inTravelListWhile());

        PrintUtil.printlnLine();
        tree.inTravelWhile(node -> {
            PrintUtil.println(node.value);
        });
        PrintUtil.printlnLine();

        PrintUtil.println(tree.preTravelListRecursion());

        PrintUtil.printlnLine();
        tree.preTravelRecursion(node -> {
            PrintUtil.println(node.value);
        });

        PrintUtil.printlnLine();

        PrintUtil.println(tree.preTravelListWhile());

        PrintUtil.printlnLine();
        tree.preTravelWhile(node -> {
            PrintUtil.println(node.value);
        });

        PrintUtil.println(tree.postTravelListRecursion());

        PrintUtil.printlnLine();

        tree.postTravelRecursion(node -> {
            PrintUtil.println(node.value);
        });
    }
}
