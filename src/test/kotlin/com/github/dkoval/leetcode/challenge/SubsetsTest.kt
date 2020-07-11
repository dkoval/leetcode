package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SubsetsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2, 3),
                listOf(
                    listOf(3),
                    listOf(1),
                    listOf(2),
                    listOf(1, 2, 3),
                    listOf(1, 3),
                    listOf(2, 3),
                    listOf(1, 2),
                    emptyList()
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return all possible subsets`(nums: IntArray, expected: List<List<Int>>) {
        val actual = Subsets.subsets(nums)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}