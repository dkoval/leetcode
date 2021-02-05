package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SimplifyPathTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("/home/", "/home"),
            Arguments.of("/../", "/"),
            Arguments.of("/home//foo/", "/home/foo"),
            Arguments.of("/a/./b/../../c/", "/c"),
            Arguments.of("/../", "/"),
            Arguments.of("/../../", "/")
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the simplified canonical path`(path: String, expected: String) {
        val actual = SimplifyPath().simplifyPath(path)
        assertEquals(expected, actual)
    }
}