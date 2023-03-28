package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumCostForTickets.MinimumCostForTicketsDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumCostForTicketsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 4, 6, 7, 8, 20),
                intArrayOf(2, 7, 15),
                11
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31),
                intArrayOf(2, 7, 15),
                17
            )
        )
    }

    @Nested
    inner class MinimumCostForTicketsDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of dollars you need to travel every day in the given list of days`(
            days: IntArray,
            costs: IntArray,
            expected: Int
        ) {
            MinimumCostForTicketsDPTopDown().test(days, costs, expected)
        }
    }

    @Nested
    inner class MinimumCostForTicketsDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of dollars you need to travel every day in the given list of days`(
            days: IntArray,
            costs: IntArray,
            expected: Int
        ) {
            MinimumCostForTicketsDPBottomUp.test(days, costs, expected)
        }
    }
}

private fun MinimumCostForTickets.test(days: IntArray, costs: IntArray, expected: Int) {
    val actual = mincostTickets(days, costs)
    assertEquals(expected, actual)
}
