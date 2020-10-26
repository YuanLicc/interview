package com.yl.learn.algorithm.scala.ltc

object OneHundred89 {

    def reverse(nums: Array[Int], a: Int, b: Int): Unit = {
        var start = a
        var end = b
        while (start < end) {
            nums(start) = nums(start) ^ nums(end)
            nums(end) = nums(start) ^ nums(end)
            nums(start) = nums(start) ^ nums(end)
            start += 1
            end -= 1
        }
    }

    def rotate(nums : Array[Int], k : Int) : Unit = {
        val k_ = k % nums.length
        if(k == 0) return
        reverse(nums, 0, nums.length - 1)
        reverse(nums, 0, k_ - 1)
        reverse(nums, k_, nums.length - 1)
    }

    def main(args : Array[String]) : Unit = {
        print(rotate(Array(1, 2, 3, 4, 5), 3))
    }
}
