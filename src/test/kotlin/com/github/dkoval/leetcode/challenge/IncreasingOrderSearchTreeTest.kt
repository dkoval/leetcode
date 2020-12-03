package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.IncreasingOrderSearchTree.IncreasingOrderSearchTreeUsingInorderTraversal
import com.github.dkoval.leetcode.challenge.IncreasingOrderSearchTree.IncreasingOrderSearchTreeUsingInorderTraversalWithRelinking
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class IncreasingOrderSearchTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(2).apply {
                            left = TreeNode(1)
                        }
                        right = TreeNode(4)
                    }
                    right = TreeNode(6).apply {
                        right = TreeNode(8).apply {
                            left = TreeNode(7)
                            right = TreeNode(9)
                        }
                    }
                },
                TreeNode(1).apply {
                    right = TreeNode(2).apply {
                        right = TreeNode(3).apply {
                            right = TreeNode(4).apply {
                                right = TreeNode(5).apply {
                                    right = TreeNode(6).apply {
                                        right = TreeNode(7).apply {
                                            right = TreeNode(8).apply {
                                                right = TreeNode(9)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            ),
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(1)
                    right = TreeNode(7)
                },
                TreeNode(1).apply {
                    right = TreeNode(5).apply {
                        right = TreeNode(7)
                    }
                }
            )
        )
    }

    @Nested
    inner class IncreasingOrderSearchTreeUsingInorderTraversalTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child`(
            root: TreeNode,
            expected: TreeNode
        ) {
            IncreasingOrderSearchTreeUsingInorderTraversal().test(root, expected)
        }
    }

    @Nested
    inner class IncreasingOrderSearchTreeUsingInorderTraversalWithRelinkingTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child`(
            root: TreeNode,
            expected: TreeNode
        ) {
            IncreasingOrderSearchTreeUsingInorderTraversalWithRelinking().test(root, expected)
        }
    }

    private fun IncreasingOrderSearchTree.test(root: TreeNode, expected: TreeNode) {
        val actual = increasingBST(root)
        assertTrue(expected.equalsTo(actual))
    }
}