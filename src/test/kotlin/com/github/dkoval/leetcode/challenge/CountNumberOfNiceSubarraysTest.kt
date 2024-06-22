package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountNumberOfNiceSubarrays.CountNumberOfNiceSubarraysRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountNumberOfNiceSubarraysTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 1, 2, 1, 1),
                3,
                2
            ),
            Arguments.of(
                intArrayOf(2, 4, 6),
                1,
                0
            ),
            Arguments.of(
                intArrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2),
                2,
                16
            )
        )
    }

    @Nested
    inner class CountNumberOfNiceSubarraysRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of nice sub-arrays`(nums: IntArray, k: Int, expected: Int) {
            CountNumberOfNiceSubarraysRev1().test(nums, k, expected)
        }
    }
}

private fun CountNumberOfNiceSubarrays.test(nums: IntArray, k: Int, expected: Int) {
    val actual = numberOfSubarrays(nums, k)
    assertEquals(expected, actual)
}
