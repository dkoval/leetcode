package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ValidTriangleNumberTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(2, 2, 3, 4),
                3
            ),
            Arguments.of(
                intArrayOf(4, 2, 3, 4),
                4
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of triplets chosen from the array that can make triangles`(
        nums: IntArray,
        expected: Int
    ) {
        val actual = ValidTriangleNumber().triangleNumber(nums)
        assertEquals(expected, actual)
    }
}