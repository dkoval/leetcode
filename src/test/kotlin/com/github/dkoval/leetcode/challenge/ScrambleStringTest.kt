package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ScrambleString.ScrambleStringDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ScrambleStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("great", "rgeat", true),
            Arguments.of("abcde", "caebd", false),
            Arguments.of("a", "a", true)
        )
    }

    @Nested
    inner class ScrambleStringDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if s2 is a scrambled string of s1, otherwise, return false`(
            s1: String,
            s2: String,
            expected: Boolean
        ) {
            ScrambleStringDPTopDown().test(s1, s2, expected)
        }
    }
}

private fun ScrambleStringDPTopDown.test(s1: String, s2: String, expected: Boolean) {
    val actual = isScramble(s1, s2)
    assertEquals(expected, actual)
}
