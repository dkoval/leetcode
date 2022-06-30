package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.MinimumGeneticMutation.MinimumGeneticMutationBFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumGeneticMutationTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "AACCGGTT",
                "AACCGGTA",
                arrayOf("AACCGGTA"),
                1
            ),
            Arguments.of(
                "AACCGGTT",
                "AAACGGTA",
                arrayOf("AACCGGTA", "AACCGCTA", "AAACGGTA"),
                2
            ),
            Arguments.of(
                "AAAAACCC",
                "AACCCCCC",
                arrayOf("AAAACCCC", "AAACCCCC", "AACCCCCC"),
                3
            ),
            Arguments.of(
                "AAAAAAAA",
                "CCCCCCCC",
                arrayOf(
                    "AAAAAAAA",
                    "AAAAAAAC",
                    "AAAAAACC",
                    "AAAAACCC",
                    "AAAACCCC",
                    "AACACCCC",
                    "ACCACCCC",
                    "ACCCCCCC",
                    "CCCCCCCA"
                ),
                -1
            )
        )
    }

    @Nested
    inner class MinimumGeneticMutationBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of mutations needed to mutate from start to end`(
            start: String,
            end: String,
            bank: Array<String>,
            expected: Int
        ) {
            MinimumGeneticMutationBFS().test(start, end, bank, expected)
        }
    }

    private fun MinimumGeneticMutation.test(start: String, end: String, bank: Array<String>, expected: Int) {
        val actual = minMutation(start, end, bank)
        assertEquals(expected, actual)
    }
}