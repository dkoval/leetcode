package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumProfitInJobScheduling.MaximumProfitInJobSchedulingRev1
import com.github.dkoval.leetcode.challenge.MaximumProfitInJobScheduling.MaximumProfitInJobSchedulingRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumProfitInJobSchedulingTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 3),
                intArrayOf(3, 4, 5, 6),
                intArrayOf(50, 10, 40, 70),
                120
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 6),
                intArrayOf(3, 5, 10, 6, 9),
                intArrayOf(20, 20, 100, 70, 60),
                150
            ),
            Arguments.of(
                intArrayOf(1, 1, 1),
                intArrayOf(2, 3, 4),
                intArrayOf(5, 6, 4),
                6
            ),
            Arguments.of(
                intArrayOf(4, 2, 4, 8, 2),
                intArrayOf(5, 5, 5, 10, 8),
                intArrayOf(1, 2, 8, 10, 4),
                18
            )
        )
    }

    @Nested
    inner class MaximumProfitInJobSchedulingRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range`(
            startTime: IntArray,
            endTime: IntArray,
            profit: IntArray,
            expected: Int
        ) {
            MaximumProfitInJobSchedulingRev1().test(startTime, endTime, profit, expected)
        }
    }

    @Nested
    inner class MaximumProfitInJobSchedulingRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range`(
            startTime: IntArray,
            endTime: IntArray,
            profit: IntArray,
            expected: Int
        ) {
            MaximumProfitInJobSchedulingRev2().test(startTime, endTime, profit, expected)
        }
    }
}

private fun MaximumProfitInJobScheduling.test(startTime: IntArray, endTime: IntArray, profit: IntArray, expected: Int) {
    val actual = jobScheduling(startTime, endTime, profit)
    assertEquals(expected, actual)
}
