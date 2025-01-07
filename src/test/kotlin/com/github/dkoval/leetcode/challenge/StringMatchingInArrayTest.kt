package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.StringMatchingInArray.StringMatchingInArrayRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class StringMatchingInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("mass", "as", "hero", "superhero"),
                listOf("as", "hero")
            ),
            Arguments.of(
                arrayOf("leetcode", "et", "code"),
                listOf("et", "code")
            ),
            Arguments.of(
                arrayOf("blue", "green", "bu"),
                emptyList<String>()
            ),
            Arguments.of(
                arrayOf("leetcoder", "leetcode", "od", "hamlet", "am"),
                listOf("leetcode", "od", "am")
            )
        )
    }

    @Nested
    inner class StringMatchingInArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all strings in words that is a substring of another word`(
            words: Array<String>,
            expected: List<String>
        ) {
            StringMatchingInArrayRev1().test(words, expected)
        }
    }
}

private fun StringMatchingInArrayRev1.test(words: Array<String>, expected: List<String>) {
    val actual = stringMatching(words)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
