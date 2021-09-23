package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumLengthOfConcatenatedStringWithUniqueCharactersTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                listOf("un", "iq", "ue"),
                4
            ),
            Arguments.of(
                listOf("cha", "r", "act", "ers"),
                6
            ),
            Arguments.of(
                listOf("abcdefghijklmnopqrstuvwxyz"),
                26
            ),
            Arguments.of(
                listOf("yy", "bkhwmpbiisbldzknpm"),
                0
            ),
            Arguments.of(
                listOf(
                    "uiufinyivbmmybj",
                    "bxcvrjtqbdlhyrgwm",
                    "ankxxcqrppojtamqcorbbqmvo",
                    "cca",
                    "mkxsdfjycghecwoilphgan",
                    "fgegnmgebctbm",
                    "euiqnrkkhbmqdemshsznnq",
                    "wxagkaqvqsvgjbtohwpfzw"
                ),
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum possible length of a concatenation of a sub-sequence of arr which have unique characters`(
        arr: List<String>,
        expected: Int
    ) {
        val actual = MaximumLengthOfConcatenatedStringWithUniqueCharacters().maxLength(arr)
        assertEquals(expected, actual)
    }
}