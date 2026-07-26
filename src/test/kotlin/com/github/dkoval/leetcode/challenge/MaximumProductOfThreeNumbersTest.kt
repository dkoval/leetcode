package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumProductOfThreeNumbers.MaximumProductOfThreeNumbersRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MaximumProductOfThreeNumbersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3),
                6
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                24
            ),
            Arguments.of(
                intArrayOf(-1, -2, -3),
                -6
            ),
            Arguments.of(
                intArrayOf(-100, -98, -1, 2, 3, 4),
                39200
            )
        )
    }

    @Nested
    inner class MaximumProductOfThreeNumbersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find three numbers whose product is maximum and return the maximum product`(
            nums: IntArray,
            expected: Int
        ) {
            MaximumProductOfThreeNumbersRev1().test(nums, expected)

        }
    }
}

private fun MaximumProductOfThreeNumbers.test(nums: IntArray, expected: Int) {
    val actual = maximumProduct(nums)
    assertEquals(expected, actual)
}
