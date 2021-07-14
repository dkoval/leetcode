package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CustomSortStringTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "cba",
                "abcd",
                "cbad"
            ),
            Arguments.of(
                "anfgz",
                "gzf",
                "fgz"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should permute the characters of str so that they match the order that order was sorted`(
        order: String,
        str: String,
        expected: String
    ) {
        val actual = CustomSortString().customSortString(order, str)
        assertEquals(expected, actual)
    }
}