package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BestTimeToBuyAndSellStockWithCooldownTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2, 3, 0, 2),
                3 // transactions = [buy, sell, cooldown, buy, sell]
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the maximum profit`(prices: IntArray, expected: Int) {
        val actual = BestTimeToBuyAndSellStockWithCooldown.maxProfit(prices)
        assertEquals(expected, actual)
    }
}