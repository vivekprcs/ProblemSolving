package com.vivek.problemsolving

// https://leetcode.com/problems/climbing-stairs/description/
/* You are climbing a staircase. It takes n steps to reach the top.
   Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

fun climbStairs(n: Int): Int {
    if (n == 1) return 1
    if (n == 2) return 2

    var prev1 = 2
    var prev2 = 1
    var current = 0

    for (i in 3..n) {
        current = prev1 + prev2
        prev2 = prev1
        prev1 = current
    }

    return current
}

fun main(){
    println(climbStairs(2))
    println(climbStairs(3))

}