package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ReplaceWords.ReplaceWordsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ReplaceWordsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf("cat", "bat", "rat"),
                "the cattle was rattled by the battery",
                "the cat was rat by the bat"
            ),
            Arguments.of(
                listOf("a", "b", "c"),
                "aadsfasf absbs bbab cadsfafs",
                "a a b c"
            )
        )
    }

    @Nested
    inner class ReplaceWordsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should replace all the derivatives in the sentence with the root forming it`(
            dictionary: List<String>,
            sentence: String,
            expected: String
        ) {
            ReplaceWordsRev1().test(dictionary, sentence, expected)
        }
    }
}

private fun ReplaceWords.test(dictionary: List<String>, sentence: String, expected: String) {
    val actual = replaceWords(dictionary, sentence)
    assertEquals(expected, actual)
}
