package com.github.dkoval.leetcode.interview.array

import com.github.dkoval.leetcode.problems.RemoveDuplicatesFromSortedArray
import com.github.dkoval.leetcode.problems.RemoveDuplicatesFromSortedArray.RemoveDuplicatesFromSortedArrayRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RemoveDuplicatesFromSortedArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(intArrayOf(1, 1, 2), intArrayOf(1, 2), 2),
            Arguments.of(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4), intArrayOf(0, 1, 2, 3, 4), 5)
        )
    }

    @Nested
    inner class RemoveDuplicatesFromSortedArrayKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should remove duplicated from a sorted array and return the new length`(
            nums: IntArray,
            expectedNums: IntArray,
            expectedLength: Int
        ) {
            RemoveDuplicatesFromSortedArrayKt.test(nums, expectedNums, expectedLength)
        }
    }

    @Nested
    inner class RemoveDuplicatesFromSortedArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should remove duplicated from a sorted array and return the new length`(
            nums: IntArray,
            expectedNums: IntArray,
            expectedLength: Int
        ) {
            RemoveDuplicatesFromSortedArrayRev1().test(nums, expectedNums, expectedLength)
        }
    }

    private fun RemoveDuplicatesFromSortedArray.test(nums: IntArray, expectedNums: IntArray, expectedLength: Int) {
        val actualLength = removeDuplicates(nums)
        assertEquals(expectedLength, actualLength)

        val actualNums = nums.take(expectedLength).toIntArray()
        assertArrayEquals(expectedNums, actualNums)
    }
}