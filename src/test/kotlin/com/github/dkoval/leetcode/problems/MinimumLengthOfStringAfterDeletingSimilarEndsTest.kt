package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.MinimumLengthOfStringAfterDeletingSimilarEnds.MinimumLengthOfStringAfterDeletingSimilarEndsRev1
import com.github.dkoval.leetcode.problems.MinimumLengthOfStringAfterDeletingSimilarEnds.MinimumLengthOfStringAfterDeletingSimilarEndsRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumLengthOfStringAfterDeletingSimilarEndsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("ca", 2),
            Arguments.of("cabaabac", 0),
            Arguments.of("aabccabba", 3)
        )
    }

    @Nested
    inner class MinimumLengthOfStringAfterDeletingSimilarEndsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum length of s after performing the above operation any number of times`(
            s: String,
            expected: Int
        ) {
            MinimumLengthOfStringAfterDeletingSimilarEndsRev1().test(s, expected)
        }
    }

    @Nested
    inner class MinimumLengthOfStringAfterDeletingSimilarEndsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum length of s after performing the above operation any number of times`(
            s: String,
            expected: Int
        ) {
            MinimumLengthOfStringAfterDeletingSimilarEndsRev2().test(s, expected)
        }
    }
}

private fun MinimumLengthOfStringAfterDeletingSimilarEnds.test(s: String, expected: Int) {
    val actual = minimumLength(s)
    assertEquals(expected, actual)
}
