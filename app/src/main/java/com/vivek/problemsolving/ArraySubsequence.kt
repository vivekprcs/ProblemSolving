package com.vivek.problemsolving

/*
Given two arrays arr[] and sub[]
the task is two determine if sub is subArray of arr
for example
INPUT : arr[] = {1,2,3,4,5,6,7,8,9} , sub[] = {2,3,5}
OUTPUT :- false as 2, 3, 5 is not continuous in arr[]

INPUT : arr[] = {1,2,3,4,5,6,7,8,9} , sub[] = {2,3,5}
OUTPUT :- true as 2, 3, 4 is continuous in arr[]
 */

fun main() {
    val arr = arrayOf(1, 2, 3, 4, 6, 7, 8, 9)
    val sub = arrayOf(2, 3, 5)
    print(
        "is array subsequence " + isSubsequence(arr, sub)
    )
}

fun isSubsequence(arr: Array<Int>, sub: Array<Int>): Boolean {

    var match = 0
    /*  arr.forEach { i->
          if(arr[i-1]== sub[match]){
              match++
              if(match == sub.size)
                  return true
          }
      }
      return match == sub.size*/

    for (i in arr.indices) {
        if (arr[i] == sub[match]) {
            match++
            if (match == sub.size)
                return true
        }
    }
    return match == sub.size

}