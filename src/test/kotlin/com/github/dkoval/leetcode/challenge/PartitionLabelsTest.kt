package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PartitionLabelsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "ababcbacadefegdehijhklij",
                listOf(9, 7, 8)
            ),
            Arguments.of(
                "eccbbbbdec",
                listOf(10)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should partition labels`(S: String, expected: List<Int>) {
        val actual = PartitionLabels.partitionLabels(S)
        assertEquals(expected, actual)
    }
}