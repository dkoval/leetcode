package com.github.dkoval.leetcode.interview.others

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class PascalTriangleTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                1,
                listOf(
                    listOf(1)
                )
            ),
            Arguments.of(
                2,
                listOf(
                    listOf(1),
                    listOf(1, 1)
                )
            ),
            Arguments.of(
                5,
                listOf(
                    listOf(1),
                    listOf(1, 1),
                    listOf(1, 2, 1),
                    listOf(1, 3, 3, 1),
                    listOf(1, 4, 6, 4, 1)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return Pascal's triangle`(numRows: Int, expected: List<List<Int>>) {
        val actual = PascalTriangle().generate(numRows)
        assertThat(actual).containsExactlyElementsOf(expected)
    }
}