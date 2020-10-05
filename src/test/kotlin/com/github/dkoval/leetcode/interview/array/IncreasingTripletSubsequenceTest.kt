package com.github.dkoval.leetcode.interview.array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class IncreasingTripletSubsequenceTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                true
            ),
            Arguments.of(
                intArrayOf(5, 4, 3, 2, 1),
                false
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 1, 1),
                false
            ),
            Arguments.of(
              intArrayOf(),
                false
            ),
            Arguments.of(
              intArrayOf(1),
                false
            ),
            Arguments.of(
                intArrayOf(1, 2),
                false
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return whether an increasing subsequence of length 3 exists or not in the array`(
        nums: IntArray,
        expected: Boolean
    ) {
        val actual = IncreasingTripletSubsequenceJava().increasingTriplet(nums)
        assertEquals(expected, actual)
    }
}