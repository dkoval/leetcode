package com.github.dkoval.leetcode.interview.array

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class GroupAnagramsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("eat", "tea", "tan", "ate", "nat", "bat"),
                listOf(
                    setOf("bat"),
                    setOf("nat", "tan"),
                    setOf("ate", "eat", "tea")
                )
            ),
            Arguments.of(
                arrayOf(""),
                listOf(
                    setOf("")
                )
            ),
            Arguments.of(
                arrayOf("a"),
                listOf(
                    setOf("a")
                )
            )
        )
    }

    @Nested
    inner class GroupAnagramsTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should group anagrams`(strs: Array<String>, expected: List<Set<String>>) {
            GroupAnagramsKt.test(strs, expected)
        }
    }

    @Nested
    inner class GroupAnagramsJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should group anagrams`(strs: Array<String>, expected: List<Set<String>>) {
            GroupAnagramsJava().test(strs, expected)
        }
    }

    private fun GroupAnagrams.test(strs: Array<String>, expected: List<Set<String>>) {
        val actual = groupAnagrams(strs).map { it.toSet() }
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}