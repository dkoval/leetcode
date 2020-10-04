package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.problems.BalancedBinaryTreeJava.BalancedBinaryTreeNaiveJava
import com.github.dkoval.leetcode.problems.BalancedBinaryTreeJava.BalancedBinaryTreeRecursiveJava
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BalancedBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                },
                true
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(3).apply {
                            left = TreeNode(4)
                            right = TreeNode(4)
                        }
                        right = TreeNode(3)
                    }
                    right = TreeNode(2)
                },
                false
            )
        )
    }

    @Nested
    inner class BalancedBinaryTreeNaiveJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check whether binary tree is balanced`(root: TreeNode?, expected: Boolean) {
            BalancedBinaryTreeNaiveJava().test(root, expected)
        }
    }

    @Nested
    inner class BalancedBinaryTreeRecursiveJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check whether binary tree is balanced`(root: TreeNode?, expected: Boolean) {
            BalancedBinaryTreeRecursiveJava().test(root, expected)
        }
    }

    private fun BalancedBinaryTreeJava.test(root: TreeNode?, expected: Boolean) {
        val actual = isBalanced(root);
        assertEquals(expected, actual)
    }
}