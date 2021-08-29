package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PatchingArrayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 3),
                6,
                // add 2
                1
            ),
            Arguments.of(
                intArrayOf(1, 5, 10),
                20,
                // add 2, 4
                2
            ),
            Arguments.of(
                intArrayOf(1, 2, 2),
                5,
                0
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 9),
                45,
                2
            ),
            Arguments.of(
                intArrayOf(1, 2, 2, 6, 34, 38, 41, 44, 47, 56, 59, 62, 73, 77, 83, 87, 89, 94),
                20,
                1
            ),
            Arguments.of(
                intArrayOf(1, 2, 31, 33),
                2147483647,
                28
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum number of patches required`(nums: IntArray, n: Int, expected: Int) {
        val actual = PatchingArray().minPatches(nums, n)
        assertEquals(expected, actual)
    }
}