package com.github.dkoval.leetcode.mock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MissingRangesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(0, 1, 3, 50, 75),
                0,
                99,
                listOf("2", "4->49", "51->74", "76->99")
            ),
            Arguments.of(
                intArrayOf(),
                1,
                1,
                listOf("1")
            ),
            Arguments.of(
                intArrayOf(),
                -3,
                -1,
                listOf("-3->-1")
            ),
            Arguments.of(
                intArrayOf(-1),
                -1,
                -1,
                listOf<String>()
            ),
            Arguments.of(
                intArrayOf(-1),
                -2,
                -1,
                listOf("-2")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the smallest sorted list of ranges that cover every missing number exactly`(
        nums: IntArray,
        lower: Int,
        upper: Int,
        expected: List<String>
    ) {
        val actual = MissingRanges().findMissingRanges(nums, lower, upper)
        assertEquals(expected, actual)
    }
}