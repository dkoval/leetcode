package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class StreamCheckerTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf("cd", "f", "kl"),
                mapOf(
                    'a' to false,
                    'b' to false,
                    'c' to false,
                    'd' to true, // because 'cd' is in the wordlist
                    'e' to false,
                    'f' to true, // because 'f' is in the wordlist
                    'g' to false,
                    'h' to false,
                    'i' to false,
                    'j' to false,
                    'k' to false,
                    'l' to true // because 'kl' is in the wordlist
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should validate solution`(words: Array<String>, expected: Map<Char, Boolean>) {
        val solution = StreamChecker(words)
        for ((letter, answer) in expected) {
            assertEquals(solution.query(letter), answer)
        }
    }
}