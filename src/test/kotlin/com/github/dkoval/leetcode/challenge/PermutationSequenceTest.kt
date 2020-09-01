package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PermutationSequenceTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(3, 3, "213"),
            Arguments.of(4, 9, "2314")
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find kth permutation sequence`(n: Int, k: Int, expected: String) {
        val actual = PermutationSequence.getPermutation(n, k)
        assertEquals(expected, actual)
    }
}