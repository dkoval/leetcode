package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindLongestSubstringContainingVowelsInEvenCounts.FindLongestSubstringContainingVowelsInEvenCountsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindLongestSubstringContainingVowelsInEvenCountsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("eleetminicoworoep", 13),
            Arguments.of("leetcodeisgreat", 5),
            Arguments.of("bcbcbc", 6)
        )
    }

    @Nested
    inner class FindLongestSubstringContainingVowelsInEvenCountsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the size of the longest substring containing each vowel an even number of times`(
            s: String,
            expected: Int
        ) {
            FindLongestSubstringContainingVowelsInEvenCountsRev1().test(s, expected)
        }
    }
}

private fun FindLongestSubstringContainingVowelsInEvenCounts.test(s: String, expected: Int) {
    val actual = findTheLongestSubstring(s)
    assertEquals(expected, actual)
}
