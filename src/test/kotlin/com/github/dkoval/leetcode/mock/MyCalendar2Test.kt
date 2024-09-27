package com.github.dkoval.leetcode.mock

import com.github.dkoval.leetcode.mock.MyCalendar2.MyCalendar2BoundaryCount
import com.github.dkoval.leetcode.mock.MyCalendar2.MyCalendar2BruteForce
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream
import kotlin.streams.asStream

internal class MyCalendar2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                mapOf(
                    intArrayOf(10, 20) to true,
                    intArrayOf(50, 60) to true,
                    intArrayOf(10, 40) to true,
                    intArrayOf(5, 15) to false,
                    intArrayOf(5, 10) to true,
                    intArrayOf(25, 55) to true
                )
            )
        )
    }

    @Nested
    inner class MyCalendar2BruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate solution`(input: Map<IntArray, Boolean>) {
            MyCalendar2BruteForce().test(input)
        }
    }

    @Nested
    inner class MyCalendar2BoundaryCountTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate solution`(input: Map<IntArray, Boolean>) {
            MyCalendar2BoundaryCount().test(input)
        }
    }
}

private fun MyCalendar2.test(input: Map<IntArray, Boolean>) {
    assertAll(input.asSequence()
        .map { (event, expected) ->
            {
                val actual = book(event[0], event[1])
                assertEquals(expected, actual)
            }
        }
        .asStream()
    )
}
