package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumLengthOfStringAfterDeletingSimilarEndsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("ca", 2),
            Arguments.of("cabaabac", 0),
            Arguments.of("aabccabba", 3)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum length of s after performing the above operation any number of times`(
        s: String,
        expected: Int
    ) {
        val actual = MinimumLengthOfStringAfterDeletingSimilarEnds().minimumLength(s)
        assertEquals(expected, actual)
    }
}