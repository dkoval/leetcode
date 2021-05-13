package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RangeSumQuery2DImmutable.NumMatrix
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RangeSumQuery2DImmutableTest {

    companion object {
        private val instance: NumMatrix = NumMatrix(
            arrayOf(
                intArrayOf(3, 0, 1, 4, 2),
                intArrayOf(5, 6, 3, 2, 1),
                intArrayOf(1, 2, 0, 1, 5),
                intArrayOf(4, 1, 0, 1, 7),
                intArrayOf(1, 0, 3, 0, 5)
            )
        )

        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                instance,
                2, 1,
                4, 3,
                8
            ),
            Arguments.of(
                instance,
                1, 1,
                2, 2,
                11
            ),
            Arguments.of(
                instance,
                1, 2,
                2, 4,
                12
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return 2D range sum`(
        instance: NumMatrix,
        row1: Int,
        col1: Int,
        row2: Int,
        col2: Int,
        expected: Int
    ) {
        val actual = instance.sumRegion(row1, col1, row2, col2)
        assertEquals(expected, actual)
    }
}