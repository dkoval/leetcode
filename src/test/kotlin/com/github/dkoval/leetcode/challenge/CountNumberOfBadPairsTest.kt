package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountNumberOfBadPairs.CountNumberOfBadPairsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountNumberOfBadPairsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 1, 3, 3),
                5L
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                0
            )
        )
    }

    @Nested
    inner class CountNumberOfBadPairsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of bad pairs in the array`(nums: IntArray, expected: Long) {
            CountNumberOfBadPairsRev1().test(nums, expected)
        }
    }
}

private fun CountNumberOfBadPairs.test(nums: IntArray, expected: Long) {
    val actual = countBadPairs(nums)
    assertEquals(expected, actual)
}
