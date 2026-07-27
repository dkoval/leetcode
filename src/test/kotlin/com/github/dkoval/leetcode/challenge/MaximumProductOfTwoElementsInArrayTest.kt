package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumProductOfTwoElementsInArray.MaximumProductOfTwoElementsInArrayRev1
import com.github.dkoval.leetcode.challenge.MaximumProductOfTwoElementsInArray.MaximumProductOfTwoElementsInArrayRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MaximumProductOfTwoElementsInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 4, 5, 2),
                12
            ),
            Arguments.of(
                intArrayOf(1, 5, 4, 5),
                16
            ),
            Arguments.of(
                intArrayOf(3, 7),
                12
            )
        )
    }

    @Nested
    inner class MaximumProductOfTwoElementsInArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return maximum productOf two elements of input`(nums: IntArray, expected: Int) {
            MaximumProductOfTwoElementsInArrayRev1().test(nums, expected)
        }
    }

    @Nested
    inner class MaximumProductOfTwoElementsInArrayRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return maximum productOf two elements of input`(nums: IntArray, expected: Int) {
            MaximumProductOfTwoElementsInArrayRev2().test(nums, expected)
        }
    }
}

private fun MaximumProductOfTwoElementsInArray.test(nums: IntArray, expected: Int) {
    val actual = maxProduct(nums)
    assertEquals(expected, actual)
}
