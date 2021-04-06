package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumOperationsToMakeArrayEqualTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(3, 2),
            Arguments.of(6, 9)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum number of operations needed to make all the elements of arr equal`(
        n: Int,
        expected: Int
    ) {
        val actual = MinimumOperationsToMakeArrayEqual().minOperations(n)
        assertEquals(expected, actual)
    }
}