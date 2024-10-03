package com.vivek.problemsolving


/*   abcdbbb
     abcdddd
     abcesa
     Write a function which returns the length of common prefix length in a string array.
     abc is a common prefix, the result is 3.
*/

fun commonPrefixLength(strs: Array<String>): Int {
    if (strs.isEmpty()) {
        return 0
    }

    // Find the shortest string in the array
    val shortestStr = strs.minByOrNull { it.length } ?: return 0

    // Initialize the length of the common prefix
    var commonLength = 0

    // Compare each character of the shortest string with all other strings
    for (i in shortestStr.indices) {
        val char = shortestStr[i]
        for (otherStr in strs) {
            if (otherStr[i] != char) {
                return commonLength
            }
        }
        commonLength++
    }

    return commonLength
}

fun main() {
    val strs = arrayOf("abcdbbb", "abcdddd", "abcesa")
    println(commonPrefixLength(strs))  // Output: 3
}
