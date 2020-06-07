package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class QueueReconstructionByHeightTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(7, 0),
                    intArrayOf(4, 4),
                    intArrayOf(7, 1),
                    intArrayOf(5, 0),
                    intArrayOf(6, 1),
                    intArrayOf(5, 2)
                ),
                arrayOf(
                    intArrayOf(5, 0),
                    intArrayOf(7, 0),
                    intArrayOf(5, 2),
                    intArrayOf(6, 1),
                    intArrayOf(4, 4),
                    intArrayOf(7, 1)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should reconstruct reconstruct the queue`(people: Array<IntArray>, expected: Array<IntArray>) {
        val actual = QueueReconstructionByHeight.reconstructQueue(people)
        assertArrayEquals(expected, actual)
    }
}