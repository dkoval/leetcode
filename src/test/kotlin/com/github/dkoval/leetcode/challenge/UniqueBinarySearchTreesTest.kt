package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class UniqueBinarySearchTreesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(3, 5)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should count the number of structurally unique BSTs`(n: Int, expected: Int) {
        val actual = UniqueBinarySearchTrees.numTrees(n)
        assertEquals(expected, actual)
    }
}