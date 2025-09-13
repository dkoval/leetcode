package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindMostFrequentVowelAndConsonant.FindMostFrequentVowelAndConsonantRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindMostFrequentVowelAndConsonantTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("successes", 6),
            Arguments.of("aeiaeia", 3)
        )
    }

    @Nested
    inner class FindMostFrequentVowelAndConsonantRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the sum of the two frequencies`(s: String, expected: Int) {
            FindMostFrequentVowelAndConsonantRev1().test(s, expected)
        }
    }
}

private fun FindMostFrequentVowelAndConsonant.test(s: String, expected: Int) {
    val actual = maxFreqSum(s)
    assertEquals(expected, actual)
}
