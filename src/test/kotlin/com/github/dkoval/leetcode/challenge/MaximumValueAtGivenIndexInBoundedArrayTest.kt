package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumValueAtGivenIndexInBoundedArray.MaximumValueAtGivenIndexInBoundedArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumValueAtGivenIndexInBoundedArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(4, 2, 6, 2),
            Arguments.of(6, 1, 10, 3),
            Arguments.of(3, 0, 815094800, 271698267)
        )
    }

    @Nested
    inner class MaximumValueAtGivenIndexInBoundedArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return nums(index) of the constructed array`(n: Int, index: Int, maxSum: Int, expected: Int) {
            MaximumValueAtGivenIndexInBoundedArrayRev1().test(n, index, maxSum, expected)
        }
    }
}

private fun MaximumValueAtGivenIndexInBoundedArray.test(n: Int, index: Int, maxSum: Int, expected: Int) {
    val actual = maxValue(n, index, maxSum)
    assertEquals(expected, actual)
}
