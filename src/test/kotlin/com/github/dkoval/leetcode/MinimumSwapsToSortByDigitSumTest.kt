package com.github.dkoval.leetcode

import com.github.dkoval.leetcode.challenge.MinimumSwapsToSortByDigitSum
import com.github.dkoval.leetcode.challenge.MinimumSwapsToSortByDigitSum.MinimumSwapsToSortByDigitSumRev1
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

internal class MinimumSwapsToSortByDigitSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                intArrayOf(37, 100),
                1
            ),
            arguments(
                intArrayOf(22, 14, 33, 71),
                0
            ),
            arguments(
                intArrayOf(18, 43, 34, 16),
                2
            ),
            arguments(
                intArrayOf(268835996, 65052660, 415128775),
                2
            )
        )
    }

    @Nested
    inner class MinimumSwapsToSortByDigitSumRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of swaps required to rearrange nums into this sorted order`(
            nums: IntArray,
            expected: Int
        ) {
            MinimumSwapsToSortByDigitSumRev1().test(nums, expected)
        }
    }
}

private fun MinimumSwapsToSortByDigitSum.test(nums: IntArray, expected: Int) {
    val actual = minSwaps(nums)
    assertThat(actual).isEqualTo(expected)
}
