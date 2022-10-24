package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumLengthOfConcatenatedStringWithUniqueCharacters.MaximumLengthOfConcatenatedStringWithUniqueCharactersRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumLengthOfConcatenatedStringWithUniqueCharactersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf("un", "iq", "ue"),
                4
            ),
            Arguments.of(
                listOf("cha", "r", "act", "ers"),
                6
            ),
            Arguments.of(
                listOf("abcdefghijklmnopqrstuvwxyz"),
                26
            ),
            Arguments.of(
                listOf("yy", "bkhwmpbiisbldzknpm"),
                0
            ),
            Arguments.of(
                listOf(
                    "uiufinyivbmmybj",
                    "bxcvrjtqbdlhyrgwm",
                    "ankxxcqrppojtamqcorbbqmvo",
                    "cca",
                    "mkxsdfjycghecwoilphgan",
                    "fgegnmgebctbm",
                    "euiqnrkkhbmqdemshsznnq",
                    "wxagkaqvqsvgjbtohwpfzw"
                ),
                0
            )
        )
    }

    @Nested
    inner class MaximumLengthOfConcatenatedStringWithUniqueCharactersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum possible length of a concatenation of a sub-sequence of arr which have unique characters`(
            arr: List<String>,
            expected: Int
        ) {
            MaximumLengthOfConcatenatedStringWithUniqueCharactersRev1().test(arr, expected)
        }
    }

    private fun MaximumLengthOfConcatenatedStringWithUniqueCharacters.test(arr: List<String>, expected: Int) {
        val actual = maxLength(arr)
        assertEquals(expected, actual)
    }
}