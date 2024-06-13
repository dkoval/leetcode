package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumNumberOfMovesToSeatEveryone.MinimumNumberOfMovesToSeatEveryoneRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumNumberOfMovesToSeatEveryoneTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 1, 5),
                intArrayOf(2, 7, 4),
                4
            ),
            Arguments.of(
                intArrayOf(4, 1, 5, 9),
                intArrayOf(1, 3, 2, 6),
                7
            ),
            Arguments.of(
                intArrayOf(2, 2, 6, 6),
                intArrayOf(1, 3, 2, 6),
                4
            )
        )
    }

    @Nested
    inner class MinimumNumberOfMovesToSeatEveryoneRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of moves required to move each student to a seat such that no two students are in the same seat`(
            seats: IntArray,
            students: IntArray,
            expected: Int
        ) {
            MinimumNumberOfMovesToSeatEveryoneRev1().test(seats, students, expected)
        }
    }
}

private fun MinimumNumberOfMovesToSeatEveryone.test(seats: IntArray, students: IntArray, expected: Int) {
    val actual = minMovesToSeat(seats, students)
    assertEquals(expected, actual)
}
