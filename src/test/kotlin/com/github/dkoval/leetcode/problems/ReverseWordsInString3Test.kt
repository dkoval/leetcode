package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReverseWordsInString3Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "Let's take LeetCode contest",
                "s'teL ekat edoCteeL tsetnoc"
            ),
            Arguments.of(
                "God Ding",
                "doG gniD"
            ),
            Arguments.of(
                "Bang!",
                "!gnaB"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order`(
        s: String,
        expected: String
    ) {
        val actual = ReverseWordsInString3().reverseWords(s)
        assertEquals(expected, actual)
    }
}