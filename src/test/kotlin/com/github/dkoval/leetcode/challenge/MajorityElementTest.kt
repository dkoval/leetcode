package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MajorityElementTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(intArrayOf(3, 2, 3), 3),
            Arguments.of(intArrayOf(2, 2, 1, 1, 1, 2, 2), 2)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should ind the majority element`(nums: IntArray, expected: Int) {
        val actual = MajorityElement.majorityElement(nums)
        assertEquals(expected, actual)
    }
}