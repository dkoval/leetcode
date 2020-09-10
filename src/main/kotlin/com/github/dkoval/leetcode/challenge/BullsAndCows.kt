package com.github.dkoval.leetcode.challenge

/**
 * [Bulls and Cows](https://leetcode.com/explore/featured/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3455/)
 *
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend
 * to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits
 * in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match
 * the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints
 * to eventually derive the secret number.
 *
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B
 * to indicate the cows.
 *
 * Please note that both secret number and friend's guess may contain duplicate digits.
 */
interface BullsAndCows {

    fun getHint(secret: String, guess: String): String
}

object BullsAndCowsUsingTwoMaps : BullsAndCows {

    // Resource: https://www.youtube.com/watch?v=V_rZZ0kMFiw
    override fun getHint(secret: String, guess: String): String {
        var numBulls = 0
        val secretCharCount = mutableMapOf<Char, Int>()
        val guessCharCount = mutableMapOf<Char, Int>()
        // compute number of bulls and keep track of mismatches
        for (i in guess.indices) {
            if (guess[i] == secret[i]) {
                numBulls++
            } else {
                // handle mismatches
                secretCharCount[secret[i]] = secretCharCount.getOrDefault(secret[i], 0) + 1
                guessCharCount[guess[i]] = guessCharCount.getOrDefault(guess[i], 0) + 1
            }
        }
        // compute number of cows
        var numCows = 0
        for ((c, guessCount) in guessCharCount) {
            val secretCount = secretCharCount[c]
            if (secretCount != null) {
                numCows += minOf(guessCount, secretCount)
            }
        }
        return "${numBulls}A${numCows}B"
    }
}

object BullsAndCowsUsingTwoArrays : BullsAndCows {

    override fun getHint(secret: String, guess: String): String {
        var numBulls = 0
        val arr1 = IntArray(10)
        val arr2 = IntArray(10)
        // compute number of bulls and keep track of mismatches
        for (i in guess.indices) {
            if (guess[i] == secret[i]) {
                numBulls++
            } else {
                arr1[secret[i] - '0']++
                arr2[guess[i] - '0']++
            }
        }
        // compute number of cows
        var numCows = 0
        for (i in 0..9) {
            numCows += minOf(arr1[i], arr2[i])
        }
        return "${numBulls}A${numCows}B"
    }
}