package com.vivek.problemsolving

/*
You are given an array of strings names, and an array heights that consists of
distinct positive integers. Both arrays are of length n.
For each index i, names[i] and heights[i] denote the name and height of the ith person.
Return names sorted in descending order by the people's heights.

Example 1:

Input: names = ["Mary","John","Emma"], heights = [180,165,170]
Output: ["Mary","Emma","John"]
Explanation: Mary is the tallest, followed by Emma and John.
Example 2:

Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
Output: ["Bob","Alice","Bob"]
Explanation: The first Bob is the tallest, followed by Alice and the second Bob.

 */

// Time Complexity O(nlogn) Space Complexity O(n)
fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
   val heightsArray = heights.toTypedArray()
   return names.zip(heightsArray)
        .sortedByDescending { it.second }
        .map { it.first }
       .toTypedArray()
}

fun main() {
    val names1 = arrayOf("Mary", "John", "Emma")
    val heights1 = intArrayOf(180, 165, 170)
    val sortedNames1 = sortPeople(names1, heights1)
    println(sortedNames1.joinToString(", "))  // Output: Mary, Emma, John

    val names2 = arrayOf("Alice", "Bob", "Bob")
    val heights2 = intArrayOf(155, 185, 150)
    val sortedNames2 = sortPeople(names2, heights2)
    println(sortedNames2.joinToString(", "))  // Output: Bob, Alice, Bob
}