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

internal class IsBinarySearchTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                },
                true
            ),
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(1)
                    right = TreeNode(4).apply {
                        left = TreeNode(3)
                        right = TreeNode(6)
                    }
                },
                false // The root node's value is 5 but its right child's value is 4.
            ),
            Arguments.of(
                TreeNode(1),
                true
            ),
            Arguments.of(
                null,
                true
            ),
            Arguments.of(
                TreeNode(Int.MIN_VALUE),
                true
            ),
            Arguments.of(
                TreeNode(Int.MAX_VALUE),
                true
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(1)
                },
                false
            ),
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(1)
                },
                false
            )
        )
    }

    @Nested
    inner class IsBinarySearchTreeRecursivelyBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if a given tree is a binary search tree (BST)`(root: TreeNode?, expected: Boolean) {
            IsBinarySearchTreeRecursivelyBruteForce.test(root, expected)
        }
    }

    @Nested
    inner class IsBinarySearchTreeRecursivelyWithRangesTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if a given tree is a binary search tree (BST)`(root: TreeNode?, expected: Boolean) {
            IsBinarySearchTreeRecursivelyWithRanges.test(root, expected)
        }
    }

    @Nested
    inner class IsBinarySearchTreeUsingInorderTraversalTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if a given tree is a binary search tree (BST)`(root: TreeNode?, expected: Boolean) {
            IsBinarySearchTreeUsingInorderTraversal.test(root, expected)
        }
    }

    private fun IsBinarySearchTree.test(root: TreeNode?, expected: Boolean) {
        val actual = isValidBST(root)
        assertEquals(expected, actual)
    }
}