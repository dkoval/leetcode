package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindFirstAndLastPositionOfElementInSortedArray.FindFirstAndLastPositionOfElementInSortedArrayRev1
import com.github.dkoval.leetcode.challenge.FindFirstAndLastPositionOfElementInSortedArray.FindFirstAndLastPositionOfElementInSortedArrayRev2
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class FindFirstAndLastPositionOfElementInSortedArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 7, 7, 8, 8, 10),
                8,
                intArrayOf(3, 4)
            ),
            Arguments.of(
                intArrayOf(5, 7, 7, 8, 8, 10),
                6,
                intArrayOf(-1, -1)
            ),
            Arguments.of(
                intArrayOf(),
                0,
                intArrayOf(-1, -1)
            )
        )
    }

    @Nested
    inner class FindFirstAndLastPositionOfElementInSortedArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find first and last position of element in sorted array`(
            nums: IntArray,
            target: Int,
            expected: IntArray
        ) {
            FindFirstAndLastPositionOfElementInSortedArrayRev1().test(nums, target, expected)
        }
    }

    @Nested
    inner class FindFirstAndLastPositionOfElementInSortedArrayRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find first and last position of element in sorted array`(
            nums: IntArray,
            target: Int,
            expected: IntArray
        ) {
            FindFirstAndLastPositionOfElementInSortedArrayRev2().test(nums, target, expected)
        }
    }

    private fun FindFirstAndLastPositionOfElementInSortedArray.test(nums: IntArray, target: Int, expected: IntArray) {
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }
}