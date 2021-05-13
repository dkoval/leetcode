package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class AmbiguousCoordinatesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "(123)",
                listOf("(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)")
            ),
            Arguments.of(
                "(00011)",
                listOf("(0.001, 1)", "(0, 0.011)")
            ),
            Arguments.of(
                "(0123)",
                listOf("(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)")
            ),
            Arguments.of(
                "(100)",
                listOf("(10, 0)")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return a list of strings representing all possibilities for what our original coordinates could have been`(
        s: String,
        expected: List<String>
    ) {
        val actual = AmbiguousCoordinates().ambiguousCoordinates(s)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}