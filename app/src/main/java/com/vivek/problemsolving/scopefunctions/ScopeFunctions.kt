package com.vivek.problemsolving.scopefunctions


data class Person(var name: String = "", var age: Int = 0)

fun main() {
     // let Returns the result of the lambda expression.
    val resultUnit = Person().let {
        it.name = "Vivek"
        it.age = 25
    }
    println(resultUnit.toString()) // will print kotlin.Unit

    val resultObject = Person().let {
        it.name = "Vivek"
        it.age = 25
        it
    }
    println(resultObject.toString()) // will print Person(name=Vivek, age=25)

    // APPLY Returns the context object itself.

    val resultApply = Person().apply {
        name = "Vivek"
        age = 25
    }
    println(resultApply.toString()) // will print Person(name=Vivek, age=25)

    // Run Combines the functionality of let and apply.
  // It executes a block of code and returns the result of lambda Expression.

    val resultRun = Person().run {
        name = "Vivek"
        age = 25
        this
    }
    println(resultRun.toString()) // will print Person(name=Vivek, age=25)


    // WITH Returns the result of the lambda expression.
    // Similar to run Returns the result of the lambda expression.

    val resultWith = with(Person()) {
        name = "Vivek"
        age = 25
        this
    }
    println(resultWith.toString()) // will print Person(name=Vivek, age=25)

    // Similar to let, but returns the context object (the receiver) after executing the block.

    val resultAlso = Person().also {
        it.name = "Vivek"
        it.age = 25
    }

    println(resultAlso.toString()) // will print Person(name=Vivek, age=25)

}
