package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SumOfSquaresOfSpecialElements.SumOfSquaresOfSpecialElementsRev1
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

internal class SumOfSquaresOfSpecialElementsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> {
            return Stream.of(
                arguments(
                    intArrayOf(1, 2, 3, 4),
                    21
                ),
                arguments(
                    intArrayOf(2, 7, 1, 19, 18, 3),
                    63
                )
            )
        }
    }

    @Nested
    inner class SumOfSquaresOfSpecialElementsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the sum of the squares of all special elements of nums`(
            nums: IntArray,
            expected: Int
        ) {
            SumOfSquaresOfSpecialElementsRev1().test(nums, expected)
        }
    }
}

private fun SumOfSquaresOfSpecialElements.test(nums: IntArray, expected: Int) {
    val actual = sumOfSquares(nums)
    assertThat(actual).isEqualTo(expected)
}
