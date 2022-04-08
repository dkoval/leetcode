package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.KthLargestElementInStream.KthLargest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class KthLargestElementInStreamTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                3,
                intArrayOf(4, 5, 8, 2),
                listOf(
                    AddCommand(3, 4),
                    AddCommand(5, 5),
                    AddCommand(10, 5),
                    AddCommand(9, 8),
                    AddCommand(4, 8)
                )
            ),
            Arguments.of(
                1,
                intArrayOf(),
                listOf(
                    AddCommand(-3, -3),
                    AddCommand(-2, -2),
                    AddCommand(-2, -2),
                    AddCommand(0, 0),
                    AddCommand(4, 4)
                )
            )
        )
    }

    data class AddCommand(val x: Int, val expected: Int)

    @ParameterizedTest
    @MethodSource("input")
    fun `should validate data structure design`(k: Int, nums: IntArray, commands: List<AddCommand> ) {
        val solution = KthLargest(k, nums)
        for ((x, expected) in commands) {
            assertEquals(expected, solution.add(x))
        }
    }
}