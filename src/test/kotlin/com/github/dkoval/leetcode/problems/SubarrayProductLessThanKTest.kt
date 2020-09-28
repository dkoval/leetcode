package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.challenge.SubarrayProductLessThanKBruteForceJava
import com.github.dkoval.leetcode.challenge.SubarrayProductLessThanKUsingWindowJava
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SubarrayProductLessThanKTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(10, 5, 2, 6),
                100,
                // The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
                // Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
                8
            ),
            Arguments.of(
                intArrayOf(10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3),
                19,
                18
            )
        )
    }

    @Nested
    inner class SubarrayProductLessThanKBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count subarrays where the product of all the elements in the subarray is less than k`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            SubarrayProductLessThanKBruteForce.test(nums, k, expected)
        }
    }

    @Nested
    inner class SubarrayProductLessThanKUsingWindowTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count subarrays where the product of all the elements in the subarray is less than k`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            SubarrayProductLessThanKUsingWindow.test(nums, k, expected)
        }
    }

    @Nested
    inner class SubarrayProductLessThanKBruteForceJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count subarrays where the product of all the elements in the subarray is less than k`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            SubarrayProductLessThanKBruteForceJava().test(nums, k, expected)
        }
    }

    @Nested
    inner class SubarrayProductLessThanKUsingWindowJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count subarrays where the product of all the elements in the subarray is less than k`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            SubarrayProductLessThanKUsingWindowJava().test(nums, k, expected)
        }
    }

    private fun SubarrayProductLessThanK.test(nums: IntArray, k: Int, expected: Int) {
        val actual = numSubarrayProductLessThanK(nums, k)
        assertEquals(expected, actual)
    }
}