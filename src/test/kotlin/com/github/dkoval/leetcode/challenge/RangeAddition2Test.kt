package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RangeAddition2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                3,
                3,
                arrayOf(
                    intArrayOf(2, 2),
                    intArrayOf(3, 3)
                ),
                4
            ),
            Arguments.of(
                3,
                3,
                arrayOf(
                    intArrayOf(2, 2),
                    intArrayOf(3, 3),
                    intArrayOf(3, 3),
                    intArrayOf(3, 3),
                    intArrayOf(2, 2),
                    intArrayOf(3, 3),
                    intArrayOf(3, 3),
                    intArrayOf(3, 3),
                    intArrayOf(2, 2),
                    intArrayOf(3, 3),
                    intArrayOf(3, 3),
                    intArrayOf(3, 3)
                ),
                4
            ),
            Arguments.of(
                3,
                3,
                arrayOf<IntArray>(),
                9
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of maximum integers in the matrix after performing all the operations`(
        m: Int,
        n: Int,
        ops: Array<IntArray>,
        expected: Int
    ) {
        val actual = RangeAddition2().maxCount(m, n, ops)
        assertEquals(expected, actual)
    }
}