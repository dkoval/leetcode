package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumXOROfTwoNumbersInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 10, 5, 25, 2, 8),
                // The maximum result is 5 ^ 25 = 28
                28
            ),
            Arguments.of(
                intArrayOf(0),
                0
            )
        )
    }

    @Nested
    inner class MaximumXOROfTwoNumbersInArrayBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should maximum xor of two numbers in an array`(nums: IntArray, expected: Int) {
            MaximumXOROfTwoNumbersInArrayBruteForce.test(nums, expected)
        }
    }

    private fun MaximumXOROfTwoNumbersInArray.test(nums: IntArray, expected: Int) {
        val actual = findMaximumXOR(nums)
        assertEquals(expected, actual)
    }
}