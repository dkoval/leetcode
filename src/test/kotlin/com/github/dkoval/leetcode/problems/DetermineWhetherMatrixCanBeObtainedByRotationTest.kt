package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class DetermineWhetherMatrixCanBeObtainedByRotationTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 0)
                ),
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 1)
                ),
                true
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 1)
                ),
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 1)
                ),
                false
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(1, 1, 1)
                ),
                arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0)
                ),
                true
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return true if it is possible to make mat equal to target by rotating mat in 90-degree increments`(
        mat: Array<IntArray>,
        target: Array<IntArray>,
        expected: Boolean
    ) {
        val actual = DetermineWhetherMatrixCanBeObtainedByRotation().findRotation(mat, target)
        assertEquals(expected, actual)
    }
}