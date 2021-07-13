package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindPeakElementTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2, 3, 1),
                setOf(2)
            ),
            Arguments.of(
                intArrayOf(1, 2, 1, 3, 5, 6, 4),
                setOf(1, 5)
            ),
            Arguments.of(
                intArrayOf(1),
                setOf(0)
            ),
            Arguments.of(
                intArrayOf(1, 2),
                setOf(1)
            ),
            Arguments.of(
                intArrayOf(2, 1),
                setOf(0)
            ),
            Arguments.of(
                intArrayOf(1, 2, 3),
                setOf(2)
            ),
            Arguments.of(
                intArrayOf(3, 2, 1),
                setOf(0)
            ),
            Arguments.of(
                intArrayOf(-2147483648),
                setOf(0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the index to any of the peaks`(nums: IntArray, expected: Set<Int>) {
        val actual = FindPeakElement().findPeakElement(nums)
        assertThat(actual).isIn(expected)
    }
}