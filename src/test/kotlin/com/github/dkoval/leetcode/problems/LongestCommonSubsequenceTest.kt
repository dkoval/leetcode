package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.LongestCommonSubsequence.LongestCommonSubsequenceDPBottomUp
import com.github.dkoval.leetcode.problems.LongestCommonSubsequence.LongestCommonSubsequenceDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class LongestCommonSubsequenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("abcde", "ace", 3),
            Arguments.of("abc", "abc", 3),
            Arguments.of("abc", "def", 0),
        )
    }

    @Nested
    inner class LongestCommonSubsequenceDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of their longest common subsequence`(
            text1: String,
            text2: String,
            expected: Int
        ) {
            LongestCommonSubsequenceDPTopDown().test(text1, text2, expected)
        }
    }

    @Nested
    inner class LongestCommonSubsequenceDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of their longest common subsequence`(
            text1: String,
            text2: String,
            expected: Int
        ) {
            LongestCommonSubsequenceDPBottomUp().test(text1, text2, expected)
        }
    }

    private fun LongestCommonSubsequence.test(text1: String, text2: String, expected: Int) {
        val actual = longestCommonSubsequence(text1, text2)
        assertEquals(expected, actual)
    }
}