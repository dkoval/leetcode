package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindTheTownJudgeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                2,
                arrayOf(
                    intArrayOf(1, 2)
                ),
                2
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 3)
                ),
                3
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 3),
                    intArrayOf(3, 1)
                ),
                -1
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3)
                ),
                -1
            ),
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(1, 4),
                    intArrayOf(2, 3),
                    intArrayOf(2, 4),
                    intArrayOf(4, 3)
                ),
                3
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the town judge`(N: Int, trust: Array<IntArray>, expected: Int) {
        val actual = FindTheTownJudge.findJudge(N, trust)
        assertEquals(expected, actual)
    }
}