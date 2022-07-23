package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.MinimumSpeedToArriveOnTime.MinimumSpeedToArriveOnTimeUsingBinarySearchRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumSpeedToArriveOnTimeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 2),
                6.0,
                1
            ),
            Arguments.of(
                intArrayOf(1, 3, 2),
                2.7,
                3
            ),
            Arguments.of(
                intArrayOf(1, 3, 2),
                1.9,
                -1
            ),
            Arguments.of(
                intArrayOf(1, 1, 100000),
                2.01,
                10000000
            )
        )
    }

    @Nested
    inner class MinimumSpeedToArriveOnTimeUsingBinarySearchRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum positive integer speed that all the trains must travel at for you to reach the office on time`(
            dist: IntArray,
            hour: Double,
            expected: Int
        ) {
            MinimumSpeedToArriveOnTimeUsingBinarySearchRev1().test(dist, hour, expected)
        }
    }

    private fun MinimumSpeedToArriveOnTime.test(dist: IntArray, hour: Double, expected: Int) {
        val actual = minSpeedOnTime(dist, hour)
        assertEquals(expected, actual)
    }
}