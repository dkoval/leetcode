package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RangeSumQueryImmutableTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(-2, 0, 3, -5, 2, -1),
                listOf(
                    SumRange(0, 2, 1),
                    SumRange(2, 5, -1),
                    SumRange(0, 5, -3)
                )
            )
        )
    }

    data class SumRange(val left: Int, val right: Int, val expected: Int)

    @ParameterizedTest
    @MethodSource("input")
    fun `should validate data structure design`(nums: IntArray, commands: List<SumRange>) {
        val solution = RangeSumQueryImmutable.NumArray(nums)
        for (command in commands) {
            val actual = solution.sumRange(command.left, command.right)
            assertEquals(command.expected, actual)
        }
    }
}