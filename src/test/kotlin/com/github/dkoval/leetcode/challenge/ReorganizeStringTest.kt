package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ReorganizeString.ReorganizeStringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ReorganizeStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("aab", "aba"),
            Arguments.of("aaab", ""),
            Arguments.of("ab", "ab"),
            Arguments.of("baaba", "ababa")
        )
    }

    @Nested
    inner class ReorganizeStringTestRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return any possible rearrangement of s if possible`(s: String, expected: String) {
            ReorganizeStringRev1().test(s, expected)
        }
    }
}

private fun ReorganizeString.test(s: String, expected: String) {
    val actual = reorganizeString(s)
    assertEquals(expected, actual)
}
