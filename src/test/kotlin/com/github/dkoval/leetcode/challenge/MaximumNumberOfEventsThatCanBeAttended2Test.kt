package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumNumberOfEventsThatCanBeAttended2.MaximumNumberOfEventsThatCanBeAttended2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumNumberOfEventsThatCanBeAttended2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 4),
                    intArrayOf(3, 4, 3),
                    intArrayOf(2, 3, 1)
                ),
                2,
                7
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 4),
                    intArrayOf(3, 4, 3),
                    intArrayOf(2, 3, 10)
                ),
                2,
                10
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(2, 2, 2),
                    intArrayOf(3, 3, 3),
                    intArrayOf(4, 4, 4),
                ),
                3,
                9
            )
        )
    }

    @Nested
    inner class MaximumNumberOfEventsThatCanBeAttended2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum sum of values that you can receive by attending events`(
            events: Array<IntArray>,
            k: Int,
            expected: Int
        ) {
            MaximumNumberOfEventsThatCanBeAttended2Rev1().test(events, k, expected)
        }
    }
}

private fun MaximumNumberOfEventsThatCanBeAttended2.test(events: Array<IntArray>, k: Int, expected: Int) {
    val actual = maxValue(events, k)
    assertEquals(expected, actual)
}
