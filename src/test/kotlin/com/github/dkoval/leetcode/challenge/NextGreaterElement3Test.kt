package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NextGreaterElement3Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(12, 21),
            Arguments.of(21, -1),
            Arguments.of(101, 110)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n`(
        n: Int,
        expected: Int
    ) {
        val actual = NextGreaterElement3().nextGreaterElement(n)
        assertEquals(expected, actual)
    }
}