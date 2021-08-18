package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DecodeWays.DecodeWaysDPBottomUp
import com.github.dkoval.leetcode.challenge.DecodeWays.DecodeWaysTopDownWithMemoization
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DecodeWaysTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "11106",
                2
            ),
            Arguments.of(
                "12",
                2
            ),
            Arguments.of(
                "226",
                3
            ),
            Arguments.of(
                "0",
                0
            ),
            Arguments.of(
                "06",
                0
            ),
            Arguments.of(
                "60",
                0
            ),
            Arguments.of(
                "1111111111111111111112",
                28657
            )
        )
    }

    @Nested
    inner class DecodeWaysTopDownWithMemoizationTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of ways to decode string s`(s: String, expected: Int) {
            DecodeWaysTopDownWithMemoization().test(s, expected)
        }
    }

    @Nested
    inner class DecodeWaysDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of ways to decode string s`(s: String, expected: Int) {
            DecodeWaysDPBottomUp().test(s, expected)
        }
    }

    private fun DecodeWays.test(s: String, expected: Int) {
        val actual = numDecodings(s)
        assertEquals(expected, actual)
    }
}