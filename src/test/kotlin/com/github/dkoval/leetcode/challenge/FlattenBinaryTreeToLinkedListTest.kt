package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Condition
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FlattenBinaryTreeToLinkedListTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(

            ),
            Arguments.of(

            ),
            Arguments.of(

            ),
            Arguments.of(

            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should flatten a binary tree into a linked list`(root: TreeNode?, expected: TreeNode?) {
        FlattenBinaryTreeToLinkedList().flatten(root)
        assertThat(root).`is`(Condition({ actual -> expected.equalsTo(actual) }, "treeNode"))
    }
}