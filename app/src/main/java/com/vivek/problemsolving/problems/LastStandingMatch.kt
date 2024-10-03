package com.vivek.problemsolving.problems

/*
Last Standing Match
You are given a string of characters, where each character is a player.
Reduce the players to one player based on the following rules:

* Each round the starts from the first player on the string.
* On a player’s turn, the immediate next player is knocked out (KO) and then the turn goes to the next position.
* We continue until all players have taken a turn and then start the next round.
* Rounds continue until there is only 1 player left.
Example:
* AB the winner is A
* ABC the winner is C
    * Round 1 Turn 1, A will KO B which will result AC
    * Round 1 Turn 2, C will KO A because it's C turn
    * C is the winner
* ABCD the winner is A
    * Round 1 Turn 1, A will KO B which will result ACD
    * Round 1 Turn 2, C will KO D which will result AC
    * Round 2 Turn 1, A will KO C which result A
 */

fun main() {
    // Test cases
    println("Winner for 'AB': ${lastStandingPlayer("AB")}")    // Output: A
    println("Winner for 'ABC': ${lastStandingPlayer("ABC")}")  // Output: C
    println("Winner for 'ABCD': ${lastStandingPlayer("ABCD")}")// Output: A
    println("Winner for 'ABCDEF': ${lastStandingPlayer("ABCDEF")}")// Output: E

}

fun lastStandingPlayer(players: String): Char {
    // Convert the input string to a mutable list of characters
    val playerList = players.toMutableList()
    var currentIndex = 0

    // Iterate until only one player remains
    while (playerList.size > 1) {
        // Calculate the index of the player to be removed
        val nextIndex = (currentIndex + 1) % playerList.size
        playerList.removeAt(nextIndex)

        // Update the current index
        if (nextIndex < currentIndex) {
            currentIndex -= 1
        }

        // Move to the next player's turn
        currentIndex = (currentIndex + 1) % playerList.size
    }

    // Return the last remaining player
    return playerList[0]
}

