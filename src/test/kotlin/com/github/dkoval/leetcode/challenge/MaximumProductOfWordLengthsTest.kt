package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumProductOfWordLengths.MaximumProductOfWordLengthsBruteForce
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumProductOfWordLengthsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("abcw", "baz", "foo", "bar", "xtfn", "abcdef"),
                16
            ),
            Arguments.of(
                arrayOf("a", "ab", "abc", "d", "cd", "bcd", "abcd"),
                4
            ),
            Arguments.of(
                arrayOf("a", "aa", "aaa", "aaaa"),
                0
            )
        )
    }

    @Nested
    inner class MaximumProductOfWordLengthsBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return maximum product of word lengths`(words: Array<String>, expected: Int) {
            MaximumProductOfWordLengthsBruteForce().test(words, expected)
        }
    }

    private fun MaximumProductOfWordLengths.test(words: Array<String>, expected: Int) {
        val actual = maxProduct(words)
        assertEquals(expected, actual)
    }
}