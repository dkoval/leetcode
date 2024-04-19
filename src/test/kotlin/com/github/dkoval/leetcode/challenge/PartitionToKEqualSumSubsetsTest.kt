package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PartitionToKEqualSumSubsets.PartitionToKEqualSumSubsetsRecursiveWithBacktracking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PartitionToKEqualSumSubsetsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 3, 2, 3, 5, 2, 1),
                4,
                true
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                3,
                false
            )
        )
    }

    @Nested
    inner class PartitionToKEqualSumSubsetsRecursiveWithBacktrackingTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if it is possible to divide this array into k non-empty subsets whose sums are all equal`(
            nums: IntArray,
            k: Int,
            expected: Boolean
        ) {
            PartitionToKEqualSumSubsetsRecursiveWithBacktracking().test(nums, k, expected)
        }
    }
}

private fun PartitionToKEqualSumSubsets.test(nums: IntArray, k: Int, expected: Boolean) {
    val actual = canPartitionKSubsets(nums, k)
    assertEquals(expected, actual)
}
