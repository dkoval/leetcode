package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SortCharactersByFrequency.SortCharactersByFrequencyRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SortCharactersByFrequencyTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("tree", setOf("eert", "eetr")),
            Arguments.of("cccaaa", setOf("cccaaa", "aaaccc")),
            Arguments.of("Aabb", setOf("bbAa", "bbaA"))
        )
    }

    @Nested
    inner class SortCharactersByFrequencyRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should sort a string decreasing order based on the frequency of characters`(s: String, expected: Set<String>) {
            SortCharactersByFrequencyRev1().test(s, expected)
        }
    }

    @Nested
    inner class SortCharactersByFrequencyKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should sort a string decreasing order based on the frequency of characters`(s: String, expected: Set<String>) {
            SortCharactersByFrequencyKt.test(s, expected)
        }
    }
}

private fun SortCharactersByFrequency.test(s: String, expected: Set<String>) {
    val actual = frequencySort(s)
    assertThat(actual).isIn(expected)
}
