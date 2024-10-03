package com.vivek.problemsolving

/*
  write a program in kotlin to find character having maximum number of occurrence
 for example given string "aabacddybezepsessbbbb" the max occurrence of character is b and count is 6
 */

fun main() {
    val input = "aabacddybezepsessbbbb"
    val charCountMap = mutableMapOf<Char, Int>()

    // Count the occurrences of each character
    for (char in input) {
        charCountMap[char] = charCountMap.getOrDefault(char, 0) + 1
    }

    // Find the character with the maximum occurrences
    var maxChar = input[0]
    var maxCount = 0
    for ((char, count) in charCountMap) {
        if (count > maxCount) {
            maxChar = char
            maxCount = count
        }
    }

    // Print the result
    println("The character with the maximum occurrence is '$maxChar' with a count of $maxCount.")
}
