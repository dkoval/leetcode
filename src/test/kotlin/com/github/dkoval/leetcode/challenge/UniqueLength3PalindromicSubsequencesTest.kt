package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.UniqueLength3PalindromicSubsequences.UniqueLength3PalindromicSubsequencesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class UniqueLength3PalindromicSubsequencesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "aabca",
                3
            ),
            Arguments.of(
                "adc",
                0
            ),
            Arguments.of(
                "bbcbaba",
                4
            ),
            Arguments.of(
                "uuuuu",
                1
            ),
            Arguments.of(
                "tlpjzdmtwderpkpmgoyrcxttiheassztncqvnfjeyxxp",
                161
            )
        )
    }

    @Nested
    inner class UniqueLength3PalindromicSubsequencesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of unique palindromes of length 3 that are a subsequence of s`(
            s: String,
            expected: Int
        ) {
            UniqueLength3PalindromicSubsequencesRev1().test(s, expected)
        }
    }
}

private fun UniqueLength3PalindromicSubsequences.test(s: String, expected: Int) {
    val actual = countPalindromicSubsequence(s)
    assertEquals(expected, actual)
}
