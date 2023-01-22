package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PalindromePartitioning.PalindromePartitioningRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PalindromePartitioningTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "aab",
                listOf(
                    listOf("a", "a", "b"),
                    listOf("aa", "b")
                )
            ),
            Arguments.of(
                "a",
                listOf(
                    listOf("a")
                )
            ),
            Arguments.of(
                "abc",
                listOf(
                    listOf("a", "b", "c")
                )
            )
        )
    }

    @Nested
    inner class PalindromePartitioningRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible palindrome partitioning of s`(s: String, expected: List<List<String>>) {
            PalindromePartitioningRev1().test(s, expected)
        }
    }
}

private fun PalindromePartitioning.test(s: String, expected: List<List<String>>) {
    val actual = partition(s)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
