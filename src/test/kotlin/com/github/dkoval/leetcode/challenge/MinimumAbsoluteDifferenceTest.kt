package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumAbsoluteDifferenceTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(4, 2, 1, 3),
                listOf(
                    listOf(1, 2),
                    listOf(2, 3),
                    listOf(3, 4)
                )
            ),
            Arguments.of(
                intArrayOf(1, 3, 6, 10, 15),
                listOf(
                    listOf(1, 3)
                )
            ),
            Arguments.of(
                intArrayOf(3, 8, -10, 23, 19, -4, -14, 27),
                listOf(
                    listOf(-14, -10),
                    listOf(19, 23),
                    listOf(23, 27)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find all pairs of elements with the minimum absolute difference of any two elements`(
        arr: IntArray,
        expected: List<List<Int>>
    ) {
        val actual = MinimumAbsoluteDifference().minimumAbsDifference(arr)
        assertEquals(expected, actual)
    }
}