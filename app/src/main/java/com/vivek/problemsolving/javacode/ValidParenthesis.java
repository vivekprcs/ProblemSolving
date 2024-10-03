package com.vivek.problemsolving.javacode;

import java.util.Stack;

public class ValidParenthesis {


    public static void main(String args[]) {
        String s = "{([])}}";
        System.out.print(s + "is a valid String "+isValidString(s));
    }

    public static boolean isValidString(String input_str) {
        // Declaring a stack
        Stack<Character> s = new Stack<Character>();
        for (char st : input_str.toCharArray()) {
            //  If the input string contains an opening parenthesis,
            //  push in on to the stack.
            if (st == '(' || st == '{' || st == '[') {
                s.push(st);
            } else {
                // In the case of valid parentheses, the stack cannot be
                // be empty if a closing parenthesis is encountered.
                if (s.empty()) {
                    System.out.println(input_str +
                            " contains invalid parentheses.");
                    return false;
                } else {
                    // If the input string contains a closing bracket,
                    // then pop the corresponding opening parenthesis if
                    // present.
                    char top = (Character) s.peek();
                    if(st == ')' && top == '(' ||
                            st == '}' && top == '{' ||
                            st == ']' && top == '['){
                        s.pop();
                    }
                    else{
                        System.out.println(input_str +
                                " contains invalid parentheses.");
                        return false;
                    }

                }

            }

        }
        return s.isEmpty();
    }
}
