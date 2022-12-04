package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumAverageDifference.MinimumAverageDifferenceRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumAverageDifferenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 5, 3, 9, 5, 3),
                3
            ),
            Arguments.of(
                intArrayOf(0),
                0
            )
        )
    }

    @Nested
    inner class MinimumAverageDifferenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the index with the minimum average difference`(nums: IntArray, expected: Int) {
            MinimumAverageDifferenceRev1().test(nums, expected)
        }
    }

    private fun MinimumAverageDifference.test(nums: IntArray, expected: Int) {
        val actual = minimumAverageDifference(nums)
        assertEquals(expected, actual)
    }
}