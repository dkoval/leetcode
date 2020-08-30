package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LargestComponentSizeByCommonFactorTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(4, 6, 15, 35),
                4
            ),
            Arguments.of(
                intArrayOf(20, 50, 9, 63),
                2
            ),
            Arguments.of(
                intArrayOf(2, 3, 6, 7, 4, 12, 21, 39),
                8
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the size of the largest connected component in the graph`(A: IntArray, expected: Int) {
        val actual = LargestComponentSizeByCommonFactor.largestComponentSize(A)
        assertEquals(expected, actual)
    }
}