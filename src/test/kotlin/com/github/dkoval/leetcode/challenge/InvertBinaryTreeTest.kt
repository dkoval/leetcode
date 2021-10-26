package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.InvertBinaryTree.InvertBinaryTreeIterative
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class InvertBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    }
                    right = TreeNode(7).apply {
                        left = TreeNode(6)
                        right = TreeNode(9)
                    }
                },
                TreeNode(4).apply {
                    left = TreeNode(7).apply {
                        left = TreeNode(9)
                        right = TreeNode(6)
                    }
                    right = TreeNode(2).apply {
                        left = TreeNode(3)
                        right = TreeNode(1)
                    }
                }
            ))
    }

    @Nested
    inner class InvertBinaryTreeIterativeTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should invert a binary tree`(root: TreeNode?, expected: TreeNode?) {
            InvertBinaryTreeIterative().test(root, expected)
        }
    }

    @Nested
    inner class InvertBinaryTreeRecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should invert a binary tree`(root: TreeNode?, expected: TreeNode?) {
            InvertBinaryTreeRecursive.test(root, expected)
        }
    }

    private fun InvertBinaryTree.test(root: TreeNode?, expected: TreeNode?) {
        val actual = invertTree(root)
        assertTrue(actual.equalsTo(expected))
    }
}