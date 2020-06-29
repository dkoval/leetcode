package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class UniquePathsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(3, 2, 3),
            Arguments.of(7, 3, 28)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should count possible unique paths`(m: Int, n: Int, expected: Int) {
        val actual = UniquePaths.uniquePaths(m, n)
        assertEquals(expected, actual)
    }
}