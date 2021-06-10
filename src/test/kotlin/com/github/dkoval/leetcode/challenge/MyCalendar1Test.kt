package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MyCalendar1.MyCalendar1BruteForce
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MyCalendar1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                10, 20, true
            ),
            Arguments.of(
                15, 25, false
            ),
            Arguments.of(
                20, 30, true
            )
        )
    }

    companion object {
        private val myCalendar1BruteForce: MyCalendar1 = MyCalendar1BruteForce()
    }

    @Nested
    inner class MyCalendar1BruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should  return true if the event can be added to the calendar successfully without causing a double booking`(
            start: Int,
            end: Int,
            expected: Boolean
        ) {
            myCalendar1BruteForce.test(start, end, expected)
        }
    }

    private fun MyCalendar1.test(start: Int, end: Int, expected: Boolean) {
        val actual = book(start, end)
        assertEquals(expected, actual)
    }
}