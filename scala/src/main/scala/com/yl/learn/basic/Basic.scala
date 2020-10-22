package com.yl.learn.basic

private [basic] object Basic {
    def add(a : Int, b : Int) : Int = {
         a + b
    }

    def main(args : Array[String]) : Unit = {
        print(add(1, 2))
    }

}
