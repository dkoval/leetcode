package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class FindKClosestElementsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                4,
                3,
                listOf(1, 2, 3, 4)
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                4,
                -1,
                listOf(1, 2, 3, 4)
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                4,
                4,
                listOf(2, 3, 4, 5)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find k closest elements`(arr: IntArray, k: Int, x: Int, expected: List<Int>) {
        val actual = FindKClosestElements().findClosestElements(arr, k, x)
        assertThat(actual).containsExactlyElementsOf(expected)
    }
}