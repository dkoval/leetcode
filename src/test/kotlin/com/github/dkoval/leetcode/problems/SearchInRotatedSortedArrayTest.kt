package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.SearchInRotatedSortedArray.SearchInRotatedSortedArrayByChoosingSortedPart
import com.github.dkoval.leetcode.problems.SearchInRotatedSortedArray.SearchInRotatedSortedArrayByFindingIndexOfPivot
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SearchInRotatedSortedArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 5, 6, 7, 0, 1, 2),
                0,
                4
            ),
            Arguments.of(
                intArrayOf(4, 5, 6, 7, 0, 1, 2),
                3,
                -1
            ),
            Arguments.of(
                intArrayOf(1),
                0,
                -1
            ),
            Arguments.of(
                intArrayOf(3, 1),
                1,
                1
            ),
            Arguments.of(
                intArrayOf(3, 1),
                3,
                0
            )
        )
    }

    @Nested
    inner class SearchInRotatedSortedArrayByChoosingSortedPartTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the index of target after the possible rotation of nums array`(
            nums: IntArray,
            target: Int,
            expected: Int
        ) {
            SearchInRotatedSortedArrayByChoosingSortedPart().test(nums, target, expected)
        }
    }

    @Nested
    inner class SearchInRotatedSortedArrayByFindingIndexOfPivotTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the index of target after the possible rotation of nums array`(
            nums: IntArray,
            target: Int,
            expected: Int
        ) {
            SearchInRotatedSortedArrayByFindingIndexOfPivot().test(nums, target, expected)
        }
    }

    private fun SearchInRotatedSortedArray.test(nums: IntArray, target: Int, expected: Int) {
        val actual = search(nums, target)
        assertEquals(expected, actual)
    }
}