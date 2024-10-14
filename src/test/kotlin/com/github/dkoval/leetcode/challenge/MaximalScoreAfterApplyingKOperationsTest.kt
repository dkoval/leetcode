package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximalScoreAfterApplyingKOperations.MaximalScoreAfterApplyingKOperationsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximalScoreAfterApplyingKOperationsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(10, 10, 10, 10, 10),
                5,
                50L
            ),
            Arguments.of(
                intArrayOf(1, 10, 3, 3, 3),
                3,
                17L
            ),
            Arguments.of(
                intArrayOf(672579538, 806947365, 854095676, 815137524),
                3,
                2476180565L
            )
        )
    }

    @Nested
    inner class MaximalScoreAfterApplyingKOperationsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum possible score you can attain after applying exactly k operations`(
            nums: IntArray,
            k: Int,
            expected: Long
        ) {
            MaximalScoreAfterApplyingKOperationsRev1().test(nums, k, expected)
        }
    }
}

private fun MaximalScoreAfterApplyingKOperations.test(nums: IntArray, k: Int, expected: Long) {
    val actual = maxKelements(nums, k)
    assertEquals(expected, actual)
}
