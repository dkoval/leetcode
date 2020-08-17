package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class DistributeCandiesToPeopleSolutionTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                7,
                4,
                intArrayOf(1, 2, 3, 1)
            ),
            Arguments.of(
                10,
                3,
                intArrayOf(5, 2, 3)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should compute the final distribution of candies`(candies: Int, numPeople: Int, expected: IntArray) {
        val actual = DistributeCandiesToPeopleSolution.distributeCandies(candies, numPeople)
        assertArrayEquals(expected, actual)
    }
}