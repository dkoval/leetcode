package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ShortestCommonSupersequence.ShortestCommonSupersequenceRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class ShortestCommonSupersequenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abac",
                "cab",
                "cabac"
            ),
            Arguments.of(
                "aaaaaaaa",
                "aaaaaaaa",
                "aaaaaaaa"
            )
        )
    }

    @Nested
    inner class ShortestCommonSupersequenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the shortest common supersequence`(str1: String, str2: String, expected: String) {
            ShortestCommonSupersequenceRev1().test(str1, str2, expected)
        }
    }
}

private fun ShortestCommonSupersequence.test(str1: String, str2: String, expected: String) {
    val actual = shortestCommonSupersequence(str1, str2)
    assertEquals(expected, actual)
}
