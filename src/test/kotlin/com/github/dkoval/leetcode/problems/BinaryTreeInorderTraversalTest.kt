package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BinaryTreeInorderTraversalTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(2).apply {
                        left = TreeNode(3)
                    }
                },
                listOf(1, 3, 2)
            )
        )
    }

    @Nested
    inner class BinaryTreeInorderTraversalRecursivelyTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the inorder traversal of a binary tree's values`(root: TreeNode, expected: List<Int>) {
            BinaryTreeInorderTraversalRecursively.test(root, expected)
        }
    }

    @Nested
    inner class BinaryTreeInorderTraversalIterUsingStackTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the inorder traversal of a binary tree's values`(root: TreeNode, expected: List<Int>) {
            BinaryTreeInorderTraversalIterUsingStack.test(root, expected)
        }
    }

    private fun BinaryTreeInorderTraversal.test(root: TreeNode?, expected: List<Int>) {
        val actual = inorderTraversal(root)
        assertEquals(expected, actual)
    }
}