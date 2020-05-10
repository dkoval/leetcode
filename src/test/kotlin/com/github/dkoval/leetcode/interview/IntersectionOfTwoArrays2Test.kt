package com.github.dkoval.leetcode.interview

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class IntersectionOfTwoArrays2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2), intArrayOf(2, 2)),
            Arguments.of(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4), intArrayOf(4, 9)),
            Arguments.of(intArrayOf(7, 1, 5, 2, 3, 6), intArrayOf(3, 8, 6, 20, 7), intArrayOf(3, 6, 7))
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should compute intersection of 2 arrays`(nums1: IntArray, nums2: IntArray, expected: IntArray) {
        val actual = IntersectionOfTwoArrays2.intersect(nums1, nums2)
        assertThat(actual).containsExactlyInAnyOrder(*expected)
    }
}