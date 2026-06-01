package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumCostOfBuyingCandiesWithDiscount.MinimumCostOfBuyingCandiesWithDiscountRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MinimumCostOfBuyingCandiesWithDiscountTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3),
                5
            ),
            Arguments.of(
                intArrayOf(6, 5, 7, 9, 2, 2),
                23
            ),
            Arguments.of(
                intArrayOf(5, 5),
                10
            )
        )
    }

    @Nested
    inner class MinimumCostOfBuyingCandiesWithDiscountRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum cost of buying all the candies`(cost: IntArray, expected: Int) {
            MinimumCostOfBuyingCandiesWithDiscountRev1().test(cost, expected)
        }
    }
}

private fun MinimumCostOfBuyingCandiesWithDiscount.test(cost: IntArray, expected: Int) {
    val actual = minimumCost(cost)
    assertEquals(expected, actual)
}
