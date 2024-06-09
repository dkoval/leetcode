package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.challenge.SubarraySumsDivisibleByK
import com.github.dkoval.leetcode.challenge.SubarraySumsDivisibleByK.SubarraySumsDivisibleByKRev2
import com.github.dkoval.leetcode.challenge.SubarraySumsDivisibleByK.SubarraySumsDivisibleByKRev3
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SubarraySumsDivisibleByKTest {

    internal class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            // There are 7 subarrays with a sum divisible by K = 5:
            // [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
            Arguments.of(
                intArrayOf(4, 5, 0, -2, -3, 1),
                5,
                7
            ),
            Arguments.of(
                intArrayOf(5),
                9,
                0
            )
        )
    }

    @Nested
    inner class SubarraySumsDivisibleByKRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of (contiguous, non-empty) subarrays that have a sum divisible by K`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            SubarraySumsDivisibleByKRev1.test(nums, k, expected)
        }
    }

    @Nested
    inner class SubarraySumsDivisibleByKRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of (contiguous, non-empty) subarrays that have a sum divisible by K`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            SubarraySumsDivisibleByKRev2().test(nums, k, expected)
        }
    }

    @Nested
    inner class SubarraySumsDivisibleByKRev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of (contiguous, non-empty) subarrays that have a sum divisible by K`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            SubarraySumsDivisibleByKRev3().test(nums, k, expected)
        }
    }
}

private fun SubarraySumsDivisibleByK.test(nums: IntArray, k: Int, expected: Int) {
    val actual = subarraysDivByK(nums, k)
    assertEquals(expected, actual)
}
