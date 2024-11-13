package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountNumberOfFairPairs.CountNumberOfFairPairsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountNumberOfFairPairsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0, 1, 7, 4, 4, 5),
                3,
                6,
                6L
            ),
            Arguments.of(
                intArrayOf(1, 7, 9, 2, 5),
                11,
                11,
                1
            ),
            Arguments.of(
                intArrayOf(0, 0, 0, 0, 0, 0),
                0,
                0,
                15
            )
        )
    }

    @Nested
    inner class CountNumberOfFairPairsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of fair pairs`(nums: IntArray, lower: Int, upper: Int, expected: Long) {
            CountNumberOfFairPairsRev1().test(nums, lower, upper, expected)
        }
    }
}

private fun CountNumberOfFairPairs.test(nums: IntArray, lower: Int, upper: Int, expected: Long) {
    val actual = countFairPairs(nums, lower, upper)
    assertEquals(expected, actual)
}
