package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumCostToAcquireRequiredItems.MinimumCostToAcquireRequiredItemsRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MinimumCostToAcquireRequiredItemsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(3, 2, 1, 3, 3, 3L),
            arguments(5, 4, 15, 2, 3, 22L),
            arguments(5, 4, 15, 0, 0, 0L),
            arguments(388168, 988887, 336014, 50411, 252237, 84755163318L),
        )
    }

    @Nested
    inner class MinimumCostToAcquireRequiredItemsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an integer representing the minimum possible total cost to achieve requirements`(
            cost1: Int, cost2: Int, costBoth: Int, need1: Int, need2: Int, expected: Long
        ) {
            MinimumCostToAcquireRequiredItemsRev1().test(cost1, cost2, costBoth, need1, need2, expected)
        }
    }
}

private fun MinimumCostToAcquireRequiredItems.test(
    cost1: Int,
    cost2: Int,
    costBoth: Int,
    need1: Int,
    need2: Int,
    expected: Long
) {
    val actual = minimumCost(cost1, cost2, costBoth, need1, need2)
    assertThat(actual).isEqualTo(expected)
}
