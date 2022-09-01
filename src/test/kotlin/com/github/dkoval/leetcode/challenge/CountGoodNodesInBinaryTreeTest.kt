package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.CountGoodNodesInBinaryTree.CountGoodNodesInBinaryTreeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountGoodNodesInBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(3)
                    }
                    right = TreeNode(4).apply {
                        left = TreeNode(1)
                        right = TreeNode(5)
                    }
                },
                4
            ),
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(4)
                        right = TreeNode(2)
                    }
                },
                3
            ),
            Arguments.of(
                TreeNode(1),
                1
            )
        )
    }

    @Nested
    inner class CountGoodNodesInBinaryTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of good nodes in a binary tree`(root: TreeNode, expected: Int) {
            CountGoodNodesInBinaryTreeRev1().test(root, expected)
        }
    }

    private fun CountGoodNodesInBinaryTree.test(root: TreeNode, expected: Int) {
        val actual = goodNodes(root)
        assertEquals(expected, actual)
    }
}