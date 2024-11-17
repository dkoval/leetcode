package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ShortestSubarrayWithSumAtLeastK.ShortestSubarrayWithSumAtLeastKRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ShortestSubarrayWithSumAtLeastKTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1),
                1,
                1
            ),
            Arguments.of(
                intArrayOf(1, 2),
                4,
                -1
            ),
            Arguments.of(
                intArrayOf(2, -1, 2),
                3,
                3
            ),
            Arguments.of(
                intArrayOf(17, 85, 93, -45, -21),
                150,
                2
            )
        )
    }

    @Nested
    inner class ShortestSubarrayWithSumAtLeastKRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the shortest non-empty subarray of nums with a sum of at least k`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            ShortestSubarrayWithSumAtLeastKRev1().test(nums, k, expected)
        }
    }
}

private fun ShortestSubarrayWithSumAtLeastK.test(nums: IntArray, k: Int, expected: Int) {
    val actual = shortestSubarray(nums, k)
    assertEquals(expected, actual)
}
