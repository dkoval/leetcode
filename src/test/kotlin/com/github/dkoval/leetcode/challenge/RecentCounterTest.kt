package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfRecentCalls.RecentCounterJava
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RecentCounterTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    Input(1, 1),
                    Input(100, 2),
                    Input(3001, 3),
                    Input(3002, 3)
                )
            )
        )
    }

    internal data class Input(val time: Int, val numRequests: Int)

    @Nested
    inner class RecentCounterJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun shouldCountNumberOfRecentRequestsWithinCertainTimeFrame(expected: List<Input>) {
            RecentCounterJava().test(expected)
        }
    }

    @Nested
    inner class RecentCounterKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun shouldCountNumberOfRecentRequestsWithinCertainTimeFrame(expected: List<Input>) {
            RecentCounterKt().test(expected)
        }
    }

    private fun RecentCounter.test(expected: List<Input>) {
        for (input in expected) {
            val numRequests = ping(input.time)
            assertEquals(input.numRequests, numRequests)
        }
    }
}