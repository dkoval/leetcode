package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CoinChange2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            // 5=5
            // 5=2+2+1
            // 5=2+1+1+1
            // 5=1+1+1+1+1
            Arguments.of(
                5,
                intArrayOf(1, 2, 5),
                4
            ),
            Arguments.of(
                3,
                intArrayOf(2),
                0
            ),
            Arguments.of(
                10,
                intArrayOf(10),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should compute the number of combinations`(amount: Int, coins: IntArray, expected: Int) {
        val actual = CoinChange2.change(amount, coins)
        assertEquals(expected, actual)
    }
}