package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumTimeToCompleteTrips.MinimumTimeToCompleteTripsUsingBinarySearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumTimeToCompleteTripsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3),
                5,
                3L
            ),
            Arguments.of(
                intArrayOf(2),
                1,
                2L
            ),
            Arguments.of(
                intArrayOf(9, 3, 10, 5),
                2,
                5L
            ),
            Arguments.of(
                intArrayOf(9, 7, 10, 9, 10, 9, 10),
                1,
                7L
            )
        )
    }

    @Nested
    inner class MinimumTimeToCompleteTripsUsingBinarySearchTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum time required for all buses to complete at least totalTrips trips`(
            time: IntArray,
            totalTrips: Int,
            expected: Long
        ) {
            MinimumTimeToCompleteTripsUsingBinarySearch().test(time, totalTrips, expected)
        }
    }
}

private fun MinimumTimeToCompleteTrips.test(time: IntArray, totalTrips: Int, expected: Long) {
    val actual = minimumTime(time, totalTrips)
    assertEquals(expected, actual)
}
