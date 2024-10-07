package com.vivek.problemsolving

// write algorithm to return true if one element in the array is larger than each other element*2
fun main() {
    val array1 = intArrayOf(3, 6, 12, 4, 9)
    val array2 = intArrayOf(1, 2, 3, 4, 5)
    val array3 = intArrayOf(7, 14, 6, 28, 5)

    println(isElementLargerThanTwiceOthers(array1))  // Output: true (12 > 2 * 6)
    println(isElementLargerThanTwiceOthers(array2))  // Output: false (No element > 2 * 5)
    println(isElementLargerThanTwiceOthers(array3))  // Output: true (28 > 2 * 14)
}

fun isElementLargerThanTwiceOthers(array: IntArray): Boolean {
    if (array.size < 2) {
        return false
    }

    var maxElement = array[0]
    var maxIndex = 0

    // Step 1: Find the maximum element
    for (i in 1 until array.size) {
        if (array[i] > maxElement) {
            maxElement = array[i]
            maxIndex = i
        }
    }

    // Step 2: Check if the maximum element is greater than twice every other element
    for (j in array.indices) {
        if (j != maxIndex && array[j] * 2 > maxElement) {
            return false
        }
    }

    return true
}
