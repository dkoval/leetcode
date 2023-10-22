package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ConstrainedSubsequenceSum.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ConstrainedSubsequenceSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(10, 2, -10, 5, 20),
                2,
                37
            ),
            Arguments.of(
                intArrayOf(-1, -2, -3),
                1,
                -1
            ),
            Arguments.of(
                intArrayOf(10, -2, -10, -5, 20),
                2,
                23
            )
        )
    }

    @Nested
    inner class ConstrainedSubsequenceSumRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum sum of a non-empty constrained subsequence`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            ConstrainedSubsequenceSumRev1().test(nums, k, expected)
        }
    }

    @Nested
    inner class ConstrainedSubsequenceSumRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum sum of a non-empty constrained subsequence`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            ConstrainedSubsequenceSumRev2().test(nums, k, expected)
        }
    }

    @Nested
    inner class ConstrainedSubsequenceSumRev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum sum of a non-empty constrained subsequence`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            ConstrainedSubsequenceSumRev3().test(nums, k, expected)
        }
    }
}

private fun ConstrainedSubsequenceSum.test(nums: IntArray, k: Int, expected: Int) {
    val actual = constrainedSubsetSum(nums, k)
    assertEquals(expected, actual)
}
