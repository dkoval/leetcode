package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NumberOfProvincesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 1, 0),
                    intArrayOf(0, 0, 1)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 1)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 0, 1),
                    intArrayOf(0, 1, 1, 0),
                    intArrayOf(0, 1, 1, 1),
                    intArrayOf(1, 0, 1, 1)
                ),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the total number of provinces`(connected: Array<IntArray>, expected: Int) {
        val actual = NumberOfProvinces().findCircleNum(connected)
        assertEquals(expected, actual)
    }
}