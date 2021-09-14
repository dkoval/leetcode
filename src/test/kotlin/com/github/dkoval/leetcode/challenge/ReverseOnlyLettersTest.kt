package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReverseOnlyLettersTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("ab-cd", "dc-ba"),
            Arguments.of("a-bC-dEf-ghIj", "j-Ih-gfE-dCba"),
            Arguments.of("Test1ng-Leet=code-Q!", "Qedo1ct-eeLg=ntse-T!"),
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should reverse letters only`(s: String, expected: String) {
        val actual = ReverseOnlyLetters().reverseOnlyLetters(s)
        assertEquals(expected, actual)
    }
}