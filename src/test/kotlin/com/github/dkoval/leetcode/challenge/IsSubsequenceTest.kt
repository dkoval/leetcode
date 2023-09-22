package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.IsSubsequence.IsSubsequenceRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class IsSubsequenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("abc", "ahbgdc", true),
            Arguments.of("axc", "ahbgdc", false),
            Arguments.of("aaaaaa", "bbaaaa", false),
            Arguments.of("b", "abc", true),
            Arguments.of("bb", "ahbgdc", false)
        )
    }

    @Nested
    inner class IsSubsequenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if s is subsequence of t`(s: String, t: String, expected: Boolean) {
            IsSubsequenceRev1.test(s, t, expected)
        }
    }

    @Nested
    inner class IsSubsequenceRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if s is subsequence of t`(s: String, t: String, expected: Boolean) {
            IsSubsequenceRev2().test(s, t, expected)
        }
    }
}

private fun IsSubsequence.test(s: String, t: String, expected: Boolean) {
    val actual = isSubsequence(s, t)
    assertEquals(expected, actual)
}
