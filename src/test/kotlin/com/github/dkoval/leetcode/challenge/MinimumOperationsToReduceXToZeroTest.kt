package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumOperationsToReduceXToZero.MinimumOperationsToReduceXToZeroRev1
import com.github.dkoval.leetcode.challenge.MinimumOperationsToReduceXToZero.MinimumOperationsToReduceXToZeroRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumOperationsToReduceXToZeroTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 1, 4, 2, 3),
                5,
                2
            ),
            Arguments.of(
                intArrayOf(5, 6, 7, 8, 9),
                4,
                -1
            ),
            Arguments.of(
                intArrayOf(3, 2, 20, 1, 1, 3),
                10,
                5
            ),
            Arguments.of(
                intArrayOf(1, 1),
                3,
                -1
            )
        )
    }

    @Nested
    inner class MinimumOperationsToReduceXToZeroRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the minimum number of operations to reduce x to exactly 0`(nums: IntArray, x: Int, expected: Int) {
            MinimumOperationsToReduceXToZeroRev1().test(nums, x, expected)
        }
    }

    @Nested
    inner class MinimumOperationsToReduceXToZeroRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the minimum number of operations to reduce x to exactly 0`(nums: IntArray, x: Int, expected: Int) {
            MinimumOperationsToReduceXToZeroRev2().test(nums, x, expected)
        }
    }

    private fun MinimumOperationsToReduceXToZero.test(nums: IntArray, x: Int, expected: Int) {
        val actual = minOperations(nums, x)
        assertEquals(expected, actual)
    }
}