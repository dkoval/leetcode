package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LargestSubstringBetweenTwoEqualCharacters.LargestSubstringBetweenTwoEqualCharactersRev1
import com.github.dkoval.leetcode.challenge.LargestSubstringBetweenTwoEqualCharacters.LargestSubstringBetweenTwoEqualCharactersRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LargestSubstringBetweenTwoEqualCharactersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("aa", 0),
            Arguments.of("abca", 2),
            Arguments.of("cbzxy", -1),
            Arguments.of("mgntdygtxrvxjnwksqhxuxtrv", 18)
        )
    }

    @Nested
    inner class LargestSubstringBetweenTwoEqualCharactersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest substring between two equal characters, excluding the two characters`(
            s: String,
            expected: Int
        ) {
            LargestSubstringBetweenTwoEqualCharactersRev1().test(s, expected)
        }
    }

    @Nested
    inner class LargestSubstringBetweenTwoEqualCharactersRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest substring between two equal characters, excluding the two characters`(
            s: String,
            expected: Int
        ) {
            LargestSubstringBetweenTwoEqualCharactersRev2().test(s, expected)
        }
    }
}

private fun LargestSubstringBetweenTwoEqualCharacters.test(s: String, expected: Int) {
    val actual = maxLengthBetweenEqualCharacters(s)
    assertEquals(expected, actual)
}
