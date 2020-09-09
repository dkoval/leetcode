package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CompareVersionNumbersTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "0.1",
                "1.1",
                -1
            ),
            Arguments.of(
                "1.0.1",
                "1",
                1
            ),
            Arguments.of(
                "7.5.2.4",
                "7.5.3",
                -1
            ),
            Arguments.of(
                "1.01",
                "1.001",
                0 // Ignoring leading zeroes, both “01” and “001" represent the same number “1”
            ),
            Arguments.of(
                "1.0",
                "1.0.0",
                0 // The first version number does not have a third level revision number, which means its third level revision number is default to "0"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should compare version`(version1: String, version2: String, expected: Int) {
        val actual = CompareVersionNumbers.compareVersion(version1, version2)
        assertEquals(expected, actual)
    }
}