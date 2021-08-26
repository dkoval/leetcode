package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class VerifyPreorderSerializationOfBinaryTreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("9,3,4,#,#,1,#,#,2,#,6,#,#", true),
            Arguments.of("1,#", false),
            Arguments.of( "9,#,#,1", false)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should verify preorder serialization of a binary tree`(preorder: String, expected: Boolean) {
        val actual = VerifyPreorderSerializationOfBinaryTree().isValidSerialization(preorder)
        assertEquals(expected, actual)
    }
}