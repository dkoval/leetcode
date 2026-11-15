package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfSubarraysWithOddSum.NumberOfSubarraysWithOddSumRev1
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

internal class NumberOfSubarraysWithOddSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                intArrayOf(1, 3, 5),
                4
            ),
            arguments(
                intArrayOf(2, 4, 6),
                0
            ),
            arguments(
                intArrayOf(1, 2, 3, 4, 5, 6, 7),
                16
            )
        )
    }

    @Nested
    inner class NumberOfSubarraysWithOddSumRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of subarrays with an odd sum`(arr: IntArray, expected: Int) {
            NumberOfSubarraysWithOddSumRev1().test(arr, expected)
        }
    }
}

private fun NumberOfSubarraysWithOddSumRev1.test(arr: IntArray, expected: Int) {
    val actual = numOfSubarrays(arr)
    assertThat(actual).isEqualTo(expected)
}
