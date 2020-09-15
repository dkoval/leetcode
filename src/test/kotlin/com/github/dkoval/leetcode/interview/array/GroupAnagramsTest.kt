package com.github.dkoval.leetcode.interview.array

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class GroupAnagramsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
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

    @ParameterizedTest
    @MethodSource("input")
    fun `should group anagrams`(strs: Array<String>, expected: List<Set<String>>) {
        val actual = GroupAnagrams.groupAnagrams(strs).map { it.toSet() }
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}