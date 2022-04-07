package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LastStoneWeightTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(2,7,4,1,8,1),
                1
            ),
            Arguments.of(
                intArrayOf(1),
                1
            ),
            Arguments.of(
                intArrayOf(2, 2),
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the smallest possible weight of the left stone`(stones: IntArray, expected: Int) {
        val actual = LastStoneWeight().lastStoneWeight(stones)
        assertEquals(expected, actual)
    }
}