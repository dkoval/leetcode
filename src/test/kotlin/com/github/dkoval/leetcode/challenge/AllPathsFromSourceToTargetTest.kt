package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class AllPathsFromSourceToTargetTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3),
                    intArrayOf(3),
                    intArrayOf()
                ),
                listOf(
                    listOf(0, 1, 3),
                    listOf(0, 2, 3)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(4, 3, 1),
                    intArrayOf(3, 2, 4),
                    intArrayOf(3),
                    intArrayOf(4),
                    intArrayOf()
                ),
                listOf(
                    listOf(0, 4),
                    listOf(0, 3, 4),
                    listOf(0, 1, 3, 4),
                    listOf(0, 1, 2, 3, 4),
                    listOf(0, 1, 4)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(2),
                    intArrayOf(3),
                    intArrayOf()
                ),
                listOf(
                    listOf(0, 1, 2, 3),
                    listOf(0, 2, 3),
                    listOf(0, 3)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2),
                    intArrayOf(3),
                    intArrayOf()
                ),
                listOf(
                    listOf(0, 1, 2, 3),
                    listOf(0, 3)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find all paths from source to target`(graph: Array<IntArray>, expected: List<List<Int>>) {
        val actual = AllPathsFromSourceToTarget.allPathsSourceTarget(graph)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}