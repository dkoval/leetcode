package com.github.dkoval.leetcode.interview.array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SingleNumberTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(intArrayOf(2, 2, 1), 1),
            Arguments.of(intArrayOf(4, 1, 2, 1, 2), 4)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the number that appears once`(nums: IntArray, expected: Int) {
        val actual = SingleNumber.singleNumber(nums)
        assertEquals(expected, actual)
    }
}