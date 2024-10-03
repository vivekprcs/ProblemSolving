package com.vivek.problemsolving.problems

/*
*  You are building a small part of this Android application that needs to implement a simple key-value type of cache.
* In Kotlin, you will need to implement a cache object with the functions add, get, and size.

The add function takes two parameters, a key and value and adds the pair to the local cache.
*  When an item is added to the cache, this function should return the string "added" and if the item already existed in the cache,
*  this function should return the string "overwritten"

The get function attempts to retrieve an item from the cache based on the key parameter passed in.
* If the item exists in the cache, return the value, otherwise return the string "miss"

The size function simply returns the number of items in the cache.

Your goal is to implement the cache object so the function calls in the main method work properly.
The output of your program should be a final string with the function outputs separated by a space.


Example Input
cache.add("a", "value1")
cache.add("b", "value2")
cache.add("b", "value2")
cache.add("rrrrr", "nothing")
cache.get("hello")
cache.get("world")
cache.get("b")
cache.get("rrrrr")
cache.size()

Example Output
added added overwritten added miss miss value2 nothing 3
* */

class Cache {
    private val cache: MutableMap<String, String> = mutableMapOf()

    fun add(key: String, value: String): String {
        return if (cache.containsKey(key)) {
            cache[key] = value
            "overwritten"
        } else {
            cache[key] = value
            "added"
        }
    }

    fun get(key: String): String {
        return cache[key] ?: "miss"
    }

    fun size(): Int {
        return cache.size
    }
}


fun main() {
    val cache = Cache()
    val output = mutableListOf<String>()

    output.add(cache.add("a", "value1"))
    output.add(cache.add("b", "value2"))
    output.add(cache.add("b", "value2"))
    output.add(cache.add("rrrrr", "nothing"))
    output.add(cache.get("hello"))
    output.add(cache.get("world"))
    output.add(cache.get("b"))
    output.add(cache.get("rrrrr"))
    output.add(cache.size().toString())

    println(output.joinToString(" "))
}