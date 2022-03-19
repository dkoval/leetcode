package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.RemoveDuplicatesFromSortedArray2.RemoveDuplicatesFromSortedArray2ByOverwritingUnwantedDuplicates
import com.github.dkoval.leetcode.problems.RemoveDuplicatesFromSortedArray2.RemoveDuplicatesFromSortedArray2ByPoppingUnwantedDuplicates
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RemoveDuplicatesFromSortedArray2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 1, 1, 2, 2, 3),
                intArrayOf(1, 1, 2, 2, 3)
            ),
            Arguments.of(
                intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3),
                intArrayOf(0, 0, 1, 1, 2, 3, 3)
            )
        )
    }

    @Nested
    inner class RemoveDuplicatesFromSortedArray2ByPoppingUnwantedDuplicatesTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should remove the duplicates in sorted array in-place such that duplicates appeared at most twice and return the new length`(
            nums: IntArray,
            expected: IntArray
        ) {
            RemoveDuplicatesFromSortedArray2ByPoppingUnwantedDuplicates().test(nums, expected)
        }
    }

    @Nested
    inner class RemoveDuplicatesFromSortedArray2ByOverwritingUnwantedDuplicatesTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should remove the duplicates in sorted array in-place such that duplicates appeared at most twice and return the new length`(
            nums: IntArray,
            expected: IntArray
        ) {
            RemoveDuplicatesFromSortedArray2ByOverwritingUnwantedDuplicates().test(nums, expected)
        }
    }

    private fun RemoveDuplicatesFromSortedArray2.test(nums: IntArray, expected: IntArray) {
        val actualSize = removeDuplicates(nums)
        assertEquals(expected.size, actualSize)
        val actual = nums.copyOf(actualSize)
        assertArrayEquals(expected, actual)
    }
}