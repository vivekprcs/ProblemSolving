package com.vivek.problemsolving

/* https://leetcode.com/problems/excel-sheet-column-number/description/
 Given a string columnTitle that represents the column title as appears in an Excel sheet,
  return its corresponding column number.
For example:
A -> 1
B -> 2
...
Z -> 26
AA -> 27
AB -> 28   */


fun titleToNumber(columnTitle: String): Int {
    var result = 0
    for (char in columnTitle) {
        result = result * 26 + (char - 'A' + 1)
    }
    return result
}

// Example usage
fun main() {
    println(titleToNumber("A"))   // Output: 1
    println(titleToNumber("AB"))  // Output: 28
    println(titleToNumber("ZY"))  // Output: 701
}
