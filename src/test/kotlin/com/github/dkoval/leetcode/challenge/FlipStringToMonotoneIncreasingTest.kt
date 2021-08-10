package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FlipStringToMonotoneIncreasing.FlipStringToMonotoneIncreasingInConstantSpace
import com.github.dkoval.leetcode.challenge.FlipStringToMonotoneIncreasing.FlipStringToMonotoneIncreasingUsingPrefixSum
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FlipStringToMonotoneIncreasingTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of("00110", 1),
            Arguments.of("010110", 2),
            Arguments.of("010101011100011111", 6),
            Arguments.of("00011000", 2)
        )
    }

    @Nested
    inner class FlipStringToMonotoneIncreasingUsingPrefixSumTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of flips to make s monotone increasing`(s: String, expected: Int) {
            FlipStringToMonotoneIncreasingUsingPrefixSum().test(s, expected)
        }
    }

    @Nested
    inner class FlipStringToMonotoneIncreasingInConstantSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of flips to make s monotone increasing`(s: String, expected: Int) {
            FlipStringToMonotoneIncreasingInConstantSpace().test(s, expected)
        }
    }

    private fun FlipStringToMonotoneIncreasing.test(s: String, expected: Int) {
        val actual = minFlipsMonoIncr(s)
        assertEquals(expected, actual)
    }
}