package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.problems.RansomNote
import com.github.dkoval.leetcode.problems.RansomNote.RansomNoteUsingSingleArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RansomNoteTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of("a", "b", false),
            Arguments.of("aa", "ab", false),
            Arguments.of("aa", "aab", true)
        )
    }

    @Nested
    inner class RansomNoteUsingSingleArrayTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if the ransom note can be constructed from the magazines`(
            ransomNote: String,
            magazine: String,
            expected: Boolean
        ) {
            RansomNoteUsingSingleArray().test(ransomNote, magazine, expected)
        }
    }

    @Nested
    inner class RansomNoteUsingTwoFrequencyTablesTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if the ransom note can be constructed from the magazines`(
            ransomNote: String,
            magazine: String,
            expected: Boolean
        ) {
            RansomNoteUsingTwoFrequencyTables.test(ransomNote, magazine, expected)
        }
    }

    private fun RansomNote.test(ransomNote: String, magazine: String, expected: Boolean) {
        val actual = canConstruct(ransomNote, magazine)
        assertEquals(expected, actual)
    }
}