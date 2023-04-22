package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumInsertionStepsToMakeStringPalindrome.MinimumInsertionStepsToMakeStringPalindromeDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumInsertionStepsToMakeStringPalindromeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("zzazz", 0),
            Arguments.of("mbadm", 2),
            Arguments.of("leetcode", 5)
        )
    }

    @Nested
    inner class MinimumInsertionStepsToMakeStringPalindromeDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of steps to make s palindrome`(s: String, expected: Int) {
            MinimumInsertionStepsToMakeStringPalindromeDPTopDown().test(s, expected)
        }
    }
}

private fun MinimumInsertionStepsToMakeStringPalindrome.test(s: String, expected: Int) {
    val actual = minInsertions(s)
    assertEquals(expected, actual)
}
