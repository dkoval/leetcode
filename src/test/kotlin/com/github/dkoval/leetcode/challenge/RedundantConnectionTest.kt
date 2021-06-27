package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class RedundantConnectionTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(2, 3)
                ),
                intArrayOf(2, 3)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5)
                ),
                intArrayOf(1, 4)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(9, 10),
                    intArrayOf(5, 8),
                    intArrayOf(2, 6),
                    intArrayOf(1, 5),
                    intArrayOf(3, 8),
                    intArrayOf(4, 9),
                    intArrayOf(8, 10),
                    intArrayOf(4, 10),
                    intArrayOf(6, 8),
                    intArrayOf(7, 9)
                ),
                intArrayOf(4, 10)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `return an edge that can be removed so that the resulting graph is a tree of n nodes`(
        edges: Array<IntArray>,
        expected: IntArray
    ) {
        val actual = RedundantConnection().findRedundantConnection(edges)
        assertArrayEquals(expected, actual)
    }
}