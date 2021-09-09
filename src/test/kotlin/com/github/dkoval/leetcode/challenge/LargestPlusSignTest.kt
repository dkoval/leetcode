package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LargestPlusSignTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(4, 2)
                ),
                2
            ),
            Arguments.of(
                1,
                arrayOf(
                    intArrayOf(0, 0)
                ),
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the order of the largest axis-aligned plus sign of 1's contained in grid`(
        n: Int,
        mines: Array<IntArray>,
        expected: Int
    ) {
        val actual = LargestPlusSign().orderOfLargestPlusSign(n, mines)
        assertEquals(expected, actual)
    }
}