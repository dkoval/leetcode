package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ImageOverlapTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 1, 0)
                ),
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 1),
                    intArrayOf(0, 0, 1)
                ),
                3 // We slide A to right by 1 unit and down by 1 unit.
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the largest possible overlap`(A: Array<IntArray>, B: Array<IntArray>, expected: Int) {
        val actual = ImageOverlap.largestOverlap(A, B)
        assertEquals(expected, actual)
    }
}