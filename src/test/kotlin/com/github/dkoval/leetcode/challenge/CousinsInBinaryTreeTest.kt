package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.CousinsInBinaryTree.CousinsInBinaryTreeBFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CousinsInBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4)
                    }
                    right = TreeNode(3)
                },
                4, 3, false
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        right = TreeNode(4)
                    }
                    right = TreeNode(3).apply {
                        right = TreeNode(5)
                    }
                },
                5, 4, true
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        right = TreeNode(4)
                    }
                    right = TreeNode(3)
                },
                2, 3, false
            )
        )
    }

    @Nested
    inner class CousinsInBinaryTreeDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if 2 nodes are cousins in a binary tree`(root: TreeNode?, x: Int, y: Int, expected: Boolean) {
            CousinsInBinaryTreeDFS.test(root, x, y, expected)
        }
    }

    @Nested
    inner class CousinsInBinaryTreeBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if 2 nodes are cousins in a binary tree`(root: TreeNode?, x: Int, y: Int, expected: Boolean) {
            CousinsInBinaryTreeBFS().test(root, x, y, expected)
        }
    }

    private fun CousinsInBinaryTree.test(root: TreeNode?, x: Int, y: Int, expected: Boolean) {
        val actual = isCousins(root, x, y)
        assertEquals(expected, actual)
    }
}