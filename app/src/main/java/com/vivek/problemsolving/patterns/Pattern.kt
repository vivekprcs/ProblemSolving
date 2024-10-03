package com.vivek.problemsolving.patterns

/*
Print following patterns
 1:-
               *
             *   *
           *   *   *
         *   *   *   *

 2:-           *
             *   *
           *   *   *
         *   *   *   *
           *   *   *
             *   *
               *
*/

fun main() {
    println("Pattern 1:")
    printPattern1(5)

    println("\nPattern 2:")
    printPattern2(5)
}

fun printPattern1(n: Int) {
    for (row in 0 until n) {
        val noOfSpaces = n - row
        repeat(noOfSpaces) { print(" ") }
        repeat(row) { print("* ") }
        println()
    }
}

fun printPattern2(n: Int) {
    for (row in 0 until n * 2) {
        val totalColsInRow = if (row > n) 2 * n - row else row
        val noOfSpaces = n - totalColsInRow
        repeat(noOfSpaces) { print(" ") }
        repeat(totalColsInRow) { print("* ") }
        println()
    }
}

