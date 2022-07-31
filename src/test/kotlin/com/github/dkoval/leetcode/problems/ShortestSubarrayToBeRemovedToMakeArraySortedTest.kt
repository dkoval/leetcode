package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.ShortestSubarrayToBeRemovedToMakeArraySorted.ShortestSubarrayToBeRemovedToMakeArraySortedRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ShortestSubarrayToBeRemovedToMakeArraySortedTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 10, 4, 2, 3, 5),
                3
            ),
            Arguments.of(
                intArrayOf(5, 4, 3, 2, 1),
                4
            ),
            Arguments.of(
                intArrayOf(1, 2, 3),
                0
            )
        )
    }

    @Nested
    inner class ShortestSubarrayToBeRemovedToMakeArraySortedRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the length of the shortest subarray to remove`(arr: IntArray, expected: Int) {
            ShortestSubarrayToBeRemovedToMakeArraySortedRev1().test(arr, expected)
        }
    }

    private fun ShortestSubarrayToBeRemovedToMakeArraySorted.test(arr: IntArray, expected: Int) {
        val actual = findLengthOfShortestSubarray(arr)
        assertEquals(expected, actual)
    }
}