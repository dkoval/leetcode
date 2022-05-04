package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaxNumberOfKSumPairs.MaxNumberOfKSumPairsUsingHashMap
import com.github.dkoval.leetcode.challenge.MaxNumberOfKSumPairs.MaxNumberOfKSumPairsUsingSorting
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaxNumberOfKSumPairsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                5,
                2
            ),
            Arguments.of(
                intArrayOf(3, 1, 3, 4, 3),
                6,
                1
            )
        )
    }

    @Nested
    inner class MaxNumberOfKSumPairsUsingHashMapTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of operations you can perform on the array`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            MaxNumberOfKSumPairsUsingHashMap().test(nums, k, expected)
        }
    }

    @Nested
    inner class MaxNumberOfKSumPairsUsingSortingTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of operations you can perform on the array`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            MaxNumberOfKSumPairsUsingSorting().test(nums, k, expected)
        }
    }

    private fun MaxNumberOfKSumPairs.test(nums: IntArray, k: Int, expected: Int) {
        val actual = maxOperations(nums, k)
        assertEquals(expected, actual)
    }
}