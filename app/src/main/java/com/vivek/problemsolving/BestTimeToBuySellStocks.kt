package com.vivek.problemsolving

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

fun maxProfit(prices: IntArray): Int {
    var buyPrice = Int.MAX_VALUE
    var maxProfit = 0
    if (prices.isEmpty() || prices.size == 1) return 0

    for (price in prices) {
        if (price < buyPrice) {
            buyPrice = price
        } else {
            val sellPrice = price - buyPrice
            if (sellPrice > maxProfit) {
                maxProfit = sellPrice
            }
        }

    }
    return maxProfit
}

fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    val result =
        maxProfit(prices) //  Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    println(result)

    val prices2 = intArrayOf(7, 6, 4, 3, 1)
    println(maxProfit(prices2))  // Output: 0
}