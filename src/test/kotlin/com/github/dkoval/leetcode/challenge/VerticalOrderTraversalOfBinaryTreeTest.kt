package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.VerticalOrderTraversalOfBinaryTree.VerticalOrderTraversalOfBinaryTreeRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class VerticalOrderTraversalOfBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                },
                listOf(
                    listOf(9),
                    listOf(3, 15),
                    listOf(20),
                    listOf(7)
                )
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4)
                        right = TreeNode(5)
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(6)
                        right = TreeNode(7)
                    }
                },
                listOf(
                    listOf(4),
                    listOf(2),
                    listOf(1, 5, 6),
                    listOf(3),
                    listOf(7)
                )
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4)
                        right = TreeNode(6)
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(5)
                        right = TreeNode(7)
                    }
                },
                listOf(
                    listOf(4),
                    listOf(2),
                    listOf(1, 5, 6),
                    listOf(3),
                    listOf(7)
                )
            ),
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(0)
                        right = TreeNode(2)
                    }
                    right = TreeNode(4).apply {
                        left = TreeNode(2)
                    }
                },
                listOf(
                    listOf(0),
                    listOf(1),
                    listOf(3, 2, 2),
                    listOf(4)
                )
            )
        )
    }

    @Nested
    inner class VerticalOrderTraversalOfBinaryTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the vertical order traversal of its nodes values`(
            root: TreeNode,
            expected: List<List<Int>>
        ) {
            VerticalOrderTraversalOfBinaryTreeRev1.test(root, expected)
        }
    }

    @Nested
    inner class VerticalOrderTraversalOfBinaryTreeRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the vertical order traversal of its nodes values`(
            root: TreeNode,
            expected: List<List<Int>>
        ) {
            VerticalOrderTraversalOfBinaryTreeRev2().test(root, expected)
        }
    }

    private fun VerticalOrderTraversalOfBinaryTree.test(root: TreeNode, expected: List<List<Int>>) {
        val actual = verticalTraversal(root)
        assertEquals(expected, actual)
    }
}