package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SetMismatch.SetMismatchNaive
import com.github.dkoval.leetcode.challenge.SetMismatch.SetMismatchOptimal
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SetMismatchTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 2, 4),
                intArrayOf(2, 3)
            ),
            Arguments.of(
                intArrayOf(1, 1),
                intArrayOf(1, 2)
            ),
            Arguments.of(
                intArrayOf(3, 2, 2),
                intArrayOf(2, 1)
            )
        )
    }

    @Nested
    inner class SetMismatchNaiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the number that occurs twice and the number that is missing`(nums: IntArray, expected: IntArray) {
            SetMismatchNaive().test(nums, expected)
        }
    }

    @Nested
    inner class SetMismatchOptimalTest {
        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the number that occurs twice and the number that is missing`(nums: IntArray, expected: IntArray) {
            SetMismatchOptimal().test(nums, expected)
        }
    }

    private fun SetMismatch.test(nums: IntArray, expected: IntArray) {
        val actual = findErrorNums(nums)
        assertArrayEquals(expected, actual)
    }
}