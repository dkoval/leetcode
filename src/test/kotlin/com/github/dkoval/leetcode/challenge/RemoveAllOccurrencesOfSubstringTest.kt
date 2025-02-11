package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RemoveAllOccurrencesOfSubstring.RemoveAllOccurrencesOfSubstringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class RemoveAllOccurrencesOfSubstringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "daabcbaabcbc",
                "abc",
                "dab"
            ),
            Arguments.of(
                "axxxxyyyyb",
                "xy",
                "ab"
            )
        )
    }

    @Nested
    inner class RemoveAllOccurrencesOfSubstringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return s after removing all occurrences of part`(s: String, part: String, expected: String) {
            RemoveAllOccurrencesOfSubstringRev1().test(s, part, expected)
        }
    }
}

private fun RemoveAllOccurrencesOfSubstring.test(s: String, part: String, expected: String) {
    val actual = removeOccurrences(s, part)
    assertEquals(expected, actual)
}
