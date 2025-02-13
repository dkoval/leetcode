package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumOperationsToExceedThresholdValue2.MinimumOperationsToExceedThresholdValue2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class MinimumOperationsToExceedThresholdValue2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 11, 10, 1, 3),
                10,
                2
            ),
            Arguments.of(
                intArrayOf(1, 1, 2, 4, 9),
                20,
                4
            ),
            Arguments.of(
                intArrayOf(19, 44, 61, 96, 84, 79, 84, 61, 97, 44),
                44,
                1
            ),
            Arguments.of(
                intArrayOf(1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999),
                1000000000,
                2
            )
        )
    }

    @Nested
    inner class MinimumOperationsToExceedThresholdValue2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of operations needed so that all elements of the array are greater than or equal to k`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            MinimumOperationsToExceedThresholdValue2Rev1().test(nums, k, expected)
        }
    }
}

private fun MinimumOperationsToExceedThresholdValue2.test(nums: IntArray, k: Int, expected: Int) {
    val actual = minOperations(nums, k)
    assertEquals(expected, actual)
}
