package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindIndexOfFirstOccurrenceInString.FindIndexOfFirstOccurrenceInStringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindIndexOfFirstOccurrenceInStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("sadbutsad", "sad", 0),
            Arguments.of("leetcode", "leeto", -1)
        )
    }

    @Nested
    inner class FindIndexOfFirstOccurrenceInStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the index of the first occurrence of needle in haystack`(
            haystack: String,
            needle: String,
            expected: Int
        ) {
            FindIndexOfFirstOccurrenceInStringRev1().test(haystack, needle, expected)
        }
    }
}

private fun FindIndexOfFirstOccurrenceInString.test(haystack: String, needle: String, expected: Int) {
    val actual = strStr(haystack, needle)
    assertEquals(expected, actual)
}
