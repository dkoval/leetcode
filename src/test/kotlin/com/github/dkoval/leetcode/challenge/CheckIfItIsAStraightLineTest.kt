package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CheckIfItIsAStraightLineTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(4, 5),
                    intArrayOf(5, 6),
                    intArrayOf(6, 7)
                ),
                true
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(3, 4),
                    intArrayOf(4, 5),
                    intArrayOf(5, 6),
                    intArrayOf(7, 7)
                ),
                false
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if points make a straight line in the 2D plane`(coordinates: Array<IntArray>, expected: Boolean) {
        val actual = CheckIfItIsAStraightLine.checkStraightLine(coordinates)
        assertEquals(expected, actual)
    }
}