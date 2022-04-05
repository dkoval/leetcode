package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestSubstringWithoutRepeatingCharacters.LongestSubstringWithoutRepeatingCharactersRev1
import com.github.dkoval.leetcode.challenge.LongestSubstringWithoutRepeatingCharacters.LongestSubstringWithoutRepeatingCharactersRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestSubstringWithoutRepeatingCharactersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("abcabcbb", 3),
            Arguments.of("bbbbb", 1),
            Arguments.of("pwwkew", 3),
            Arguments.of("", 0)
        )
    }

    @Nested
    inner class LongestSubstringWithoutRepeatingCharactersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the length of the longest substring without repeating characters`(s: String, expected: Int) {
            LongestSubstringWithoutRepeatingCharactersRev1().test(s, expected)
        }
    }

    @Nested
    inner class LongestSubstringWithoutRepeatingCharactersRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the length of the longest substring without repeating characters`(s: String, expected: Int) {
            LongestSubstringWithoutRepeatingCharactersRev2().test(s, expected)
        }
    }

    private fun LongestSubstringWithoutRepeatingCharacters.test(s: String, expected: Int) {
        val actual = lengthOfLongestSubstring(s)
        assertEquals(expected, actual)
    }
}