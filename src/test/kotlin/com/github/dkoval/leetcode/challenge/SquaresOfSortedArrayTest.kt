package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SquaresOfSortedArray.SquaresOfSortedArrayUsingSorting
import com.github.dkoval.leetcode.challenge.SquaresOfSortedArray.SquaresOfSortedArrayUsingTwoPointers
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SquaresOfSortedArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(-4, -1, 0, 3, 10),
                intArrayOf(0, 1, 9, 16, 100)
            ),
            Arguments.of(
                intArrayOf(-7, -3, 2, 3, 11),
                intArrayOf(4, 9, 9, 49, 121)
            )
        )
    }

    @Nested
    inner class SquaresOfSortedArrayUsingSortingTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of the squares of each number sorted in non-decreasing order`(
            nums: IntArray,
            expected: IntArray
        ) {
            SquaresOfSortedArrayUsingSorting().test(nums, expected)
        }
    }

    @Nested
    inner class SquaresOfSortedArrayUsingTwoPointersTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of the squares of each number sorted in non-decreasing order`(
            nums: IntArray,
            expected: IntArray
        ) {
            SquaresOfSortedArrayUsingTwoPointers().test(nums, expected)
        }
    }

    private fun SquaresOfSortedArray.test(nums: IntArray, expected: IntArray) {
        val actual = sortedSquares(nums)
        assertArrayEquals(expected, actual)
    }
}