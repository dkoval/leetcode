package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.VowelSpellchecker.VowelSpellcheckerRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class VowelSpellcheckerTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> =
            Stream.of(
                Arguments.of(
                    arrayOf("KiTe", "kite", "hare", "Hare"),
                    arrayOf("kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"),
                    arrayOf("kite", "KiTe", "KiTe", "Hare", "hare", "", "", "KiTe", "", "KiTe")
                )
            )
    }

    @Nested
    inner class VowelSpellcheckerRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should converts a query word into a correct word`(
            wordlist: Array<String>,
            queries: Array<String>,
            expected: Array<String>
        ) {
            VowelSpellcheckerRev1().test(wordlist, queries, expected)
        }
    }
}

private fun VowelSpellchecker.test(wordlist: Array<String>, queries: Array<String>, expected: Array<String>) {
    val actual = spellchecker(wordlist, queries)
    assertArrayEquals(expected, actual)
}
