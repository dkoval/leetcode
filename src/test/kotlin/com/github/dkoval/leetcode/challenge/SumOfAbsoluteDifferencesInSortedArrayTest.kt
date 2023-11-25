package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SumOfAbsoluteDifferencesInSortedArray.SumOfAbsoluteDifferencesInSortedArrayRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SumOfAbsoluteDifferencesInSortedArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 3, 5),
                intArrayOf(4, 3, 5)
            ),
            Arguments.of(
                intArrayOf(1, 4, 6, 8, 10),
                intArrayOf(24, 15, 13, 15, 21)
            )
        )
    }

    @Nested
    inner class SumOfAbsoluteDifferencesInSortedArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return result_i is equal to the summation of absolute differences between nums_i and all the other elements in the array`(
            nums: IntArray,
            expected: IntArray
        ) {
            SumOfAbsoluteDifferencesInSortedArrayRev1().test(nums, expected)
        }
    }
}

private fun SumOfAbsoluteDifferencesInSortedArray.test(nums: IntArray, expected: IntArray) {
    val actual = getSumAbsoluteDifferences(nums)
    assertArrayEquals(expected, actual)
}
