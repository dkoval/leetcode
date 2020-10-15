package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MeetingRooms2.MeetingRooms2UsingSortingAndPriorityQueue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MeetingRooms2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 30),
                    intArrayOf(5, 10),
                    intArrayOf(15, 20)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(7, 10),
                    intArrayOf(2, 4)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(10, 15),
                    intArrayOf(15, 16),
                    intArrayOf(16, 25)
                ),
                1
            )
        )
    }

    @Nested
    inner class MeetingRooms2UsingSortingAndPriorityQueueTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the minimum number of conference rooms required`(intervals: Array<IntArray>, expected: Int) {
            MeetingRooms2UsingSortingAndPriorityQueue().test(intervals, expected)
        }
    }

    private fun MeetingRooms2.test(intervals: Array<IntArray>, expected: Int) {
        val actual = minMeetingRooms(intervals)
        assertEquals(expected, actual)
    }
}