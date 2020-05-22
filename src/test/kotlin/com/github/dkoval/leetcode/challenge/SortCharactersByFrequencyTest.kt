package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SortCharactersByFrequencyTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("tree", setOf("eert", "eetr")),
            Arguments.of("cccaaa", setOf("cccaaa", "aaaccc")),
            Arguments.of("Aabb", setOf("bbAa", "bbaA"))
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should sort a string decreasing order based on the frequency of characters`(s: String, expected: Set<String>) {
        val actual = SortCharactersByFrequency.frequencySort(s)
        assertThat(actual).isIn(expected)
    }
}