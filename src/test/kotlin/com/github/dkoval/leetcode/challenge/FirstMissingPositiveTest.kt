package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FirstMissingPositiveTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 0),
                3
            ),
            Arguments.of(
                intArrayOf(3, 4, -1, 1),
                2
            ),
            Arguments.of(
                intArrayOf(7, 8, 9, 11, 12),
                1
            ),
            Arguments.of(
                intArrayOf(1, 2, 3),
                4
            ),
            Arguments.of(
                intArrayOf(-5),
                1
            ),
            Arguments.of(
                intArrayOf(0, 1, 2),
                3
            )
        )
    }

    @Nested
    inner class FirstMissingPositiveBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the smallest missing positive integer`(nums: IntArray, expected: Int) {
            FirstMissingPositiveBruteForce.test(nums, expected)
        }
    }

    @Nested
    inner class FirstMissingPositiveBruteForceJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the smallest missing positive integer`(nums: IntArray, expected: Int) {
            FirstMissingPositiveBruteForceJava().test(nums, expected)
        }
    }

    @Nested
    inner class FirstMissingPositiveInLinearTimeUsingHashSetTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the smallest missing positive integer`(nums: IntArray, expected: Int) {
            FirstMissingPositiveInLinearTimeUsingHashSet.test(nums, expected)
        }
    }

    @Nested
    inner class FirstMissingPositiveInLinearTimeUsingHashSetJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the smallest missing positive integer`(nums: IntArray, expected: Int) {
            FirstMissingPositiveInLinearTimeUsingHashSetJava().test(nums, expected)
        }
    }

    @Nested
    inner class FirstMissingPositiveInLinearTimeAndConstantSpaceTest {

        @Nested
        inner class FirstMissingPositiveBruteForceJavaTest {

            @ParameterizedTest
            @ArgumentsSource(InputArgumentsProvider::class)
            fun `should find the smallest missing positive integer`(nums: IntArray, expected: Int) {
                FirstMissingPositiveInLinearTimeAndConstantSpace.test(nums, expected)
            }
        }
    }

    @Nested
    inner class FirstMissingPositiveInLinearTimeAndConstantSpaceJavaTest {

        @Nested
        inner class FirstMissingPositiveBruteForceJavaTest {

            @ParameterizedTest
            @ArgumentsSource(InputArgumentsProvider::class)
            fun `should find the smallest missing positive integer`(nums: IntArray, expected: Int) {
                FirstMissingPositiveInLinearTimeAndConstantSpaceJava().test(nums, expected)
            }
        }
    }

    private fun FirstMissingPositive.test(nums: IntArray, expected: Int) {
        val actual = firstMissingPositive(nums)
        assertEquals(expected, actual)
    }
}