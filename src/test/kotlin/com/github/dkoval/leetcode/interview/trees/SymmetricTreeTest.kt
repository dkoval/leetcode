package com.github.dkoval.leetcode.interview.trees

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SymmetricTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(3)
                        right = TreeNode(4)
                    }
                    right = TreeNode(2).apply {
                        left = TreeNode(4)
                        right = TreeNode(3)
                    }
                },
                true
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        right = TreeNode(3)
                    }
                    right = TreeNode(2).apply {
                        left = TreeNode(3)
                    }
                },
                true
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(3)
                    }
                    right = TreeNode(2).apply {
                        left = TreeNode(3)
                    }
                },
                false
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        right = TreeNode(3)
                    }
                    right = TreeNode(2).apply {
                        right = TreeNode(3)
                    }
                },
                false
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                false
            ),
            Arguments.of(
                TreeNode(1),
                true
            ),
            Arguments.of(
                null,
                true
            )
        )
    }

    @Nested
    inner class SymmetricTreeRecursivelyTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if a given binary tree is symmetric`(root: TreeNode?, expected: Boolean) {
            SymmetricTreeRecursively.test(root, expected)
        }
    }

    @Nested
    inner class SymmetricTreeIterUsingQueueTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if a given binary tree is symmetric`(root: TreeNode?, expected: Boolean) {
            SymmetricTreeIterUsingQueue.test(root, expected)
        }
    }

    private fun SymmetricTree.test(root: TreeNode?, expected: Boolean) {
        val actual = isSymmetric(root)
        assertEquals(expected, actual)
    }
}
