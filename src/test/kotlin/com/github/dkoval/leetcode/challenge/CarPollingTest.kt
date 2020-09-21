package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CarPollingTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 1, 5),
                    intArrayOf(3, 3, 7)
                ),
                4,
                false
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 1, 5),
                    intArrayOf(3, 3, 7)
                ),
                5,
                true
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 1, 5),
                    intArrayOf(3, 5, 7)
                ),
                3,
                true
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 2, 7),
                    intArrayOf(3, 7, 9),
                    intArrayOf(8, 3, 9)
                ),
                11,
                true
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(9, 3, 4),
                    intArrayOf(9, 1, 7),
                    intArrayOf(4, 2, 4),
                    intArrayOf(7, 4, 5)
                ),
                23,
                true
            )
        )
    }

    @Nested
    inner class CarPollingUsingSortedMapTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if and only if it is possible to pick up and drop off all passengers for all the given trips`(
            trips: Array<IntArray>,
            capacity: Int,
            expected: Boolean
        ) {
            CarPollingUsingSortedMap.test(trips, capacity, expected)
        }
    }

    private fun CarPolling.test(trips: Array<IntArray>, capacity: Int, expected: Boolean) {
        val actual = carPooling(trips, capacity)
        assertEquals(expected, actual)
    }

    @Nested
    inner class CarPollingUsingArrayTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if and only if it is possible to pick up and drop off all passengers for all the given trips`(
            trips: Array<IntArray>,
            capacity: Int,
            expected: Boolean
        ) {
            CarPollingUsingArray.test(trips, capacity, expected)
        }
    }
}