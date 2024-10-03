package com.vivek.problemsolving

/*
    Problem :-  Given string with * remove * and character before
    input :- macb*ook
    output : - macook
    input : - macbook*
    output: - macboo
    input :- *macbook
    output:- macbook
*/

fun main() {
    val inputString1 = "macb*ook"
    // Print the result
    println("Original string: $inputString1")
    println("Cleaned string: ${removeCharacters(inputString1)}")

    val inputString2 = "macbook*"
    // Print the result
    println("Original string: $inputString2")
    println("Cleaned string: ${removeCharacters(inputString2)}")

    val inputString3 = "*macbook"
    // Print the result
    println("Original string: $inputString3")
    println("Cleaned string: ${removeCharacters(inputString3)}")
}


fun removeCharacters(inputString: String): String {
    // Initialize a StringBuilder to build the cleaned string
    val cleanedStringBuilder = StringBuilder()

    // Iterate through the input string with an index
    var i = 0
    while (i < inputString.length) {
        if (inputString[i] == '*') {
            // Remove the last character from the StringBuilder if it's not empty
            if (cleanedStringBuilder.isNotEmpty()) {
                cleanedStringBuilder.deleteCharAt(cleanedStringBuilder.length - 1)
            }
        } else {
            cleanedStringBuilder.append(inputString[i])
        }
        i++
    }
    return cleanedStringBuilder.toString()
}
