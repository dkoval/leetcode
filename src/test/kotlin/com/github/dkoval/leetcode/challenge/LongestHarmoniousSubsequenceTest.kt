package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestHarmoniousSubsequence.LongestHarmoniousSubsequenceRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestHarmoniousSubsequenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 2, 2, 5, 2, 3, 7),
                5
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                2
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 1),
                0
            )
        )
    }

    @Nested
    inner class LongestHarmoniousSubsequenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the longest harmonious subsequence`(nums: IntArray, expected: Int) {
            LongestHarmoniousSubsequenceRev1().test(nums, expected)
        }
    }
}

private fun LongestHarmoniousSubsequence.test(nums: IntArray, expected: Int) {
    val actual = findLHS(nums)
    assertEquals(expected, actual)
}
