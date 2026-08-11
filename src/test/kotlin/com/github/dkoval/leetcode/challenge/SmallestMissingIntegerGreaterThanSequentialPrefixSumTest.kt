package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SmallestMissingIntegerGreaterThanSequentialPrefixSum.SmallestMissingIntegerGreaterThanSequentialPrefixSumRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class SmallestMissingIntegerGreaterThanSequentialPrefixSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 2, 5),
                6
            ),
            Arguments.of(
                intArrayOf(3, 4, 5, 1, 12, 14, 13),
                15
            ),
            Arguments.of(
                intArrayOf(14, 9, 6, 9, 7, 9, 10, 4, 9, 9, 4, 4),
                15
            )
        )
    }

    @Nested
    inner class SmallestMissingIntegerGreaterThanSequentialPrefixSumRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the smallest integer x missing from nums such that x is greater than or equal to the sum of the longest sequential prefix`(
            nums: IntArray,
            expected: Int
        ) {
            SmallestMissingIntegerGreaterThanSequentialPrefixSumRev1().test(nums, expected)
        }
    }
}

private fun SmallestMissingIntegerGreaterThanSequentialPrefixSum.test(nums: IntArray, expected: Int) {
    val actual = missingInteger(nums)
    assertEquals(expected, actual)
}
