package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindCommonCharacters.FindCommonCharactersRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindCommonCharactersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("bella", "label", "roller"),
                arrayOf("e", "l", "l")
            ),
            Arguments.of(
                arrayOf("cool", "lock", "cook"),
                arrayOf("c", "o")
            ),
            Arguments.of(
                arrayOf("acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"),
                emptyArray<String>()
            )
        )
    }

    @Nested
    inner class FindCommonCharactersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of all characters that show up in all strings within the words (including duplicates)`(
            words: Array<String>,
            expected: Array<String>
        ) {
            FindCommonCharactersRev1().test(words, expected)
        }
    }
}

private fun FindCommonCharacters.test(words: Array<String>, expected: Array<String>) {
    val actual = commonChars(words)
    assertThat(actual).containsExactlyInAnyOrder(*expected)
}
