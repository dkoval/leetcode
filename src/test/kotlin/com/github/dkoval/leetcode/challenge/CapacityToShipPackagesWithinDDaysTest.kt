package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CapacityToShipPackagesWithinDDays.CapacityToShipPackagesWithinDDaysUsingBinarySearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CapacityToShipPackagesWithinDDaysTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                5,
                15
            ),
            Arguments.of(
                intArrayOf(3, 2, 2, 4, 1, 4),
                3,
                6
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 1, 1),
                4,
                3
            )
        )
    }

    @Nested
    inner class CapacityToShipPackagesWithinDDaysUsingBinarySearchTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the least weight capacity of the ship that will result in all the packages being shipped within d days`(
            weights: IntArray,
            days: Int,
            expected: Int
        ) {
            CapacityToShipPackagesWithinDDaysUsingBinarySearch().test(weights, days, expected)
        }
    }
}

private fun CapacityToShipPackagesWithinDDays.test(weights: IntArray, days: Int, expected: Int) {
    val actual = shipWithinDays(weights, days)
    assertEquals(expected, actual)
}
