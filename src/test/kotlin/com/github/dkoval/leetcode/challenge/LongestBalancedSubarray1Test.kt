package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestBalancedSubarray1.LongestBalancedSubarray1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class LongestBalancedSubarray1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                intArrayOf(2, 5, 4, 3),
                4
            ),
            arguments(
                intArrayOf(3, 2, 2, 5, 4),
                5
            ),
            arguments(
                intArrayOf(1, 2, 3, 2),
                3
            )
        )
    }

    @Nested
    inner class LongestBalancedSubarray1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest balanced subarray`(
            nums: IntArray,
            expected: Int
        ) {
            LongestBalancedSubarray1Rev1().test(nums, expected)
        }
    }
}

private fun LongestBalancedSubarray1.test(nums: IntArray, expected: Int) {
    val actual = longestBalanced(nums)
    assertEquals(expected, actual)
}
