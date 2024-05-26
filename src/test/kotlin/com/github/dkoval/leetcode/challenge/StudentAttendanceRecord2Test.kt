package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.StudentAttendanceRecord2.StudentAttendanceRecord2DPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class StudentAttendanceRecord2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(2, 8),
            Arguments.of(1, 3),
            // passes on LeetCode by fails locally with java.lang.StackOverflowError
            Arguments.of(10101, 183236316)
        )
    }

    @Nested
    inner class StudentAttendanceRecord2DPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of possible attendance records of length n that make a student eligible for an attendance award`(
            n: Int,
            expected: Int
        ) {
            StudentAttendanceRecord2DPTopDown().test(n, expected)
        }
    }
}

private fun StudentAttendanceRecord2.test(n: Int, expected: Int) {
    val actual = checkRecord(n)
    assertEquals(expected, actual)
}
