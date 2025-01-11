package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ConstructKPalindromeStrings.ConstructKPalindromeStringsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ConstructKPalindromeStringsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("annabelle", 2, true),
            Arguments.of("leetcode", 3, false),
            Arguments.of("true", 4, true)
        )
    }

    @Nested
    inner class ConstructKPalindromeStringsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if you can use all the characters in s to construct k palindrome strings`(
            s: String,
            k: Int,
            expected: Boolean
        ) {
            ConstructKPalindromeStringsRev1().test(s, k, expected)
        }
    }
}

private fun ConstructKPalindromeStrings.test(s: String, k: Int, expected: Boolean) {
    val actual = canConstruct(s, k)
    assertEquals(expected, actual)
}
