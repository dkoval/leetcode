package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BinarySubarraysWithSum.BinarySubarraysWithSumRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BinarySubarraysWithSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 0, 1, 0, 1),
                2,
                4
            ),
            Arguments.of(
                intArrayOf(0, 0, 0, 0, 0),
                0,
                15
            )
        )
    }

    @Nested
    inner class BinarySubarraysWithSumRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of non-empty subarrays with a sum goal`(nums: IntArray, goal: Int, expected: Int) {
            BinarySubarraysWithSumRev1().test(nums, goal, expected)
        }
    }
}

private fun BinarySubarraysWithSum.test(nums: IntArray, goal: Int, expected: Int) {
    val actual = numSubarraysWithSum(nums, goal)
    assertEquals(expected, actual)
}
