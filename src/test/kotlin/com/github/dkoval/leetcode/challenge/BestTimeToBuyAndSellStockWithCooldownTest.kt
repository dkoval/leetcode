package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BestTimeToBuyAndSellStockWithCooldown.BestTimeToBuyAndSellStockWithCooldownDPTopDown
import com.github.dkoval.leetcode.challenge.BestTimeToBuyAndSellStockWithCooldown.BestTimeToBuyAndSellStockWithCooldownDPTopDownRemastered
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BestTimeToBuyAndSellStockWithCooldownTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 0, 2),
                // transactions = [buy, sell, cooldown, buy, sell]
                // -1 + 2 + 0 + 0 + 2 = 3
                3
            ),
            Arguments.of(
                intArrayOf(1),
                0
            )
        )
    }

    @Nested
    inner class BestTimeToBuyAndSellStockWithCooldownDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the maximum profit`(prices: IntArray, expected: Int) {
            BestTimeToBuyAndSellStockWithCooldownDPTopDown().test(prices, expected)
        }
    }

    @Nested
    inner class BestTimeToBuyAndSellStockWithCooldownDPTopDownRemasteredTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the maximum profit`(prices: IntArray, expected: Int) {
            BestTimeToBuyAndSellStockWithCooldownDPTopDownRemastered().test(prices, expected)
        }
    }

    @Nested
    inner class BestTimeToBuyAndSellStockWithCooldownDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the maximum profit`(prices: IntArray, expected: Int) {
            BestTimeToBuyAndSellStockWithCooldownDPBottomUp.test(prices, expected)
        }
    }

    private fun BestTimeToBuyAndSellStockWithCooldown.test(prices: IntArray, expected: Int) {
        val actual = maxProfit(prices)
        assertEquals(expected, actual)
    }
}