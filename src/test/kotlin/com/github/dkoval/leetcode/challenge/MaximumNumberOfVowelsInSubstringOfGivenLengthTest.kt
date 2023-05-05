package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumNumberOfVowelsInSubstringOfGivenLength.MaximumNumberOfVowelsInSubstringOfGivenLengthRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumNumberOfVowelsInSubstringOfGivenLengthTest {

    class InputArgumentProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("abciiidef", 3, 3),
            Arguments.of("aeiou", 2, 2),
            Arguments.of("leetcode", 3, 2)
        )
    }

    @Nested
    inner class MaximumNumberOfVowelsInSubstringOfGivenLengthRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentProvider::class)
        fun `should return the maximum number of vowel letters in any substring of s with length k`(
            s: String,
            k: Int,
            expected: Int
        ) {
            MaximumNumberOfVowelsInSubstringOfGivenLengthRev1().test(s, k, expected)
        }
    }
}

private fun MaximumNumberOfVowelsInSubstringOfGivenLength.test(s: String, k: Int, expected: Int) {
    val actual = maxVowels(s, k)
    assertEquals(expected, actual)
}
