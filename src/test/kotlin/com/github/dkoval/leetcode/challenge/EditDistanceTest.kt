package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class EditDistanceTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            /*
            horse -> rorse (replace 'h' with 'r')
            rorse -> rose (remove 'r')
            rose -> ros (remove 'e')
            */
            Arguments.of("horse", "ros", 3),
            /*
            intention -> inention (remove 't')
            inention -> enention (replace 'i' with 'e')
            enention -> exention (replace 'n' with 'x')
            exention -> exection (replace 'n' with 'c')
            exection -> execution (insert 'u')
            */
            Arguments.of("intention", "execution", 5),
            Arguments.of("", "a", 1)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the minimum number of operations required to convert word1 to word2`(
        word1: String,
        word2: String,
        expected: Int
    ) {
        val actual = EditDistance.minDistance(word1, word2)
        assertEquals(expected, actual)
    }
}