package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class JewelsAndStonesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("aA", "aAAbbbb", 3),
            Arguments.of("z", "ZZ", 0)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should count how many of the stones you have are also jewels`(J: String, S: String, expected: Int) {
        val actual = JewelsAndStones.numJewelsInStones(J, S)
        assertEquals(expected, actual)
    }
}