package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SplitStringIntoMaxNumberOfUniqueSubstrings.SplitStringIntoMaxNumberOfUniqueSubstringsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SplitStringIntoMaxNumberOfUniqueSubstringsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("ababccc", 5),
            Arguments.of("aba", 2),
            Arguments.of("aa", 1),
            Arguments.of("wwwzfvedwfvhsww", 11)
        )
    }

    @Nested
    inner class SplitStringIntoMaxNumberOfUniqueSubstringsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of unique substrings that the given string can be split into`(
            s: String,
            expected: Int
        ) {
            SplitStringIntoMaxNumberOfUniqueSubstringsRev1().test(s, expected)
        }
    }
}

private fun SplitStringIntoMaxNumberOfUniqueSubstrings.test(s: String, expected: Int) {
    val actual = maxUniqueSplit(s)
    assertEquals(expected, actual)
}
