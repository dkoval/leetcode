package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class Subsets2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2, 2),
                listOf(
                    listOf(),
                    listOf(1),
                    listOf(1, 2),
                    listOf(1, 2, 2),
                    listOf(2),
                    listOf(2, 2)
                )
            ),
            Arguments.of(
                intArrayOf(0),
                listOf(
                    listOf(),
                    listOf(0)
                )
            ),
            Arguments.of(
                intArrayOf(4, 4, 4, 1, 4),
                listOf(
                    listOf(),
                    listOf(1),
                    listOf(1, 4),
                    listOf(1, 4, 4),
                    listOf(1, 4, 4, 4),
                    listOf(1, 4, 4, 4, 4),
                    listOf(4),
                    listOf(4, 4),
                    listOf(4, 4, 4),
                    listOf(4, 4, 4, 4)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return all possible subsets in any order`(nums: IntArray, expected: List<List<Int>>) {
        val actual = Subsets2().subsetsWithDup(nums)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}