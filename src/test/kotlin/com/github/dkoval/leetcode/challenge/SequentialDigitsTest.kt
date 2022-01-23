package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SequentialDigitsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                100,
                300,
                listOf(123, 234)
            ),
            Arguments.of(
                1000,
                13000,
                listOf(1234, 2345, 3456, 4567, 5678, 6789, 12345)
            )
        )
    }

    @Nested
    inner class SequentialDigitsIterTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a sorted list of all the integers in the low to high range  inclusive that have sequential digits`(
            low: Int,
            high: Int,
            expected: List<Int>
        ) {
            SequentialDigitsIter.test(low, high, expected)
        }
    }

    @Nested
    inner class SequentialDigitsGenAllInOrderIterTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a sorted list of all the integers in the low to high range  inclusive that have sequential digits`(
            low: Int,
            high: Int,
            expected: List<Int>
        ) {
            SequentialDigitsGenAllInOrderIter().test(low, high, expected)
        }
    }

    @Nested
    inner class SequentialDigitsIterOptimizedTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a sorted list of all the integers in the low to high range  inclusive that have sequential digits`(
            low: Int,
            high: Int,
            expected: List<Int>
        ) {
            SequentialDigitsIterOptimized.test(low, high, expected)
        }
    }

    @Nested
    inner class SequentialDigitsRecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a sorted list of all the integers in the low to high range  inclusive that have sequential digits`(
            low: Int,
            high: Int,
            expected: List<Int>
        ) {
            SequentialDigitsRecursive.test(low, high, expected)
        }
    }

    private fun SequentialDigits.test(low: Int, high: Int, expected: List<Int>) {
        val actual = sequentialDigits(low, high)
        assertEquals(expected, actual)
    }
}