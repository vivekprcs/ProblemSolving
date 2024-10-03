package com.vivek.problemsolving


fun countNumbers(arr: List<List<Int>>) {
    for (range in arr) {
        val n = range[0]
        val m = range[1]
        var count = 0

        for (i in n..m) {
            if (hasUniqueDigits(i)) {
                count++
            }
        }

        println(count)
    }
}

fun hasUniqueDigits(num: Int): Boolean {
    val str = num.toString()
    val digits = mutableSetOf<Char>()

    for (c in str) {
        if (digits.contains(c)) {
            return false
        }
        digits.add(c)
    }

    return true
}

fun main() {
    val ranges = listOf(
        listOf(80, 120) // Example range given in the image
    )

    countNumbers(ranges) // Expected to print the number of valid numbers with unique digits
}