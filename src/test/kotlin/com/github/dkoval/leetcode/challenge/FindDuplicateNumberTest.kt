package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindDuplicateNumberTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(intArrayOf(1, 3, 4, 2, 2), 2),
            Arguments.of(intArrayOf(3, 1, 3, 4, 2), 3)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the duplicate number`(nums: IntArray, expected: Int) {
        val actual = FindDuplicateNumber.findDuplicate(nums)
        assertEquals(expected, actual)
    }
}