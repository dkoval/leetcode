package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BinaryTreesWithFactorsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(2, 4),
                // We can make these trees: [2], [4], [4, 2, 2]
                3
            ),
            Arguments.of(
                intArrayOf(2, 4, 5, 10),
                // We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2]
                7
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of binary trees we can make`(arr: IntArray, expected: Int) {
        val actual = BinaryTreesWithFactors().numFactoredBinaryTrees(arr)
        assertEquals(expected, actual)
    }
}