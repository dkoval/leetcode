package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ThreeSumTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(-1, 0, 1, 2, -1, -4),
                listOf(
                    listOf(-1, -1, 2),
                    listOf(-1, 0, 1)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find all unique triplets in the array which gives the sum of zero`(
        nums: IntArray,
        expected: List<List<Int>>
    ) {
        val actual = ThreeSum.threeSum(nums)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}