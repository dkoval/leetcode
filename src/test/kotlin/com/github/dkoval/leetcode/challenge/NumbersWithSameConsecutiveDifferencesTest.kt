package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NumbersWithSameConsecutiveDifferencesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                3,
                7,
                intArrayOf(181, 292, 707, 818, 929)
            ),
            Arguments.of(
                2,
                1,
                intArrayOf(10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K`(
        N: Int,
        K: Int,
        expected: IntArray
    ) {
        val actual = NumbersWithSameConsecutiveDifferences.numsSameConsecDiff(N, K)
        assertThat(actual).containsExactlyInAnyOrder(*expected)
    }
}