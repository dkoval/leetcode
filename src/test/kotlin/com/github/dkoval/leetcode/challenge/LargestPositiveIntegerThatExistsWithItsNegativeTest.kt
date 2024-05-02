package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LargestPositiveIntegerThatExistsWithItsNegative.LargestPositiveIntegerThatExistsWithItsNegativeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LargestPositiveIntegerThatExistsWithItsNegativeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(-1, 2, -3, 3),
                3
            ),
            Arguments.of(
                intArrayOf(-1, 10, 6, 7, -7, 1),
                7
            ),
            Arguments.of(
                intArrayOf(-10, 8, 6, 7, -2, -3),
                -1
            )
        )
    }

    @Nested
    inner class LargestPositiveIntegerThatExistsWithItsNegativeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the largest positive integer k such that -k also exists in the array`(
            nums: IntArray,
            expected: Int
        ) {
            LargestPositiveIntegerThatExistsWithItsNegativeRev1().test(nums, expected)
        }
    }
}

private fun LargestPositiveIntegerThatExistsWithItsNegative.test(nums: IntArray, expected: Int) {
    val actual = findMaxK(nums)
    assertEquals(expected, actual)
}
