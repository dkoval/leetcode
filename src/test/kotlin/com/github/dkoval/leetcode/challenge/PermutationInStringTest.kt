package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PermutationInString.PermutationInStringRev2
import com.github.dkoval.leetcode.challenge.PermutationInString.PermutationInStringRev3
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PermutationInStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("ab", "eidbaooo", true),
            Arguments.of("ab", "eidboaoo", false),
            Arguments.of("adc", "dcda", true)
        )
    }

    @Nested
    inner class PermutationInStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if s2 contains the permutation of s1`(s1: String, s2: String, expected: Boolean) {
            PermutationInStringRev1.test(s1, s2, expected)
        }
    }

    @Nested
    inner class PermutationInStringRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if s2 contains the permutation of s1`(s1: String, s2: String, expected: Boolean) {
            PermutationInStringRev2().test(s1, s2, expected)
        }
    }

    @Nested
    inner class PermutationInStringRev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if s2 contains the permutation of s1`(s1: String, s2: String, expected: Boolean) {
            PermutationInStringRev3().test(s1, s2, expected)
        }
    }
}

private fun PermutationInString.test(s1: String, s2: String, expected: Boolean) {
    val actual = checkInclusion(s1, s2)
    assertEquals(expected, actual)
}
