package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SearchInRotatedSortedArray2.SearchInRotatedSortedArray2Rev1
import com.github.dkoval.leetcode.challenge.SearchInRotatedSortedArray2.SearchInRotatedSortedArray2Rev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SearchInRotatedSortedArray2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 5, 6, 0, 0, 1, 2),
                0,
                true
            ),
            Arguments.of(
                intArrayOf(2, 5, 6, 0, 0, 1, 2),
                3,
                false
            ),
            Arguments.of(
                intArrayOf(2, 2, 2, 3, 2, 2, 2),
                3,
                true
            ),
            Arguments.of(
                intArrayOf(3, 1),
                1,
                true
            )
        )
    }

    @Nested
    inner class SearchInRotatedSortedArray2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should search in rotated sorted array with duplicates`(nums: IntArray, target: Int, expected: Boolean) {
            SearchInRotatedSortedArray2Rev1().test(nums, target, expected)
        }
    }

    @Nested
    inner class SearchInRotatedSortedArray2Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should search in rotated sorted array with duplicates`(nums: IntArray, target: Int, expected: Boolean) {
            SearchInRotatedSortedArray2Rev2().test(nums, target, expected)
        }
    }

    private fun SearchInRotatedSortedArray2.test(nums: IntArray, target: Int, expected: Boolean) {
        val actual = search(nums, target)
        assertEquals(expected, actual)
    }
}