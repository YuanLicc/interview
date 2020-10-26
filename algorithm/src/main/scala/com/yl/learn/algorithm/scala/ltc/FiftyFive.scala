package com.yl.learn.algorithm.scala.ltc

import com.yl.learn.algorithm.scala.TreeNode

object FiftyFive {
    def dfs(root: TreeNode, high : Int) : Unit = {
        if(Option(root).isEmpty) { max = Math.max(max, high); return }
        dfs(root.left, high + 1)
        dfs(root.right, high + 1)
    }
    def maxDepth(root : TreeNode) : Int = {
        if(Option(root).isEmpty) return 0
        dfs(root, 0)
        max
    }
    var max = Int.MinValue

    def main(args : Array[String]) : Unit = {
        print(maxDepth(new TreeNode(1)))
    }

}
