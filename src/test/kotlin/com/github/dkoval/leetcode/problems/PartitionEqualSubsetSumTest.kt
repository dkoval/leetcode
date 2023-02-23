package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.PartitionEqualSubsetSum.PartitionEqualSubsetSumRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PartitionEqualSubsetSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 5, 11, 5),
                // The array can be partitioned as [1, 5, 5] and [11]
                true
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 5),
                // The array cannot be partitioned into equal sum subsets
                false
            )
        )
    }

    @Nested
    inner class PartitionEqualSubsetSumDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal`(
            nums: IntArray, expected: Boolean
        ) {
            PartitionEqualSubsetSumRev2().test(nums, expected)
        }
    }

    @Nested
    inner class PartitionEqualSubsetSumRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal`(
            nums: IntArray, expected: Boolean
        ) {
            PartitionEqualSubsetSumDPTopDown.test(nums, expected)
        }
    }
}

private fun PartitionEqualSubsetSum.test(nums: IntArray, expected: Boolean) {
    val actual = canPartition(nums)
    assertEquals(expected, actual)
}
