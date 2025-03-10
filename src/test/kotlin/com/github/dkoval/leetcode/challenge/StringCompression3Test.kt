package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.StringCompression3.StringCompression3Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class StringCompression3Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("abcde", "1a1b1c1d1e"),
            Arguments.of("aaaaaaaaaaaaaabb", "9a5a2b")
        )
    }

    @Nested
    inner class StringCompression3Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compress a string`(word: String, expected: String) {
            StringCompression3Rev1().test(word, expected)
        }
    }
}

private fun StringCompression3.test(word: String, expected: String) {
    val actual = compressedString(word)
    assertEquals(expected, actual)
}
