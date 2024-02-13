package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindFirstPalindromicStringInArray.FindFirstPalindromicStringInArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindFirstPalindromicStringInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("abc", "car", "ada", "racecar", "cool"),
                "ada"
            ),
            Arguments.of(
                arrayOf("notapalindrome", "racecar"),
                "racecar"
            ),
            Arguments.of(
                arrayOf("def", "ghi"),
                ""
            )
        )
    }

    @Nested
    inner class FindFirstPalindromicStringInArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the first palindromic string in the array`(words: Array<String>, expected: String) {
            FindFirstPalindromicStringInArrayRev1().test(words, expected)
        }
    }
}

private fun FindFirstPalindromicStringInArray.test(words: Array<String>, expected: String) {
    val actual = firstPalindrome(words)
    assertEquals(expected, actual)
}
