package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.VerifyingAlienDictionary.VerifyingAlienDictionaryRev1
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class VerifyingAlienDictionaryTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("hello", "leetcode"),
                "hlabcdefgijkmnopqrstuvwxyz",
                true
            ),
            Arguments.of(
                arrayOf("word", "world", "row"),
                "worldabcefghijkmnpqstuvxyz",
                false
            ),
            Arguments.of(
                arrayOf("apple", "app"),
                "abcdefghijklmnopqrstuvwxyz",
                false
            ),
            Arguments.of(
                arrayOf("ubg", "khw"),
                "qcipyamwvdjtesbghlorufnkzx",
                true
            )
        )
    }

    @Nested
    inner class VerifyingAlienDictionaryRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if and only if the given words are sorted lexicographically in alien language`(
            words: Array<String>,
            order: String,
            expected: Boolean
        ) {
            VerifyingAlienDictionaryRev1().test(words, order, expected)
        }
    }
}

private fun VerifyingAlienDictionary.test(words: Array<String>, order: String, expected: Boolean) {
    val actual = isAlienSorted(words, order)
    Assertions.assertEquals(expected, actual)
}
