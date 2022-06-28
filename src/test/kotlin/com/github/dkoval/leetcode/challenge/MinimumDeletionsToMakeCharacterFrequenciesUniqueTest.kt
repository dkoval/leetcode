package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumDeletionsToMakeCharacterFrequenciesUnique.MinimumDeletionsToMakeCharacterFrequenciesUniqueRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumDeletionsToMakeCharacterFrequenciesUniqueTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("aab", 0),
            Arguments.of("aaabbbcc", 2),
            Arguments.of("ceabaacb", 2),
            Arguments.of("abcabc", 3),
            Arguments.of("bbcebab", 2)
        )
    }

    @Nested
    inner class MinimumDeletionsToMakeCharacterFrequenciesUniqueRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of characters you need to delete to make s good`(s: String, expected: Int) {
            MinimumDeletionsToMakeCharacterFrequenciesUniqueRev1().test(s, expected)
        }
    }

    private fun MinimumDeletionsToMakeCharacterFrequenciesUnique.test(s: String, expected: Int) {
        val actual = minDeletions(s)
        assertEquals(expected, actual)
    }
}