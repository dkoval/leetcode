package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SmallestStringWithSwapsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "dcab",
                listOf(
                    listOf(0, 3),
                    listOf(1, 2)
                ),
                "bacd"
            ),
            Arguments.of(
                "dcab",
                listOf(
                    listOf(0, 3),
                    listOf(1, 2),
                    listOf(0, 2)
                ),
                "abcd"
            ),
            Arguments.of(
                "cba",
                listOf(
                    listOf(0, 1),
                    listOf(1, 2)
                ),
                "abc"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the lexicographically smallest string that s can be changed to after using the swaps`(
        s: String,
        pairs: List<List<Int>>,
        expected: String
    ) {
        val actual = SmallestStringWithSwaps().smallestStringWithSwaps(s, pairs)
        assertEquals(expected, actual)
    }
}