package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.UncommonWordsFromTwoSentences.UncommonWordsFromTwoSentencesRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class UncommonWordsFromTwoSentencesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "this apple is sweet",
                "this apple is sour",
                arrayOf("sweet", "sour")
            ),
            Arguments.of(
                "apple apple",
                "banana",
                arrayOf("banana")
            )
        )
    }

    @Nested
    inner class UncommonWordsFromTwoSentencesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a list of all the uncommon words in any order`(
            s1: String,
            s2: String,
            expected: Array<String>
        ) {
            UncommonWordsFromTwoSentencesRev1().test(s1, s2, expected)
        }
    }
}

private fun UncommonWordsFromTwoSentences.test(s1: String, s2: String, expected: Array<String>) {
    val actual = uncommonFromSentences(s1, s2)
    assertThat(actual).containsExactlyInAnyOrder(*expected)
}
