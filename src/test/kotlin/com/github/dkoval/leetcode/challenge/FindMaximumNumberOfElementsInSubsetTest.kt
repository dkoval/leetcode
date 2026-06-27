package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindMaximumNumberOfElementsInSubset.FindMaximumNumberOfElementsInSubsetRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class FindMaximumNumberOfElementsInSubsetTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 4, 1, 2, 2),
                3
            ),
            Arguments.of(
                intArrayOf(1, 3, 2, 4),
                1
            )
        )
    }

    @Nested
    inner class FindMaximumNumberOfElementsInSubsetRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of elements in a subset`(
            nums: IntArray,
            expected: Int
        ) {
            FindMaximumNumberOfElementsInSubsetRev1().test(nums, expected)
        }
    }
}

private fun FindMaximumNumberOfElementsInSubset.test(nums: IntArray, expected: Int) {
    val actual = maximumLength(nums)
    assertEquals(expected, actual)
}
