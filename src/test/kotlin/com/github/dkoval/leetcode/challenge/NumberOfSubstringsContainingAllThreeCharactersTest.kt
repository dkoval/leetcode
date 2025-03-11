package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfSubstringsContainingAllThreeCharacters.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class NumberOfSubstringsContainingAllThreeCharactersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("abcabc", 10),
            Arguments.of("aaacb", 3),
            Arguments.of("abc", 1)
        )
    }

    @Nested
    inner class NumberOfSubstringsContainingAllThreeCharactersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of substrings that contain all three characters a, b and c`(
            s: String,
            expected: Int
        ) {
            NumberOfSubstringsContainingAllThreeCharactersRev1().test(s, expected)
        }
    }

    @Nested
    inner class NumberOfSubstringsContainingAllThreeCharactersRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of substrings that contain all three characters a, b and c`(
            s: String,
            expected: Int
        ) {
            NumberOfSubstringsContainingAllThreeCharactersRev2().test(s, expected)
        }
    }

    @Nested
    inner class NumberOfSubstringsContainingAllThreeCharactersRev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of substrings that contain all three characters a, b and c`(
            s: String,
            expected: Int
        ) {
            NumberOfSubstringsContainingAllThreeCharactersRev3().test(s, expected)
        }
    }
}

private fun NumberOfSubstringsContainingAllThreeCharacters.test(s: String, expected: Int) {
    val actual = numberOfSubstrings(s)
    assertEquals(expected, actual)
}
