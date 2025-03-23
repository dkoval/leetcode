package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfWaysToArriveAtDestination.NumberOfWaysToArriveAtDestinationRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfWaysToArriveAtDestinationTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                7,
                arrayOf(
                    intArrayOf(0, 6, 7),
                    intArrayOf(0, 1, 2),
                    intArrayOf(1, 2, 3),
                    intArrayOf(1, 3, 3),
                    intArrayOf(6, 3, 3),
                    intArrayOf(3, 5, 1),
                    intArrayOf(6, 5, 1),
                    intArrayOf(2, 5, 1),
                    intArrayOf(0, 4, 5),
                    intArrayOf(4, 6, 2)
                ),
                4
            ),
            Arguments.of(
                2,
                arrayOf(
                    intArrayOf(1, 0, 10)
                ),
                1
            )
        )
    }

    @Nested
    inner class NumberOfWaysToArriveAtDestinationRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of ways you can arrive at your destination in the shortest amount of time`(
            n: Int,
            roads: Array<IntArray>,
            expected: Int
        ) {
            NumberOfWaysToArriveAtDestinationRev1().test(n, roads, expected)
        }
    }
}

private fun NumberOfWaysToArriveAtDestination.test(n: Int, roads: Array<IntArray>, expected: Int) {
    val actual = countPaths(n, roads)
    assertEquals(expected, actual)
}
