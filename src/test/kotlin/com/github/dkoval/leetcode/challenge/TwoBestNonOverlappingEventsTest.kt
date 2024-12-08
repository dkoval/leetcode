package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.TwoBestNonOverlappingEvents.TwoBestNonOverlappingEventsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class TwoBestNonOverlappingEventsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3, 2),
                    intArrayOf(4, 5, 2),
                    intArrayOf(2, 4, 3)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3, 2),
                    intArrayOf(4, 5, 2),
                    intArrayOf(1, 5, 5)
                ),
                5
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 5, 3),
                    intArrayOf(1, 5, 1),
                    intArrayOf(6, 6, 5)
                ),
                8
            )
        )
    }

    @Nested
    inner class TwoBestNonOverlappingEventsTestRev1 {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum sum of at most two non-overlapping events`(
            events: Array<IntArray>,
            expected: Int
        ) {
            TwoBestNonOverlappingEventsRev1().test(events, expected)
        }
    }
}

private fun TwoBestNonOverlappingEvents.test(events: Array<IntArray>, expected: Int) {
    val actual = maxTwoEvents(events)
    assertEquals(expected, actual)
}
