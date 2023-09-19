package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.problems.FindDuplicateNumberUsingFloydAlgorithm
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindDuplicateNumberTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 4, 2, 2),
                2
            ),
            Arguments.of(
                intArrayOf(3, 1, 3, 4, 2),
                3
            ),
            Arguments.of(
                intArrayOf(2, 2, 2, 2, 2),
                2
            ),
            Arguments.of(
                intArrayOf(1, 1),
                1
            )
        )
    }

    @Nested
    inner class FindDuplicateNumberByNegativeMarkingTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the duplicate number`(nums: IntArray, expected: Int) {
            FindDuplicateNumberByNegativeMarking.test(nums, expected)
        }
    }

    @Nested
    inner class FindDuplicateNumberByAddingExtraWeightTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the duplicate number`(nums: IntArray, expected: Int) {
            FindDuplicateNumberByAddingExtraWeight.test(nums, expected)
        }
    }

    @Nested
    inner class FindDuplicateNumberWithBinarySearchTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the duplicate number`(nums: IntArray, expected: Int) {
            FindDuplicateNumberWithBinarySearch.test(nums, expected)
        }
    }

    @Nested
    inner class FindDuplicateNumberUsingFloydAlgorithmTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the duplicate number`(nums: IntArray, expected: Int) {
            FindDuplicateNumberUsingFloydAlgorithm().test(nums, expected)
        }
    }
}

private fun FindDuplicateNumber.test(nums: IntArray, expected: Int) {
    val actual = findDuplicate(nums)
    assertEquals(expected, actual)
}
