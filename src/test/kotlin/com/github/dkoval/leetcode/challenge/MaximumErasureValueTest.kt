package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumErasureValue.MaximumErasureValueRev1
import com.github.dkoval.leetcode.challenge.MaximumErasureValue.MaximumErasureValueRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumErasureValueTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 2, 4, 5, 6),
                17
            ),
            Arguments.of(
                intArrayOf(5, 2, 1, 2, 5, 2, 1, 2, 5),
                8
            )
        )
    }

    @Nested
    inner class MaximumErasureValueRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum score you can get by erasing exactly one subarray`(nums: IntArray, expected: Int) {
            MaximumErasureValueRev1().test(nums, expected)
        }
    }

    @Nested
    inner class MaximumErasureValueRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum score you can get by erasing exactly one subarray`(nums: IntArray, expected: Int) {
            MaximumErasureValueRev2().test(nums, expected)
        }
    }

    private fun MaximumErasureValue.test(nums: IntArray, expected: Int) {
        val actual = maximumUniqueSubarray(nums)
        assertEquals(expected, actual)
    }
}