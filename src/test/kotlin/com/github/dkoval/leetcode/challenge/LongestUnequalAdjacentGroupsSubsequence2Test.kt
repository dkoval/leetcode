package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestUnequalAdjacentGroupsSubsequence2.LongestUnequalAdjacentGroupsSubsequence2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestUnequalAdjacentGroupsSubsequence2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("bab", "dab", "cab"),
                intArrayOf(1, 2, 2),
                listOf("bab", "dab")
            ),
            Arguments.of(
                arrayOf("a", "b", "c", "d"),
                intArrayOf(1, 2, 3, 4),
                listOf("a", "b", "c", "d")
            )
        )
    }

    @Nested
    inner class LongestUnequalAdjacentGroupsSubsequence2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a string array containing the words corresponding to the indices (in order) in the selected subsequence`(
            words: Array<String>,
            groups: IntArray,
            expected: List<String>
        ) {
            LongestUnequalAdjacentGroupsSubsequence2Rev1().test(words, groups, expected)
        }
    }
}

private fun LongestUnequalAdjacentGroupsSubsequence2.test(
    words: Array<String>,
    groups: IntArray,
    expected: List<String>
) {
    val actual = getWordsInLongestSubsequence(words, groups)
    assertEquals(expected, actual)
}
