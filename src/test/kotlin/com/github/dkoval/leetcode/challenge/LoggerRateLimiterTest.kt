package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LoggerRateLimiterTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    TestInput(1, "foo", true),
                    TestInput(2, "bar", true),
                    TestInput(3, "foo", false),
                    TestInput(8, "bar", false),
                    TestInput(10, "foo", false),
                    TestInput(11, "foo", true)
                )
            )
        )
    }

    @Nested
    inner class SetAndQueueLoggerTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `verify solution`(input: Array<TestInput>) {
            LoggerRateLimiter.SetAndQueueLogger().test(input)
        }
    }

    @Nested
    inner class TwoMapsLoggerTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `verify solution`(input: Array<TestInput>) {
            LoggerRateLimiter.TwoMapsLogger().test(input)
        }
    }

    data class TestInput(
        val timestamp: Int,
        val message: String,
        val expected: Boolean
    )

    private fun LoggerRateLimiter.Logger.test(input: Array<TestInput>) {
        input.forEach { (timestamp, message, expected) ->
            assertEquals(shouldPrintMessage(timestamp, message), expected)
        }
    }
}