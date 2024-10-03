package com.vivek.problemsolving

/*
*  print all characters which occurred more than once in a String
*  along with frequency
* */

fun main(){
    val str = "test string"
    printDuplicate(str)
}

fun printDuplicate(str: String) {
    val count = HashMap<Char, Int>()
    for (i in str.indices) {
        val char = str[i]
        count[char] = count.getOrDefault(char, 0) + 1
    }
    // Print duplicates in sorted order
    for ((key, value) in count) {
        if (value > 1) { // if the count of characters is greater than 1 then duplicate found
            println("$key, count = $value")
        }
    }
}
