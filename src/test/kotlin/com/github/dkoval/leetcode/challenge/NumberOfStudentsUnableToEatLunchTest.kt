package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfStudentsUnableToEatLunch.NumberOfStudentsUnableToEatLunchRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfStudentsUnableToEatLunchTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 1, 0, 0),
                intArrayOf(0, 1, 0, 1),
                0
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 0, 0, 1),
                intArrayOf(1, 0, 0, 0, 1, 1),
                3
            )
        )
    }

    @Nested
    inner class NumberOfStudentsUnableToEatLunchRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of students that are unable to eat`(
            students: IntArray,
            sandwiches: IntArray,
            expected: Int
        ) {
            NumberOfStudentsUnableToEatLunchRev1().test(students, sandwiches, expected)
        }
    }
}

private fun NumberOfStudentsUnableToEatLunch.test(students: IntArray, sandwiches: IntArray, expected: Int) {
    val actual = countStudents(students, sandwiches)
    assertEquals(actual, expected)
}
