package com.github.dkoval.leetcode.mock

import com.github.dkoval.leetcode.mock.MyCalendarTwo.MyCalendarTwoBoundaryCount
import com.github.dkoval.leetcode.mock.MyCalendarTwo.MyCalendarTwoBruteForce
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MyCalendarTwoTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
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
    inner class MyCalendarTwoBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate solution`(input: Map<IntArray, Boolean>) {
            MyCalendarTwoBruteForce().test(input)
        }
    }

    @Nested
    inner class MyCalendarTwoBoundaryCountTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate solution`(input: Map<IntArray, Boolean>) {
            MyCalendarTwoBoundaryCount().test(input)
        }
    }

    private fun MyCalendarTwo.test(input: Map<IntArray, Boolean>) {
        for ((event, expected) in input) {
            val actual = book(event[0], event[1])
            assertEquals(expected, actual)
        }
    }
}