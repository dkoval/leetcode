package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfSmallestUnoccupiedChair.NumberOfSmallestUnoccupiedChairRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfSmallestUnoccupiedChairTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(2, 3),
                    intArrayOf(4, 6)
                ),
                1,
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 10),
                    intArrayOf(1, 5),
                    intArrayOf(2, 6)
                ),
                0,
                2
            )
        )
    }

    @Nested
    inner class NumberOfSmallestUnoccupiedChairRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the chair number that the friend numbered targetFriend will sit on`(
            times: Array<IntArray>,
            targetFriend: Int,
            expected: Int
        ) {
            NumberOfSmallestUnoccupiedChairRev1().test(times, targetFriend, expected)
        }
    }
}

private fun NumberOfSmallestUnoccupiedChair.test(times: Array<IntArray>, targetFriend: Int, expected: Int) {
    val actual = smallestChair(times, targetFriend)
    assertEquals(expected, actual)
}
