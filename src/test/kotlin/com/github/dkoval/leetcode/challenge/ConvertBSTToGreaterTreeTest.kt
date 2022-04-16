package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.ConvertBSTToGreaterTree.*
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ConvertBSTToGreaterTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(0)
                        right = TreeNode(2).apply {
                            right = TreeNode(3)
                        }
                    }
                    right = TreeNode(6).apply {
                        left = TreeNode(5)
                        right = TreeNode(7).apply {
                            right = TreeNode(8)
                        }
                    }
                },
                TreeNode(30).apply {
                    left = TreeNode(36).apply {
                        left = TreeNode(36)
                        right = TreeNode(35).apply {
                            right = TreeNode(33)
                        }
                    }
                    right = TreeNode(21).apply {
                        left = TreeNode(26)
                        right = TreeNode(15).apply {
                            right = TreeNode(8)
                        }
                    }
                }
            ),
            Arguments.of(
                TreeNode(0).apply {
                    right = TreeNode(1)
                },
                TreeNode(1).apply {
                    right = TreeNode(1)
                }
            )
        )
    }

    @Nested
    inner class ConvertBSTToGreaterTreeWithRecursiveReverseInorderTraversalTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should convert a BST a Greater Tree`(root: TreeNode?, expected: TreeNode?) {
            ConvertBSTToGreaterTreeWithRecursiveReverseInorderTraversal().test(root, expected)
        }
    }

    @Nested
    inner class ConvertBSTToGreaterTreeWithStackForReverseInorderTraversalTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should convert a BST a Greater Tree`(root: TreeNode?, expected: TreeNode?) {
            ConvertBSTToGreaterTreeWithStackForReverseInorderTraversal().test(root, expected)
        }
    }

    @Nested
    inner class ConvertBSTToGreaterTreeWithReverseMorrisInorderTraversalTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should convert a BST a Greater Tree`(root: TreeNode?, expected: TreeNode?) {
            ConvertBSTToGreaterTreeWithReverseMorrisInorderTraversal().test(root, expected)
        }
    }

    private fun ConvertBSTToGreaterTree.test(root: TreeNode?, expected: TreeNode?) {
        val actual = convertBST(root)
        assertTrue(expected.equalsTo(actual))
    }
}