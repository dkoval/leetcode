package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumNumberOfStepsToMakeTwoStringsAnagram.MinimumNumberOfStepsToMakeTwoStringsAnagramRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumNumberOfStepsToMakeTwoStringsAnagramTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("bab", "aba", 1),
            Arguments.of("leetcode", "practice", 5),
            Arguments.of("anagram", "mangaar", 0)
        )
    }

    @Nested
    inner class MinimumNumberOfStepsToMakeTwoStringsAnagramRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of steps to make t an anagram of s`(s: String, t: String, expected: Int) {
            MinimumNumberOfStepsToMakeTwoStringsAnagramRev1().test(s, t, expected)
        }
    }
}

private fun MinimumNumberOfStepsToMakeTwoStringsAnagram.test(s: String, t: String, expected: Int) {
    val actual = minSteps(s, t)
    assertEquals(expected, actual)
}
