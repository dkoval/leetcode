package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.BinaryTreePreorderTraversal.BinaryTreePreorderTraversalIterative
import com.github.dkoval.leetcode.challenge.BinaryTreePreorderTraversal.BinaryTreePreorderTraversalRecursive
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BinaryTreePreorderTraversalTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(2).apply {
                        left = TreeNode(3)
                    }
                },
                listOf(1, 2, 3)
            ),
            Arguments.of(
                null,
                emptyList<Int>()
            ),
            Arguments.of(
                TreeNode(1),
                listOf(1)
            )
        )
    }

    @Nested
    inner class BinaryTreePreorderTraversalRecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the preorder traversal of its nodes' values`(root: TreeNode?, expected: List<Int>) {
            BinaryTreePreorderTraversalRecursive().test(root, expected)
        }
    }

    @Nested
    inner class BinaryTreePreorderTraversalIterativeTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the preorder traversal of its nodes' values`(root: TreeNode?, expected: List<Int>) {
            BinaryTreePreorderTraversalIterative().test(root, expected)
        }
    }

    private fun BinaryTreePreorderTraversal.test(root: TreeNode?, expected: List<Int>) {
        val actual = preorderTraversal(root)
        assertEquals(expected, actual)
    }
}