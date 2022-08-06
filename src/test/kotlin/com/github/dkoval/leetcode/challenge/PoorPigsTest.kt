package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PoorPigsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(1000, 15, 60, 5),
            Arguments.of(4, 15, 15, 2),
            Arguments.of(4, 15, 30, 2)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum number of pigs needed to figure out which bucket is poisonous within the allotted time`(
        buckets: Int,
        minutesToDie: Int,
        minutesToTest: Int,
        expected: Int
    ) {
        val actual = PoorPigs().poorPigs(buckets, minutesToDie, minutesToTest)
        assertEquals(expected, actual)
    }
}