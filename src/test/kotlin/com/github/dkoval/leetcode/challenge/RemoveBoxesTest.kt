package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RemoveBoxesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 3, 2, 2, 2, 3, 4, 3, 1),
                23
            ),
            Arguments.of(
                intArrayOf(1, 1, 1),
                9
            ),
            Arguments.of(
                intArrayOf(1),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum points you can get`(boxes: IntArray, expected: Int) {
        val actual = RemoveBoxes().removeBoxes(boxes)
        assertEquals(expected, actual)
    }
}