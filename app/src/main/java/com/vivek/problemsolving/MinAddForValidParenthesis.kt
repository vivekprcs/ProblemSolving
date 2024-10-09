package com.vivek.problemsolving
/*  https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
A parentheses string is valid if and only if:
It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

Example 1:
Input: s = "())"
Output: 1
Example 2:
Input: s = "((("
Output: 3
* */

fun minAddToMakeValid(s: String): Int {
    var open_needed = 0  // Tracks unmatched opening parentheses
    var close_needed = 0  // Tracks unmatched closing parentheses

    for (char in s) {
        if (char == '(') {
            open_needed++
        } else if (char == ')') {
            if (open_needed > 0) {
                open_needed--  // This ')' matches an '('
            } else {
                close_needed++  // This ')' has no matching '('
            }
        }
    }

    // The result is the sum of unmatched '(' and unmatched ')'
    return open_needed + close_needed
}

fun main(){
    println(minAddToMakeValid("())"))
    println(minAddToMakeValid("((("))
}
