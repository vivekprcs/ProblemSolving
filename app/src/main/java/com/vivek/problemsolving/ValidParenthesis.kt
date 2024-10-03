package com.vivek.problemsolving

import java.util.Stack


fun main(){
// Test cases
    val input1 = "()[]{}"
    val input2 = "([)]"
    val input3 = "{[]}"

    println(isValidParentheses(input1))  // Output: true
    println(isValidParentheses(input2))  // Output: false
    println(isValidParentheses(input3))  // Output: true
}

fun isValidParentheses(input_str: String): Boolean {
    // Declaring a stack
    val s = Stack<Char>()
    for (st in input_str.toCharArray()) {
        //  If the input string contains an opening parenthesis,
        //  push in on to the stack.
        if (st == '(' || st == '{' || st == '[') {
            s.push(st)
        } else {
            // In the case of valid parentheses, the stack cannot be
            // be empty if a closing parenthesis is encountered.
            if (s.empty()) {
                println(
                    input_str +
                            " contains invalid parentheses."
                )
                return false
            } else {
                // If the input string contains a closing bracket,
                // then pop the corresponding opening parenthesis if
                // present.
                val top = s.peek() as Char
                if (st == ')' && top == '(' || st == '}' && top == '{' || st == ']' && top == '[') {
                    s.pop()
                } else {
                    println(
                        input_str +
                                " contains invalid parentheses."
                    )
                    return false
                }
            }
        }
    }
    return s.isEmpty()
}
