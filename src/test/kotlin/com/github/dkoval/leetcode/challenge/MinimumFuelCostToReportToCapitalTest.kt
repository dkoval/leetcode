package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumFuelCostToReportToCapital.MinimumFuelCostToReportToCapitalDFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumFuelCostToReportToCapitalTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3)),
                5,
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 1),
                    intArrayOf(3, 2),
                    intArrayOf(1, 0),
                    intArrayOf(0, 4),
                    intArrayOf(0, 5),
                    intArrayOf(4, 6)
                ),
                2,
                7
            )
        )
    }

    @Nested
    inner class MinimumFuelCostToReportToCapitalDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the minimum number of liters of fuel to reach the capital city`(
            roads: Array<IntArray>,
            seats: Int,
            expected: Long
        ) {
            MinimumFuelCostToReportToCapitalDFS().test(roads, seats, expected)
        }
    }
}

private fun MinimumFuelCostToReportToCapital.test(roads: Array<IntArray>, seats: Int, expected: Long) {
    val actual = minimumFuelCost(roads, seats)
    assertEquals(expected, actual)
}
