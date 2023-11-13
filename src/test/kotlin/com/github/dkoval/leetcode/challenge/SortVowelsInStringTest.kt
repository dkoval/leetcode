package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SortVowelsInString.SortVowelsInStringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SortVowelsInStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "lEetcOde",
                "lEOtcede"
            ),
            Arguments.of(
                "lYmpH",
                "lYmpH"
            )
        )
    }

    @Nested
    inner class SortVowelsInStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should sort vowels in a string`(s: String, expected: String) {
            SortVowelsInStringRev1().test(s, expected)
        }
    }
}

private fun SortVowelsInString.test(s: String, expected: String) {
    val actual = sortVowels(s)
    assertEquals(expected, actual)
}
