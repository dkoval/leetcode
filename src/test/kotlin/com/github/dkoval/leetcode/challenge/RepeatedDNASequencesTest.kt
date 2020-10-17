package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RepeatedDNASequences.RepeatedDNASequencesStraightforward
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RepeatedDNASequencesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
                listOf("AAAAACCCCC", "CCCCCAAAAA")
            ),
            Arguments.of(
                "AAAAAAAAAAAAA",
                listOf("AAAAAAAAAA")
            )
        )
    }

    @Nested
    inner class RepeatedDNASequencesStraightforwardTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find all the 10-letter-long substrings that occur more than once in a DNA molecule`(
            s: String,
            expected: List<String>
        ) {
            RepeatedDNASequencesStraightforward().test(s, expected)
        }
    }

    private fun RepeatedDNASequences.test(s: String, expected: List<String>) {
        val actual = findRepeatedDnaSequences(s)
        assertEquals(expected, actual)
    }
}