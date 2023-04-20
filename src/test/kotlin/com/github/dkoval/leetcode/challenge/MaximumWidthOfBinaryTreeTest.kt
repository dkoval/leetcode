package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.MaximumWidthOfBinaryTree.MaximumWidthOfBinaryTreeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumWidthOfBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(5)
                        right = TreeNode(3)
                    }
                    right = TreeNode(2).apply {
                        right = TreeNode(9)
                    }
                },
                4
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(5)
                        right = TreeNode(3)
                    }
                },
                2
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(5)
                    }
                    right = TreeNode(2)
                },
                2
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(5).apply {
                            left = TreeNode(6)
                        }
                    }
                    right = TreeNode(2).apply {
                        right = TreeNode(9).apply {
                            right = TreeNode(7)
                        }
                    }
                },
                8
            )
        )
    }

    @Nested
    inner class MaximumWidthOfBinaryTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should calculate the maximum width of a binary tree`(root: TreeNode?, expected: Int) {
            MaximumWidthOfBinaryTreeRev1().test(root, expected)
        }
    }

    @Nested
    inner class MaximumWidthOfBinaryTreeKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should calculate the maximum width of a binary tree`(root: TreeNode?, expected: Int) {
            MaximumWidthOfBinaryTreeKt.test(root, expected)
        }
    }
}

private fun MaximumWidthOfBinaryTree.test(root: TreeNode?, expected: Int) {
    val actual = widthOfBinaryTree(root)
    assertEquals(expected, actual)
}
