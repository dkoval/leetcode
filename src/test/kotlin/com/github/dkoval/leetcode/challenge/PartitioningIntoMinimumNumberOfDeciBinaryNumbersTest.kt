package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PartitioningIntoMinimumNumberOfDeciBinaryNumbersTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "32",
                3
            ),
            Arguments.of(
                "82734",
                8
            ),
            Arguments.of(
                "27346209830709182346",
                9
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum number of positive deci-binary numbers needed so that they sum up to n`(
        n: String,
        expected: Int
    ) {
        val actual = PartitioningIntoMinimumNumberOfDeciBinaryNumbers().minPartitions(n)
        assertEquals(expected, actual)
    }
}