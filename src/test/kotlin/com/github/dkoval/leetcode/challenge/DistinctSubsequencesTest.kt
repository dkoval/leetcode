package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DistinctSubsequences.DistinctSubsequencesBottomUp
import com.github.dkoval.leetcode.challenge.DistinctSubsequences.DistinctSubsequencesTopDownWithMemoization
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DistinctSubsequencesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "rabbbit",
                "rabbit",
                3
            ),
            Arguments.of(
                "babgbag",
                "bag",
                5
            )
        )
    }

    @Nested
    inner class DistinctSubsequencesBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of distinct subsequences of s which equals t`(
            s: String,
            t: String,
            expected: Int
        ) {
            DistinctSubsequencesBottomUp().test(s, t, expected)
        }
    }

    @Nested
    inner class DistinctSubsequencesTopDownWithMemoizationTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of distinct subsequences of s which equals t`(
            s: String,
            t: String,
            expected: Int
        ) {
            DistinctSubsequencesTopDownWithMemoization().test(s, t, expected)
        }
    }

    private fun DistinctSubsequences.test(s: String, t: String, expected: Int) {
        val actual = numDistinct(s, t)
        assertEquals(expected, actual)
    }
}