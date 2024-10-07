package com.vivek.problemsolving

// move all the zeros to left and 1s to the right
fun moveZerosAndOnes(arr: List<Int>): List<Int> {
    val countZero = arr.count { it == 0 }
    val countOne = arr.count { it == 1 }
    // Create a new list with zeros followed by ones
    val result = MutableList(countZero) { 0 } + MutableList(countOne) { 1 }
    return result
}

fun moveZerosAndOnes(arr: IntArray): IntArray {
    var left = 0
    var right = arr.size - 1

    while (left < right) {
        while (left < right && arr[left] == 0) {
            left++
        }
        while (left < right && arr[right] == 1) {
            right--
        }
        if (left < right) {
            // Swap arr[left] and arr[right]
            arr[left] = 0
            arr[right] = 1
            left++
            right--
        }
    }
    return arr
}

// Example usage
fun main() {
    val list = listOf(0, 1, 0, 1, 0, 1, 1, 0)
    val resultOfList = moveZerosAndOnes(list)
    println(resultOfList)  // Output: [0, 0, 0, 0, 1, 1, 1, 1]

    val array = intArrayOf(0, 1, 0, 1, 0, 1, 1, 0)
    val resultOfArray = moveZerosAndOnes(array)
    println(resultOfArray.contentToString())  // Output: [0, 0, 0, 0, 1, 1, 1, 1]

}