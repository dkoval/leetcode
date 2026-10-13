package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumAlternatingSumOfSquares.MaximumAlternatingSumOfSquaresRev1
import com.github.dkoval.leetcode.challenge.MaximumAlternatingSumOfSquares.MaximumAlternatingSumOfSquaresRev2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MaximumAlternatingSumOfSquaresTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> =
            Stream.of(
                arguments(
                    intArrayOf(1, 2, 3),
                    12
                ),
                arguments(
                    intArrayOf(1, -1, 2, -2, 3, -3),
                    16
                )
            )
    }

    @Nested
    inner class MaximumAlternatingSumOfSquaresRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum possible alternating score of nums after rearranging its elements`(
            nums: IntArray,
            expected: Long
        ) {
            MaximumAlternatingSumOfSquaresRev1().test(nums, expected)
        }
    }

    @Nested
    inner class MaximumAlternatingSumOfSquaresRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum possible alternating score of nums after rearranging its elements`(
            nums: IntArray,
            expected: Long
        ) {
            MaximumAlternatingSumOfSquaresRev2().test(nums, expected)
        }
    }
}

private fun MaximumAlternatingSumOfSquares.test(nums: IntArray, expected: Long) {
    val actual = maxAlternatingSum(nums)
    assertThat(actual).isEqualTo(expected)
}
