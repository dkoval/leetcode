package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NonDecreasingArray.NonDecreasingArrayRev1
import com.github.dkoval.leetcode.challenge.NonDecreasingArray.NonDecreasingArrayRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NonDecreasingArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 2, 3),
                true
            ),
            Arguments.of(
                intArrayOf(4, 2, 1),
                false
            ),
            Arguments.of(
                intArrayOf(-1, 4, 2, 3),
                true
            ),
            Arguments.of(
                intArrayOf(3, 4, 2, 3),
                false
            ),
            Arguments.of(
                intArrayOf(5, 7, 1, 8),
                true
            ),
            Arguments.of(
                intArrayOf(1, 4, 1, 2),
                true
            )
        )
    }

    @Nested
    inner class NonDecreasingArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if nums array could become non-decreasing by modifying at most one element`(
            nums: IntArray,
            expected: Boolean
        ) {
            NonDecreasingArrayRev2().test(nums, expected)
        }
    }

    @Nested
    inner class NonDecreasingArrayRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if nums array could become non-decreasing by modifying at most one element`(
            nums: IntArray,
            expected: Boolean
        ) {
            NonDecreasingArrayRev1().test(nums, expected)
        }
    }


    private fun NonDecreasingArray.test(nums: IntArray, expected: Boolean) {
        val actual = checkPossibility(nums)
        assertEquals(expected, actual)
    }
}