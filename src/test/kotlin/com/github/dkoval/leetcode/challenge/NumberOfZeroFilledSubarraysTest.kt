package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfZeroFilledSubarrays.NumberOfZeroFilledSubarraysRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfZeroFilledSubarraysTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 0, 0, 2, 0, 0, 4),
                6L
            ),
            Arguments.of(
                intArrayOf(0, 0, 0, 2, 0, 0),
                9L
            ),
            Arguments.of(
                intArrayOf(2, 10, 2019),
                0L
            )
        )
    }

    @Nested
    inner class NumberOfZeroFilledSubarraysRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of subarrays filled with 0`(nums: IntArray, expected: Long) {
            NumberOfZeroFilledSubarraysRev1().test(nums, expected)
        }
    }
}

private fun NumberOfZeroFilledSubarrays.test(nums: IntArray, expected: Long) {
    val actual = zeroFilledSubarray(nums)
    assertEquals(expected, actual)
}
