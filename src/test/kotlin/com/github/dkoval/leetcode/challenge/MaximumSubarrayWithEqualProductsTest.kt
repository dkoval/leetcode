package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumSubarrayWithEqualProducts.MaximumSubarrayWithEqualProductsRev1
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

internal class MaximumSubarrayWithEqualProductsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                intArrayOf(1, 2, 1, 2, 1, 1, 1),
                5
            ),
            arguments(
                intArrayOf(2, 3, 4, 5, 6),
                3
            ),
            arguments(
                intArrayOf(1, 2, 3, 1, 4, 5, 1),
                5
            )
        )
    }

    @Nested
    inner class MaximumSubarrayWithEqualProductsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest product equivalent subarray of nums`(
            nums: IntArray,
            expected: Int
        ) {
            MaximumSubarrayWithEqualProductsRev1().test(nums, expected)
        }
    }
}

private fun MaximumSubarrayWithEqualProductsRev1.test(nums: IntArray, expected: Int) {
    val actual = maxLength(nums)
    assertThat(actual).isEqualTo(expected)
}
