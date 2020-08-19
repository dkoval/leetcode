package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class GoatLatinTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "I speak Goat Latin",
                "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
            ),
            Arguments.of(
                "The quick brown fox jumped over the lazy dog",
                "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the final sentence representing the conversion from S to Goat Latin`(
        S: String,
        expected: String
    ) {
        val actual = GoatLatin.toGoatLatin(S)
        assertEquals(expected, actual)
    }
}