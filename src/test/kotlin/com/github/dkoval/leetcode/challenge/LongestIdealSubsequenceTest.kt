package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestIdealSubsequence.LongestIdealSubsequenceDPBottomUpRev1
import com.github.dkoval.leetcode.challenge.LongestIdealSubsequence.LongestIdealSubsequenceDPBottomUpRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestIdealSubsequenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "acfgbd",
                2,
                4
            ),
            Arguments.of(
                "abcd",
                3,
                4
            ),
            Arguments.of(
                "lkpkxcigcs",
                6,
                7
            )
        )
    }

    @Nested
    inner class LongestIdealSubsequenceDPBottomUpRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest ideal string`(s: String, k: Int, expected: Int) {
            LongestIdealSubsequenceDPBottomUpRev1().test(s, k, expected)
        }
    }

    @Nested
    inner class LongestIdealSubsequenceDPBottomUpRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest ideal string`(s: String, k: Int, expected: Int) {
            LongestIdealSubsequenceDPBottomUpRev2().test(s, k, expected)
        }
    }
}

private fun LongestIdealSubsequence.test(s: String, k: Int, expected: Int) {
    val actual = longestIdealString(s, k)
    assertEquals(expected, actual)
}
