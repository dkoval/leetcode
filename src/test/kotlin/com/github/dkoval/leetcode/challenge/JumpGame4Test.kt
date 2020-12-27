package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class JumpGame4Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(100, -23, -23, 404, 100, 23, 23, 23, 3, 404),
                3
            ),
            Arguments.of(
                intArrayOf(7),
                0
            ),
            Arguments.of(
                intArrayOf(7, 6, 9, 6, 9, 6, 9, 7),
                1
            ),
            Arguments.of(
                intArrayOf(6, 1, 9),
                2
            ),
            Arguments.of(
                intArrayOf(11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13),
                3
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum number of steps to reach the last index of the array`(arr: IntArray, expected: Int) {
        val actual = JumpGame4().minJumps(arr)
        assertEquals(expected, actual)
    }
}