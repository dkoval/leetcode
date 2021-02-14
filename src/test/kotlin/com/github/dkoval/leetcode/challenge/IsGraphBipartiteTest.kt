package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class IsGraphBipartiteTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(0, 2),
                    intArrayOf(0, 1, 3),
                    intArrayOf(0, 2)
                ),
                false
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(0, 2),
                    intArrayOf(1, 3),
                    intArrayOf(0, 2)
                ),
                true
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return true if and only if it is bipartite`(graph: Array<IntArray>, expected: Boolean) {
        val actual = IsGraphBipartite().isBipartite(graph)
        assertEquals(expected, actual)
    }
}