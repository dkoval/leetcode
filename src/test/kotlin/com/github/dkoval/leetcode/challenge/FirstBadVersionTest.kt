package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FirstBadVersionTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(5, 4),
            Arguments.of(1, 1),
            Arguments.of(10, 4)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the first bad version`(n: Int, expected: Int) {
        val actual = FirstBadVersion { version -> version >= expected }.firstBadVersion(n)
        assertEquals(expected, actual)
    }
}