package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SumOfPrefixScoresOfStrings.SumOfPrefixScoresOfStringsRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SumOfPrefixScoresOfStringsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("abc", "ab", "bc", "b"),
                intArrayOf(5, 4, 3, 2)
            ),
            Arguments.of(
                arrayOf("abcd"),
                intArrayOf(4)
            )
        )
    }

    @Nested
    inner class SumOfPrefixScoresOfStringsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array answer of size n where answer(i) is the sum of scores of every non-empty prefix of words(i)`(
            words: Array<String>,
            expected: IntArray
        ) {
            SumOfPrefixScoresOfStringsRev1().test(words, expected)
        }
    }
}

private fun SumOfPrefixScoresOfStrings.test(words: Array<String>, expected: IntArray) {
    val actual = sumPrefixScores(words)
    assertArrayEquals(expected, actual)
}
