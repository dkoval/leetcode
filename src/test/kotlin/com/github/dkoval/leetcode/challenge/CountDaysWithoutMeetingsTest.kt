package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountDaysWithoutMeetings.CountDaysWithoutMeetingsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountDaysWithoutMeetingsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                10,
                arrayOf(
                    intArrayOf(5, 7),
                    intArrayOf(1, 3),
                    intArrayOf(9, 10)
                ),
                2
            ),
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(2, 4),
                    intArrayOf(1, 3)
                ),
                1
            ),
            Arguments.of(
                6,
                arrayOf(
                    intArrayOf(1, 6)
                ),
                0
            )
        )
    }

    @Nested
    inner class CountDaysWithoutMeetingsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of days without meetings`(
            days: Int,
            meetings: Array<IntArray>,
            expected: Int
        ) {
            CountDaysWithoutMeetingsRev1().test(days, meetings, expected)
        }
    }
}

private fun CountDaysWithoutMeetings.test(days: Int, meetings: Array<IntArray>, expected: Int) {
    val actual = countDays(days, meetings)
    assertEquals(expected, actual)
}
