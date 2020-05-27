package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PossibleBipartitionTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(2, 4)
                ),
                true
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(2, 3)
                ),
                false
            ),
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(4, 5),
                    intArrayOf(1, 5)
                ),
                false
            ),
            Arguments.of(
                10,
                arrayOf(
                    intArrayOf(4, 7),
                    intArrayOf(4, 8),
                    intArrayOf(5, 6),
                    intArrayOf(1, 6),
                    intArrayOf(3, 7),
                    intArrayOf(2, 5),
                    intArrayOf(5, 8),
                    intArrayOf(1, 2),
                    intArrayOf(4, 9),
                    intArrayOf(6, 10),
                    intArrayOf(8, 10),
                    intArrayOf(3, 6),
                    intArrayOf(2, 10),
                    intArrayOf(9, 10),
                    intArrayOf(3, 9),
                    intArrayOf(2, 3),
                    intArrayOf(1, 9),
                    intArrayOf(4, 6),
                    intArrayOf(5, 7),
                    intArrayOf(3, 8),
                    intArrayOf(1, 8),
                    intArrayOf(1, 7),
                    intArrayOf(2, 4)
                ),
                true
            ),
            Arguments.of(
                10,
                arrayOf(
                    intArrayOf(4, 7),
                    intArrayOf(4, 8),
                    intArrayOf(2, 8),
                    intArrayOf(8, 9),
                    intArrayOf(1, 6),
                    intArrayOf(5, 8),
                    intArrayOf(1, 2),
                    intArrayOf(6, 7),
                    intArrayOf(3, 10),
                    intArrayOf(8, 10),
                    intArrayOf(1, 5),
                    intArrayOf(7, 10),
                    intArrayOf(1, 10),
                    intArrayOf(3, 5),
                    intArrayOf(3, 6),
                    intArrayOf(1, 4),
                    intArrayOf(3, 9),
                    intArrayOf(2, 3),
                    intArrayOf(1, 9),
                    intArrayOf(7, 9),
                    intArrayOf(2, 7),
                    intArrayOf(6, 8),
                    intArrayOf(5, 7),
                    intArrayOf(3, 4)
                ),
                true
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return true if and only if it is possible to split everyone into two groups`(
        N: Int,
        dislikes: Array<IntArray>,
        expected: Boolean
    ) {
        val actual = PossibleBipartition.possibleBipartition(N, dislikes)
        assertEquals(expected, actual)
    }
}