package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PartitionArraySuchThatMaximumDifferenceIsK.PartitionArraySuchThatMaximumDifferenceIsKRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PartitionArraySuchThatMaximumDifferenceIsKTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 6, 1, 2, 5),
                2,
                2
            ),
            Arguments.of(
                intArrayOf(1, 2, 3),
                1,
                2
            ),
            Arguments.of(
                intArrayOf(2, 2, 4, 5),
                0,
                3
            ),
        )
    }

    @Nested
    inner class PartitionArraySuchThatMaximumDifferenceIsKRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of subsequences needed such that the difference between the maximum and minimum values in each subsequence is at most k`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            PartitionArraySuchThatMaximumDifferenceIsKRev1().test(nums, k, expected)
        }
    }
}

private fun PartitionArraySuchThatMaximumDifferenceIsK.test(nums: IntArray, k: Int, expected: Int) {
    val actual = partitionArray(nums, k)
    assertEquals(expected, actual)
}
