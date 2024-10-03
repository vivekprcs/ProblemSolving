package com.vivek.problemsolving


fun main() {
    // for string Test cases
    println(isPalindrome("madam"))  // Output: true
    println(isPalindrome("hello"))  // Output: false
    //  for Integer Test cases
    println(isPalindrome(12421))  // Output: true
    println(isPalindrome(1221))  // Output: true
    println(isPalindrome(1231))  // Output: false
}

 // check if given string is palindrome
fun isPalindrome(str: String): Boolean {
    // Pointers pointing to the beginning and the end of the string
    var i = 0
    var j = str.length - 1

    // While there are characters to compare
    while (i < j) {
        // If there is a mismatch
        if (str[i] != str[j]) {
            return false
        }
        // Increment first pointer and decrement the other
        i++
        j--
    }
    // Given string is a palindrome
    return true
}

// Method to check if an integer is a palindrome
fun isPalindrome(number: Int): Boolean {
    // Negative numbers are not palindromes
    if (number < 0) {
        return false
    }

    var originalNumber = number
    var reversedNumber = 0

    // Reverse the number
    while (originalNumber != 0) {
        val lastDigit = originalNumber % 10
        reversedNumber = reversedNumber * 10 + lastDigit
        originalNumber /= 10 // Remove the last digit
    }

    // Check if the original number is equal to the reversed number
    return number == reversedNumber
}
