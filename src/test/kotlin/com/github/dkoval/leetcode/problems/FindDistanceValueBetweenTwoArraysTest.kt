package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.FindDistanceValueBetweenTwoArrays.FindDistanceValueBetweenTwoArraysBinarySearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindDistanceValueBetweenTwoArraysTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 5, 8),
                intArrayOf(10, 9, 1, 8),
                2,
                2
            ),
            Arguments.of(
                intArrayOf(1, 4, 2, 3),
                intArrayOf(-4, -3, 6, 10, 20, 30),
                3,
                2
            ),
            Arguments.of(
                intArrayOf(2, 1, 100, 3),
                intArrayOf(-5, -2, 10, -3, 7),
                6,
                1
            )
        )
    }

    @Nested
    inner class FindDistanceValueBetweenTwoArraysBinarySearchTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the distance value between the two arrays`(
            arr1: IntArray,
            arr2: IntArray,
            d: Int,
            expected: Int
        ) {
            FindDistanceValueBetweenTwoArraysBinarySearch().test(arr1, arr2, d, expected)
        }
    }

    private fun FindDistanceValueBetweenTwoArrays.test(arr1: IntArray, arr2: IntArray, d: Int, expected: Int) {
        val actual = findTheDistanceValue(arr1, arr2, d)
        assertEquals(expected, actual)
    }
}