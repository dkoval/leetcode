package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindXSumOfAllKLongSubarrays1.FindXSumOfAllKLongSubarrays1Rev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindXSumOfAllKLongSubarrays1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 1, 2, 2, 3, 4, 2, 3),
                6,
                2,
                intArrayOf(6, 10, 12)
            ),
            Arguments.of(
                intArrayOf(3, 8, 7, 8, 7, 5),
                2,
                2,
                intArrayOf(11, 15, 15, 15, 12)
            )
        )
    }

    @Nested
    inner class FindXSumOfAllKLongSubarrays1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of integers representing the X-sum of all subarrays of size k`(
            nums: IntArray,
            k: Int,
            x: Int,
            expected: IntArray
        ) {
            FindXSumOfAllKLongSubarrays1Rev1().test(nums, k, x, expected)
        }
    }
}

private fun FindXSumOfAllKLongSubarrays1.test(nums: IntArray, k: Int, x: Int, expected: IntArray) {
    val actual = findXSum(nums, k, x)
    assertArrayEquals(expected, actual)
}
