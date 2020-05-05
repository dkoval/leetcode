package com.github.dkoval.leetcode.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ContainsDuplicateTest {

    companion object {
        @JvmStatic
        fun input() = listOf<Arguments>(
            Arguments.of(intArrayOf(1, 2, 3, 1), true),
            Arguments.of(intArrayOf(1, 2, 3, 4), false),
            Arguments.of(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2), true)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return true if any value appears at least twice in the array`(nums: IntArray, expected: Boolean) {
        val actual = ContainsDuplicate.containsDuplicate(nums)
        assertEquals(expected, actual)
    }
}