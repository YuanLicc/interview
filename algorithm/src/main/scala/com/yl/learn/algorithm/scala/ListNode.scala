package com.yl.learn.algorithm.scala

class ListNode(var value_ : Int) {
    var value = value_
    var next: ListNode = _

    def nodeToString(): String = {
        var tmp : ListNode = this
        val sb : StringBuilder = new StringBuilder().append(tmp.value)
        tmp = tmp.next
        while (Option(tmp).isDefined) {
            sb.append("->").append(tmp.value)
            tmp = tmp.next
        }
        sb.toString()
    }
}

object ListNodeBuilder {
    def build(array : Array[Int]) : ListNode = {
        val head = new ListNode(array(0))
        var tmp = head
        for (i <- 1 until array.length) {
            tmp.next = new ListNode(array(i))
            tmp = tmp.next
        }
        head
    }
}
