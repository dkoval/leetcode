package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NextGreaterElement1.NextGreaterElement1Naive
import com.github.dkoval.leetcode.challenge.NextGreaterElement1.NextGreaterElement1UsingMonoStack
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NextGreaterElement1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 1, 2),
                intArrayOf(1, 3, 4, 2),
                intArrayOf(-1, 3, -1)
            ),
            Arguments.of(
                intArrayOf(2, 4),
                intArrayOf(1, 2, 3, 4),
                intArrayOf(3, -1)
            )
        )
    }

    @Nested
    inner class NextGreaterElement1NaiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return first greater element that is to the right of x in the same array`(
            nums1: IntArray,
            nums2: IntArray,
            expected: IntArray
        ) {
            NextGreaterElement1Naive().test(nums1, nums2, expected)
        }
    }

    @Nested
    inner class NextGreaterElement1UsingMonoStackTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return first greater element that is to the right of x in the same array`(
            nums1: IntArray,
            nums2: IntArray,
            expected: IntArray
        ) {
            NextGreaterElement1UsingMonoStack().test(nums1, nums2, expected)
        }
    }

    private fun NextGreaterElement1.test(nums1: IntArray, nums2: IntArray, expected: IntArray) {
        val actual = nextGreaterElement(nums1, nums2)
        assertArrayEquals(expected, actual)
    }
}