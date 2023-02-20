package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SearchInsertPosition.SearchInsertPositionRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SearchInsertPositionTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(intArrayOf(1, 3, 5, 6), 5, 2),
            Arguments.of(intArrayOf(1, 3, 5, 6), 2, 1),
            Arguments.of(intArrayOf(1, 3, 5, 6), 7, 4),
            Arguments.of(intArrayOf(1, 3, 5, 6), 0, 0),
            Arguments.of(intArrayOf(1), 0, 0),
            Arguments.of(intArrayOf(1, 3, 5), 3, 1)
        )
    }

    @Nested
    inner class SearchInsertPositionRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return insert position`(nums: IntArray, target: Int, expected: Int) {
            SearchInsertPositionRev1().test(nums, target, expected)
        }
    }

    @Nested
    inner class SearchInsertPositionRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return insert position`(nums: IntArray, target: Int, expected: Int) {
            SearchInsertPositionRev2.test(nums, target, expected)
        }
    }
}

private fun SearchInsertPosition.test(nums: IntArray, target: Int, expected: Int) {
    val actual = searchInsert(nums, target)
    assertEquals(expected, actual)
}
