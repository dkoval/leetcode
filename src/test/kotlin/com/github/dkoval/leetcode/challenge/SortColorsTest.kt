package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SortColors.SortColorsInTwoPasses
import com.github.dkoval.leetcode.challenge.SortColors.SortColorsWithCountingSort
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SortColorsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 0, 2, 1, 1, 0),
                intArrayOf(0, 0, 1, 1, 2, 2),
                intArrayOf(0),
                intArrayOf(1),
                intArrayOf(2)
            )
        )
    }

    @Nested
    inner class SortColorsInTwoPassesTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should sort colors`(nums: IntArray, expected: IntArray) {
            SortColorsInTwoPasses().test(nums, expected)
        }
    }

    @Nested
    inner class SortColorsWithCountingSortTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should sort colors`(nums: IntArray, expected: IntArray) {
            SortColorsWithCountingSort().test(nums, expected)
        }
    }

    @Nested
    inner class SortColorsUsingDutchFlagAlgorithmTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should sort colors`(nums: IntArray, expected: IntArray) {
            SortColorsUsingDutchFlagAlgorithm.test(nums, expected)
        }
    }

    private fun SortColors.test(nums: IntArray, expected: IntArray) {
        sortColors(nums)
        assertArrayEquals(expected, nums)
    }
}