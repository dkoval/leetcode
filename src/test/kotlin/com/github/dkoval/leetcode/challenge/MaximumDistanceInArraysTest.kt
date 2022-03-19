package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumDistanceInArraysTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    listOf(1, 2, 3),
                    listOf(4, 5),
                    listOf(1, 2, 3)
                ),
                4
            ),
            Arguments.of(
                listOf(
                    listOf(1, 4),
                    listOf(0, 5)
                ),
                4
            ),
            Arguments.of(
                listOf(
                    listOf(1, 4, 5),
                    listOf(0, 2)
                ),
                5
            )
        )
    }

    @Nested
    inner class MaximumDistanceInArraysTest {
        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the maximum distance in arrays`(arrays: List<List<Int>>, expected: Int) {
            val actual = MaximumDistanceInArrays.maxDistance(arrays)
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class MaximumDistanceInArraysJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the maximum distance in arrays`(arrays: List<List<Int>>, expected: Int) {
            val actual = MaximumDistanceInArraysJava().maxDistance(arrays)
            assertEquals(expected, actual)
        }
    }
}