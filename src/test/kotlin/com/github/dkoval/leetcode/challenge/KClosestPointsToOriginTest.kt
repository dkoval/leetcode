package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class KClosestPointsToOriginTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(-2, 2)
                ),
                1,
                arrayOf(
                    intArrayOf(-2, 2)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 3),
                    intArrayOf(5, -1),
                    intArrayOf(-2, 4)
                ),
                2,
                arrayOf(
                    intArrayOf(3, 3),
                    intArrayOf(-2, 4)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the K closest points to the origin (0, 0)`(
        points: Array<IntArray>,
        K: Int,
        expected: Array<IntArray>
    ) {
        val actual = KClosestPointsToOrigin.kClosest(points, K)
        assertThat(actual).containsExactly(*expected)
    }
}