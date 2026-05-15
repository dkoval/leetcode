package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindMinimumInRotatedSortedArray.FindMinimumInRotatedSortedArrayRev1
import com.github.dkoval.leetcode.challenge.FindMinimumInRotatedSortedArray.FindMinimumInRotatedSortedArrayRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class FindMinimumInRotatedSortedArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 4, 5, 1, 2),
                1
            ),
            Arguments.of(
                intArrayOf(4, 5, 6, 7, 0, 1, 2),
                0
            ),
            Arguments.of(
                intArrayOf(11, 13, 15, 17),
                11
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                1
            ),
            Arguments.of(
                intArrayOf(2, 3, 4, 5, 1),
                1
            ),
            Arguments.of(
                intArrayOf(4, 5, 1, 2, 3),
                1
            )
        )
    }

    @Nested
    inner class FindMinimumInRotatedSortedArrayKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the minimum element in rotated sorted array with no duplicates allowed`(
            nums: IntArray,
            expected: Int
        ) {
            FindMinimumInRotatedSortedArrayKt.test(nums, expected)
        }
    }

    @Nested
    inner class FindMinimumInRotatedSortedArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the minimum element in rotated sorted array with no duplicates allowed`(
            nums: IntArray,
            expected: Int
        ) {
            FindMinimumInRotatedSortedArrayRev1().test(nums, expected)
        }
    }

    @Nested
    inner class FindMinimumInRotatedSortedArrayRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the minimum element in rotated sorted array with no duplicates allowed`(
            nums: IntArray,
            expected: Int
        ) {
            FindMinimumInRotatedSortedArrayRev2().test(nums, expected)
        }
    }
}

private fun FindMinimumInRotatedSortedArray.test(nums: IntArray, expected: Int) {
    val actual = findMin(nums)
    assertEquals(expected, actual)
}
