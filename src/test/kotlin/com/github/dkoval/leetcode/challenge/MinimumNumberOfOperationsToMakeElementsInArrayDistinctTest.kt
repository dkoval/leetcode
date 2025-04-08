package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumNumberOfOperationsToMakeElementsInArrayDistinct.MinimumNumberOfOperationsToMakeElementsInArrayDistinctRev1
import com.github.dkoval.leetcode.challenge.MinimumNumberOfOperationsToMakeElementsInArrayDistinct.MinimumNumberOfOperationsToMakeElementsInArrayDistinctRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumNumberOfOperationsToMakeElementsInArrayDistinctTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 2, 3, 3, 5, 7),
                2
            ),
            Arguments.of(
                intArrayOf(4, 5, 6, 4, 4),
                2
            ),
            Arguments.of(
                intArrayOf(6, 7, 8, 9),
                0
            ),
            Arguments.of(
                intArrayOf(5, 7, 11, 12, 12),
                2
            )
        )
    }

    @Nested
    inner class MinimumNumberOfOperationsToMakeElementsInArrayDistinctRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of operations to make all elements in the array distinct`(
            nums: IntArray,
            expected: Int
        ) {
            MinimumNumberOfOperationsToMakeElementsInArrayDistinctRev1().test(nums, expected)
        }
    }

    @Nested
    inner class MinimumNumberOfOperationsToMakeElementsInArrayDistinctRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of operations to make all elements in the array distinct`(
            nums: IntArray,
            expected: Int
        ) {
            MinimumNumberOfOperationsToMakeElementsInArrayDistinctRev2().test(nums, expected)
        }
    }
}

private fun MinimumNumberOfOperationsToMakeElementsInArrayDistinct.test(nums: IntArray, expected: Int) {
    val actual = minimumOperations(nums)
    assertEquals(expected, actual)
}
