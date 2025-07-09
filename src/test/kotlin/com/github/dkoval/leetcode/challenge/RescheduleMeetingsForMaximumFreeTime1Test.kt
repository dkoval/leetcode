package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RescheduleMeetingsForMaximumFreeTime1.RescheduleMeetingsForMaximumFreeTime1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RescheduleMeetingsForMaximumFreeTime1Test {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                5,
                1,
                intArrayOf(1, 3),
                intArrayOf(2, 5),
                2
            ),
            Arguments.of(
                10,
                1,
                intArrayOf(0, 2, 9),
                intArrayOf(1, 4, 10),
                6
            ),
            Arguments.of(
                5,
                2,
                intArrayOf(0, 1, 2, 3, 4),
                intArrayOf(1, 2, 3, 4, 5),
                0
            )
        )
    }

    @Nested
    inner class RescheduleMeetingsForMaximumFreeTime1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return maximum free time after rescheduling meetings`(
            eventTime: Int,
            k: Int,
            startTime: IntArray,
            endTime: IntArray,
            expected: Int
        ) {
            RescheduleMeetingsForMaximumFreeTime1Rev1().test(eventTime, k, startTime, endTime, expected)
        }
    }
}

private fun RescheduleMeetingsForMaximumFreeTime1.test(
    eventTime: Int,
    k: Int,
    startTime: IntArray,
    endTime: IntArray,
    expected: Int
) {
    val actual = maxFreeTime(eventTime, k, startTime, endTime)
    assertEquals(expected, actual)
}
