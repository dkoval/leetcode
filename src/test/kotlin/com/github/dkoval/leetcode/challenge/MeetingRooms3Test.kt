package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MeetingRooms3.MeetingRooms3Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MeetingRooms3Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                2,
                arrayOf(intArrayOf(0, 10), intArrayOf(1, 5), intArrayOf(2, 7), intArrayOf(3, 4)),
                0
            ),
            Arguments.of(
                3,
                arrayOf(intArrayOf(1, 20), intArrayOf(2, 10), intArrayOf(3, 5), intArrayOf(4, 9), intArrayOf(6, 8)),
                1
            ),
            Arguments.of(
                2,
                arrayOf(intArrayOf(0, 10), intArrayOf(1, 2), intArrayOf(12, 14), intArrayOf(13, 15)),
                0
            )
        )
    }

    @Nested
    inner class MeetingRooms3Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should Return the number of the room that held the most meetings, if there are multiple rooms, return the room with the lowest number`(
            n: Int,
            meetings: Array<IntArray>,
            expected: Int
        ) {
            MeetingRooms3Rev1().test(n, meetings, expected)
        }
    }
}

private fun MeetingRooms3.test(n: Int, meetings: Array<IntArray>, expected: Int) {
    val actual = mostBooked(n, meetings)
    assertEquals(expected, actual)
}
