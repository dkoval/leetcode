package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumPositiveSumSubarray.MinimumPositiveSumSubarrayRev1
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

internal class MinimumPositiveSumSubarrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                listOf(3, -2, 1, 4),
                2,
                3,
                1
            ),
            arguments(
                listOf(-2, 2, -3, 1),
                2,
                3,
                -1
            ),
            arguments(
                listOf(1, 2, 3, 4),
                2,
                4,
                3
            )
        )
    }

    @Nested
    inner class MinimumPositiveSumSubarrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum sum of a subarray whose size is between l and r (inclusive) and whose sum is greater than 0`(
            nums: List<Int>,
            l: Int,
            r: Int,
            expected: Int
        ) {
            MinimumPositiveSumSubarrayRev1().test(nums, l, r, expected)
        }
    }
}

private fun MinimumPositiveSumSubarray.test(
    nums: List<Int>,
    l: Int,
    r: Int,
    expected: Int
) {
    val actual = minimumSumSubarray(nums, l, r)
    assertThat(actual).isEqualTo(expected)
}
