package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestUnequalAdjacentGroupsSubsequence1.LongestUnequalAdjacentGroupsSubsequence1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestUnequalAdjacentGroupsSubsequence1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("c"),
                intArrayOf(0),
                listOf("c")
            ),
            Arguments.of(
                arrayOf("d"),
                intArrayOf(1),
                listOf("d")
            ),
            Arguments.of(
                arrayOf("e", "a", "b"),
                intArrayOf(0, 0, 1),
                listOf("e", "b")
            ),
            Arguments.of(
                arrayOf("a", "b", "c", "d"),
                intArrayOf(1, 0, 1, 1),
                listOf("a", "b", "c")
            ),
        )
    }

    @Nested
    inner class LongestUnequalAdjacentGroupsSubsequence1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest subsequence`(
            words: Array<String>,
            groups: IntArray,
            expected: List<String>
        ) {
            LongestUnequalAdjacentGroupsSubsequence1Rev1().test(words, groups, expected)
        }
    }
}

private fun LongestUnequalAdjacentGroupsSubsequence1.test(
    words: Array<String>,
    groups: IntArray,
    expected: List<String>
) {
    val actual = getLongestSubsequence(words, groups)
    assertEquals(expected, actual)
}
