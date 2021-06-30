package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CountOfSmallerNumbersAfterSelfTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(5, 2, 6, 1),
                listOf(2, 1, 1, 0)
            ),
            Arguments.of(
                intArrayOf(-1),
                listOf(0)
            ),
            Arguments.of(
                intArrayOf(-1, -1),
                listOf(0, 0)
            ),
            Arguments.of(
                intArrayOf(2, 0, 1),
                listOf(2, 0, 0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return a new counts array, where counts_i is the number of smaller elements to the right of nums_i`(
        nums: IntArray,
        expected: List<Int>
    ) {
        val actual = CountOfSmallerNumbersAfterSelf().countSmaller(nums)
        assertThat(actual).containsExactlyElementsOf(expected)
    }
}