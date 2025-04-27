package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountSubarraysOfLengthThreeWithCondition.CountSubarraysOfLengthThreeWithConditionRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountSubarraysOfLengthThreeWithConditionTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 1, 4, 1),
                1
            ),
            Arguments.of(
                intArrayOf(1, 1, 1),
                0
            )
        )
    }

    @Nested
    inner class CountSubarraysOfLengthThreeWithConditionRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count the number of subarrays of length three with a condition`(
            nums: IntArray,
            expected: Int
        ) {
            CountSubarraysOfLengthThreeWithConditionRev1().test(nums, expected)
        }
    }
}

private fun CountSubarraysOfLengthThreeWithCondition.test(nums: IntArray, expected: Int) {
    val actual = countSubarrays(nums)
    assertEquals(expected, actual)
}
