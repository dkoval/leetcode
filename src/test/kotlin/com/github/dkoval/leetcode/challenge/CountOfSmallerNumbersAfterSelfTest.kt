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
            ),
            Arguments.of(
                intArrayOf(26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41),
                listOf(10, 27, 10, 35, 12, 22, 28, 8, 19, 2, 12, 2, 9, 6, 12, 5, 17, 9, 19, 12, 14, 6, 12, 5, 12, 3, 0, 10, 0, 7, 8, 4, 0, 0, 4, 3, 2, 0, 1, 0)
            ),
            Arguments.of(
                intArrayOf(26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38),
                //intArrayOf(26, 78, 27, 100, 33, 67),
                listOf(1)
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