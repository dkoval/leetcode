package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MakeStringSubsequenceUsingCyclicIncrements.MakeStringSubsequenceUsingCyclicIncrementsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MakeStringSubsequenceUsingCyclicIncrementsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("abc", "ad", true),
            Arguments.of("zc", "ad", true),
            Arguments.of("ab", "d", false)
        )
    }

    @Nested
    inner class MakeStringSubsequenceUsingCyclicIncrementsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if it is possible to make str2 a subsequence of str1 by performing the operation at most once`(
            str1: String,
            str2: String,
            expected: Boolean
        ) {
            MakeStringSubsequenceUsingCyclicIncrementsRev1().test(str1, str2, expected)
        }
    }
}

private fun MakeStringSubsequenceUsingCyclicIncrements.test(str1: String, str2: String, expected: Boolean) {
    val actual = canMakeSubsequence(str1, str2)
    assertEquals(expected, actual)
}
