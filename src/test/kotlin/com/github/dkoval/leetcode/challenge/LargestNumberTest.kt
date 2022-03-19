package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LargestNumberTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(10, 2),
                "210"
            ),
            Arguments.of(
                intArrayOf(3, 30, 34, 5, 9),
                "9534330"
            ),
            Arguments.of(
                intArrayOf(0, 0),
                "0"
            )
        )
    }

    @Nested
    inner class LargestNumberKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should arrange integers such that they form the largest number`(nums: IntArray, expected: String) {
            val actual = LargestNumberKt.largestNumber(nums)
            assertEquals(expected, actual)
        }
    }


    @Nested
    inner class LargestNumberJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should arrange integers such that they form the largest number`(nums: IntArray, expected: String) {
            val actual = LargestNumberJava().largestNumber(nums)
            assertEquals(expected, actual)
        }
    }

    private fun LargestNumber.test(nums: IntArray, expected: String) {
        val actual = largestNumber(nums)
        assertEquals(expected, actual)
    }
}