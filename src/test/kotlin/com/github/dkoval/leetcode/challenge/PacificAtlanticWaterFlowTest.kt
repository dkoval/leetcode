package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PacificAtlanticWaterFlowTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 2, 3, 5),
                    intArrayOf(3, 2, 3, 4, 4),
                    intArrayOf(2, 4, 5, 3, 1),
                    intArrayOf(6, 7, 1, 4, 5),
                    intArrayOf(5, 1, 1, 2, 4)
                ),
                listOf(
                    listOf(0, 4),
                    listOf(1, 3),
                    listOf(1, 4),
                    listOf(2, 2),
                    listOf(3, 0),
                    listOf(3, 1),
                    listOf(4, 0)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean`(
        matrix: Array<IntArray>,
        expected: List<List<Int>>
    ) {
        val actual = PacificAtlanticWaterFlow().pacificAtlantic(matrix)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}