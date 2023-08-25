package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.InterleavingString.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class InterleavingStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "aabcc",
                "dbbca",
                "aadbbcbcac",
                true
            ),
            Arguments.of(
                "aabcc",
                "dbbca",
                "aadbbbaccc",
                false
            ),
            Arguments.of(
                "",
                "",
                "",
                true
            ),
            Arguments.of(
                "db",
                "b",
                "cbb",
                false
            ),
            Arguments.of(
                "a",
                "",
                "c",
                false
            ),
            Arguments.of(
                "",
                "a",
                "c",
                false
            )
        )
    }

    @Nested
    inner class InterleavingStringTopDownRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find whether s3 is formed by an interleaving of s1 and s2`(
            s1: String,
            s2: String,
            s3: String,
            expected: Boolean
        ) {
            InterleavingStringTopDownRev1().test(s1, s2, s3, expected)
        }
    }

    @Nested
    inner class InterleavingStringTopDownRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find whether s3 is formed by an interleaving of s1 and s2`(
            s1: String,
            s2: String,
            s3: String,
            expected: Boolean
        ) {
            InterleavingStringTopDownRev2().test(s1, s2, s3, expected)
        }
    }

    @Nested
    inner class InterleavingStringBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find whether s3 is formed by an interleaving of s1 and s2`(
            s1: String,
            s2: String,
            s3: String,
            expected: Boolean
        ) {
            InterleavingStringBottomUp().test(s1, s2, s3, expected)
        }
    }

    @Nested
    inner class InterleavingStringBottomUpSpaceOptimizedTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find whether s3 is formed by an interleaving of s1 and s2`(
            s1: String,
            s2: String,
            s3: String,
            expected: Boolean
        ) {
            InterleavingStringBottomUpSpaceOptimized().test(s1, s2, s3, expected)
        }
    }
}

private fun InterleavingString.test(s1: String, s2: String, s3: String, expected: Boolean) {
    val actual = isInterleave(s1, s2, s3)
    assertEquals(expected, actual)
}
