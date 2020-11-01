package com.github.dkoval.leetcode.problems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PermutationsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2, 3),
                listOf(
                    listOf(1, 2, 3),
                    listOf(1, 3, 2),
                    listOf(2, 1, 3),
                    listOf(2, 3, 1),
                    listOf(3, 1, 2),
                    listOf(3, 2, 1)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return all possible permutations`(nums: IntArray, expected: List<List<Int>>) {
        val actual = Permutations().permute(nums)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}