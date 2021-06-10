package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MyCalendar1.MyCalendar1BruteForce
import com.github.dkoval.leetcode.challenge.MyCalendar1.MyCalendar1UsingTreeMap
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
                listOf(
                    BookCommand(10, 20, true),
                    BookCommand(15, 25, false),
                    BookCommand(20, 30, true)
                )
            ),
            Arguments.of(
                listOf(
                    BookCommand(47, 50, true),
                    BookCommand(33, 41, true),
                    BookCommand(39, 45, false),
                    BookCommand(33, 42, false),
                    BookCommand(25, 32, true),
                    BookCommand(26, 35, false),
                    BookCommand(19, 25, true),
                    BookCommand(3, 8, true),
                    BookCommand(8, 13, true),
                    BookCommand(18, 27, false)
                )
            )
        )
    }

    class BookCommand(val start: Int, val end: Int, val expected: Boolean)

    @Nested
    inner class MyCalendar1BruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should  return true if the event can be added to the calendar successfully without causing a double booking`(
            commands: List<BookCommand>
        ) {
            MyCalendar1BruteForce().test(commands)
        }
    }

    @Nested
    inner class MyCalendar1UsingTreeMapTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should  return true if the event can be added to the calendar successfully without causing a double booking`(
            commands: List<BookCommand>
        ) {
            MyCalendar1UsingTreeMap().test(commands)
        }
    }

    private fun MyCalendar1.test(commands: List<BookCommand>) {
        for (command in commands) {
            val actual = book(command.start, command.end)
            assertEquals(command.expected, actual)
        }
    }
}