package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PancakeSortingTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(3, 2, 4, 1),
                listOf(4, 2, 4, 3)
            ),
            Arguments.of(
                intArrayOf(1, 2, 3),
                listOf<Int>()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return an array of the k-values of the pancake flips that should be performed in order to sort A`(
        A: IntArray,
        expected: List<Int>
    ) {
        val actual = PancakeSorting.pancakeSort(A)
        assertThat(actual).hasSizeLessThanOrEqualTo(10 * A.size)
        assertThat(A).isSorted
    }
}