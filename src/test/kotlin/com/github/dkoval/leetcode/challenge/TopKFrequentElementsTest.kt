package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class TopKFrequentElementsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(intArrayOf(1, 1, 1, 2, 2, 3), 2, intArrayOf(1, 2)),
            Arguments.of(intArrayOf(1), 1, intArrayOf(1))
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the k most frequent elements`(nums: IntArray, k: Int, expected: IntArray) {
        val actual = TopKFrequentElements.topKFrequent(nums, k)
        assertArrayEquals(expected, actual)
    }
}