package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountingWordsWithGivenPrefix.CountingWordsWithGivenPrefixRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountingWordsWithGivenPrefixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("pay", "attention", "practice", "attend"),
                "at",
                2
            ),
            Arguments.of(
                arrayOf("leetcode", "win", "loops", "success"),
                "code",
                0
            )
        )
    }

    @Nested
    inner class CountingWordsWithGivenPrefixRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should Return the number of strings in words that contain pref as a prefix`(
            words: Array<String>,
            pref: String,
            expected: Int
        ) {
            CountingWordsWithGivenPrefixRev1().test(words, pref, expected)
        }
    }
}

private fun CountingWordsWithGivenPrefix.test(words: Array<String>, pref: String, expected: Int) {
    val actual = prefixCount(words, pref)
    assertEquals(expected, actual)
}
