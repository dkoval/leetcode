package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.MinimumDepthOfBinaryTree.MinimumDepthOfBinaryTreeBFS
import com.github.dkoval.leetcode.challenge.MinimumDepthOfBinaryTree.MinimumDepthOfBinaryTreeDFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumDepthOfBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(null, 0),
            Arguments.of(
                TreeNode(1),
                1
            ),
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(2).apply {
                        right = TreeNode(3)
                    }
                },
                3
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(3)
                    }
                },
                3
            ),
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                },
                2
            )
        )
    }

    @Nested
    inner class MinimumDepthOfBinaryTreeDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the minimum depth of binary tree`(root: TreeNode?, expected: Int) {
            MinimumDepthOfBinaryTreeDFS().test(root, expected)
        }
    }

    @Nested
    inner class MinimumDepthOfBinaryTreeBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the minimum depth of binary tree`(root: TreeNode?, expected: Int) {
            MinimumDepthOfBinaryTreeBFS().test(root, expected)
        }
    }
}

private fun MinimumDepthOfBinaryTree.test(root: TreeNode?, expected: Int) {
    val actual = minDepth(root)
    assertEquals(expected, actual)
}
