package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class TeemoAttackingTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 4),
                2,
                // Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned immediately.
                // This poisoned status will last 2 seconds until the end of time point 2.
                // And at time point 4, Teemo attacks Ashe again, and causes Ashe to be in poisoned status for another 2 seconds.
                // So you finally need to output 4.
                4
            ),
            Arguments.of(
                intArrayOf(1, 2),
                2,
                // Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned.
                // This poisoned status will last 2 seconds until the end of time point 2.
                // However, at the beginning of time point 2, Teemo attacks Ashe again who is already in poisoned status.
                // Since the poisoned status won't add up together, though the second poisoning attack will still work at time point 2, it will stop at the end of time point 3.
                // So you finally need to output 3.
                3
            )
        )
    }

    @Nested
    inner class TeemoAttackingKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the total time that Ashe is in poisoned condition`(
            timeSeries: IntArray,
            duration: Int,
            expected: Int
        ) {
            TeemoAttackingKt.test(timeSeries, duration, expected)
        }
    }

    @Nested
    inner class TeemoAttackingJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the total time that Ashe is in poisoned condition`(
            timeSeries: IntArray,
            duration: Int,
            expected: Int
        ) {
            TeemoAttackingJava().test(timeSeries, duration, expected)
        }
    }

    private fun TeemoAttacking.test(timeSeries: IntArray, duration: Int, expected: Int) {
        val actual = findPoisonedDuration(timeSeries, duration)
        assertEquals(expected, actual)
    }
}