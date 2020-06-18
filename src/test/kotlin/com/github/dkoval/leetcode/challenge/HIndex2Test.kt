package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class HIndex2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(intArrayOf(0, 1, 3, 5, 6), 3),
            Arguments.of(intArrayOf(1, 2, 4, 8, 9), 3),
            Arguments.of(intArrayOf(0, 1, 2, 3, 4), 2),
            Arguments.of(intArrayOf(1, 8, 9, 10), 3),
            Arguments.of(intArrayOf(0, 1, 2, 3, 7, 8), 3),
            Arguments.of(intArrayOf(1, 5, 6, 7, 8), 4),
            Arguments.of(intArrayOf(1, 2, 6, 7, 8, 9), 4),
            Arguments.of(intArrayOf(0, 1, 3, 4, 5, 8, 10, 13), 4),
            Arguments.of(intArrayOf(50, 54, 57), 3)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should compute h-index in linear time`(citations: IntArray, expected: Int) {
        HIndex2Linear.test(citations, expected)
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should compute h-index in logarithmic time`(citations: IntArray, expected: Int) {
        HIndex2BinarySearch.test(citations, expected)
    }

    private fun HIndex2.test(citations: IntArray, expected: Int) {
        val actual = hIndex(citations)
        assertEquals(expected, actual)
    }
}