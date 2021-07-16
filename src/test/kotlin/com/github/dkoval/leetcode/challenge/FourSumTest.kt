package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FourSumTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 0, -1, 0, -2, 2),
                0,
                listOf(
                    listOf(-2, -1, 1, 2),
                    listOf(-2, 0, 0, 2),
                    listOf(-1, 0, 0, 1)
                )
            ),
            Arguments.of(
                intArrayOf(2, 2, 2, 2, 2),
                8,
                listOf(
                    listOf(2, 2, 2, 2)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return an array of all the unique quadruplets`(nums: IntArray, target: Int, expected: List<List<Int>>) {
        val actual = FourSum().fourSum(nums, target)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}