package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class OnesAndZeroesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf("10", "0001", "111001", "1", "0"),
                5,
                3,
                // The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
                // Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
                // {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
                4
            ),
            Arguments.of(
                arrayOf("10", "0", "1"),
                1,
                1,
                // The largest subset is {"0", "1"}, so the answer is 2.
                2
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the size of the largest subset of strs such that there are at most m 0s and n 1s in the subset`(
        strs: Array<String>,
        m: Int,
        n: Int,
        expected: Int
    ) {
        val actual = OnesAndZeroes().findMaxForm(strs, m, n)
        assertEquals(expected, actual)
    }
}