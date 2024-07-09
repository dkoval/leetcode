package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.AverageWaitingTime.AverageWaitingTimeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AverageWaitingTimeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 5),
                    intArrayOf(4, 3)
                ),
                5.00000
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(5, 2),
                    intArrayOf(5, 4),
                    intArrayOf(10, 3),
                    intArrayOf(20, 1)
                ),
                3.25000
            )
        )
    }

    @Nested
    inner class AverageWaitingTimeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the average waiting time of all customers`(customers: Array<IntArray>, expected: Double) {
            AverageWaitingTimeRev1().test(customers, expected)
        }
    }
}

private fun AverageWaitingTime.test(customers: Array<IntArray>, expected: Double) {
    val actual = averageWaitingTime(customers)
    assertEquals(expected, actual, 1e-5)
}
