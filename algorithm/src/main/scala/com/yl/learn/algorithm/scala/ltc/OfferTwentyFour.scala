package com.yl.learn.algorithm.scala.ltc

import com.yl.learn.algorithm.scala._

object OfferTwentyFour {

    def reverse(head : ListNode) : ListNode = {
        if(Option(head).isEmpty) return head
        var pre = head; var p = head.next
        pre.next = null
        while (Option(p).isDefined) {
            val pN = p.next; p.next = pre
            pre = p; p = pN
        } ; pre
    }

    def main(args : Array[String]) : Unit = {
        print(reverse(ListNodeBuilder.build(Array(1, 2, 3, 4, 5))).nodeToString())
    }

}
