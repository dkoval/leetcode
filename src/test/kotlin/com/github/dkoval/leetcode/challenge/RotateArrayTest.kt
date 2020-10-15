package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RotateArray.RotateArrayExtraSpace
import com.github.dkoval.leetcode.challenge.RotateArray.RotateArrayInPlace
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RotateArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 6, 7),
                7,
                intArrayOf(1, 2, 3, 4, 5, 6, 7),
            ),
            Arguments.of(
                intArrayOf(1),
                1000,
                intArrayOf(1)
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 6, 7),
                3,
                intArrayOf(5, 6, 7, 1, 2, 3, 4)
            )
        )
    }

    @Nested
    inner class RotateArrayInPlaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should rotate the array to the right by k steps`(nums: IntArray, k: Int, expected: IntArray) {
            RotateArrayInPlace().test(nums, k, expected)
        }
    }

    @Nested
    inner class RotateArrayExtraSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should rotate the array to the right by k steps`(nums: IntArray, k: Int, expected: IntArray) {
            RotateArrayExtraSpace().test(nums, k, expected)
        }
    }

    private fun RotateArray.test(nums: IntArray, k: Int, expected: IntArray) {
        rotate(nums, k)
        assertArrayEquals(expected, nums)
    }
}