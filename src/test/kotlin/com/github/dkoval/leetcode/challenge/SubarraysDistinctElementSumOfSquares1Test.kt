package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SubarraysDistinctElementSumOfSquares1.*
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

internal class SubarraysDistinctElementSumOfSquares1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                listOf(1, 2, 1),
                15
            ),
            arguments(
                listOf(1, 1),
                3
            )
        )
    }

    @Nested
    inner class SubarraysDistinctElementSumOfSquares1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the sum of the squares of distinct counts of all subarrays of nums`(
            nums: List<Int>,
            expected: Int
        ) {
            SubarraysDistinctElementSumOfSquares1Rev1().test(nums, expected)
        }
    }

    @Nested
    inner class SubarraysDistinctElementSumOfSquares1Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the sum of the squares of distinct counts of all subarrays of nums`(
            nums: List<Int>,
            expected: Int
        ) {
            SubarraysDistinctElementSumOfSquares1Rev2().test(nums, expected)
        }
    }

    @Nested
    inner class SubarraysDistinctElementSumOfSquares1Rev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the sum of the squares of distinct counts of all subarrays of nums`(
            nums: List<Int>,
            expected: Int
        ) {
            SubarraysDistinctElementSumOfSquares1Rev3().test(nums, expected)
        }
    }

    @Nested
    inner class SubarraysDistinctElementSumOfSquares1Rev4Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the sum of the squares of distinct counts of all subarrays of nums`(
            nums: List<Int>,
            expected: Int
        ) {
            SubarraysDistinctElementSumOfSquares1Rev4().test(nums, expected)
        }
    }
}

private fun SubarraysDistinctElementSumOfSquares1.test(nums: List<Int>, expected: Int) {
    val actual = sumCounts(nums)
    assertThat(actual).isEqualTo(expected)
}
