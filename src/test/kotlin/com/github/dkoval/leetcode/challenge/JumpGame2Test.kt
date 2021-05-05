package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class JumpGame2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(2, 3, 1, 1, 4),
                2
            ),
            Arguments.of(
                intArrayOf(2, 3, 0, 1, 4),
                2
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum number of jumps required to reach the last index`(nums: IntArray, expected: Int) {
        val actual = JumpGame2().jump(nums)
        assertEquals(expected, actual)
    }
}