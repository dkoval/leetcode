package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.BinaryTreeLevelOrderTraversal.BinaryTreeLevelOrderTraversalIter
import com.github.dkoval.leetcode.challenge.BinaryTreeLevelOrderTraversal.BinaryTreeLevelOrderTraversalRecursive
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BinaryTreeLevelOrderTraversalTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                },
                listOf(
                    listOf(3),
                    listOf(9, 20),
                    listOf(15, 7)
                )
            ),
            Arguments.of(
                TreeNode(1),
                listOf(
                    listOf(1)
                )
            ),
            Arguments.of(
                null,
                listOf<List<Int>>()
            )
        )
    }

    @Nested
    inner class BinaryTreeLevelOrderTraversalIterTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the level order traversal of binary tree node values`(
            root: TreeNode?,
            expected: List<List<Int>>
        ) {
            BinaryTreeLevelOrderTraversalIter().test(root, expected)
        }
    }

    @Nested
    inner class BinaryTreeLevelOrderTraversalRecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the level order traversal of binary tree node values`(
            root: TreeNode?,
            expected: List<List<Int>>
        ) {
            BinaryTreeLevelOrderTraversalRecursive().test(root, expected)
        }
    }

    private fun BinaryTreeLevelOrderTraversal.test(root: TreeNode?, expected: List<List<Int>>) {
        val actual = levelOrder(root)
        assertThat(actual).containsExactlyElementsOf(expected)
    }
}