package com.github.dkoval.leetcode.challenge

// Time complexity: O(N), space complexity: O(1)
object FindDifferenceUsingSumKt : FindDifference {

    override fun findTheDifference(s: String, t: String): Char {
        var addedCharAsciiValue = 0
        for (i in s.indices) {
            addedCharAsciiValue += t[i].code
            addedCharAsciiValue -= s[i].code
        }
        addedCharAsciiValue += t.last().code
        return addedCharAsciiValue.toChar()
    }
}

// Time complexity: O(N), space complexity: O(1)
object FindDifferenceUsingXorKt : FindDifference {

    // Resource: https://www.youtube.com/watch?v=sRwElQ_TOr8&t=266s
    override fun findTheDifference(s: String, t: String): Char {
        var addedChar = 0
        for (cs in s) addedChar = addedChar xor cs.code
        for (ct in t) addedChar = addedChar xor ct.code
        return addedChar.toChar()
    }
}