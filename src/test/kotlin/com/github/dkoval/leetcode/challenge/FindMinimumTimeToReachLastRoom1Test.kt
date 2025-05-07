package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindMinimumTimeToReachLastRoom1.FindMinimumTimeToReachLastRoom1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindMinimumTimeToReachLastRoom1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 4),
                    intArrayOf(4, 4),
                ),
                6
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 0, 0),
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                ),
                3
            )
        )
    }

    @Nested
    inner class FindMinimumTimeToReachLastRoom1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the minimum time to reach the room`(moveTime: Array<IntArray>, expected: Int) {
            FindMinimumTimeToReachLastRoom1Rev1().test(moveTime, expected)
        }
    }
}

private fun FindMinimumTimeToReachLastRoom1.test(moveTime: Array<IntArray>, expected: Int) {
    val actual = minTimeToReach(moveTime)
    assertEquals(expected, actual)
}
