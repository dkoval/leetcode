package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountServersThatCommunicate.CountServersThatCommunicateRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountServersThatCommunicateTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 1)
                ),
                0
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(1, 1)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 0, 0),
                    intArrayOf(0, 0, 1, 0),
                    intArrayOf(0, 0, 1, 0),
                    intArrayOf(0, 0, 0, 1)
                ),
                4
            )
        )
    }

    @Nested
    inner class CountServersThatCommunicateRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of servers that communicate with any other server`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            CountServersThatCommunicateRev1().test(grid, expected)
        }
    }
}

private fun CountServersThatCommunicate.test(grid: Array<IntArray>, expected: Int) {
    val actual = countServers(grid)
    assertEquals(expected, actual)
}
