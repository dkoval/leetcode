package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountPartitionsWithEvenSumDifference.CountPartitionsWithEvenSumDifferenceRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountPartitionsWithEvenSumDifferenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(10, 10, 3, 7, 6),
                4
            ),
            Arguments.of(
                intArrayOf(1, 2, 2),
                0
            ),
            Arguments.of(
                intArrayOf(2, 4, 6, 8),
                3
            )
        )
    }

    @Nested
    inner class CountPartitionsWithEvenSumDifferenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of partitions where the difference between the sum of the left and right subarrays is even`(
            nums: IntArray,
            expected: Int
        ) {
            CountPartitionsWithEvenSumDifferenceRev1().test(nums, expected)
        }
    }
}

private fun CountPartitionsWithEvenSumDifference.test(nums: IntArray, expected: Int) {
    val actual = countPartitions(nums)
    assertEquals(expected, actual)
}
