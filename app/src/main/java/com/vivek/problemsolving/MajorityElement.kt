package com.vivek.problemsolving

// https://leetcode.com/problems/majority-element/description/
/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
* */

// Below solution using Boyer-Moore Voting Algorithm
// another approach is using HashMap and counting the frequency of each element
// and than comparing frequency > size/2

fun majorityElement(nums: IntArray): Int {
    var count = 0
    var candidate = 0

    for (num in nums) {
        if (count == 0) {
            candidate = num
        }
        count += if (num == candidate) 1 else -1
    }

    return candidate
}

fun main() {
    val nums1 = intArrayOf(3, 2, 3)
    val nums2 = intArrayOf(2, 2, 1, 1, 1, 2, 2)

    println(majorityElement(nums1))  // Output: 3
    println(majorityElement(nums2))  // Output: 2
}

