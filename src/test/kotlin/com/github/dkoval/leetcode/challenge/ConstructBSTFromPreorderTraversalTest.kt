package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import com.github.dkoval.leetcode.problems.ConstructBSTFromPreorderTraversalJava
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ConstructBSTFromPreorderTraversalTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(),
                null
            ),
            Arguments.of(
                intArrayOf(8, 5, 1, 7, 10, 12),
                TreeNode(8).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(1)
                        right = TreeNode(7)
                    }
                    right = TreeNode(10).apply {
                        right = TreeNode(12)
                    }
                }
            )
        )
    }

    @Nested
    inner class ConstructBSTFromPreorderTraversalNaiveKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the root node of a BST that matches the given preorder traversal`(
            preorder: IntArray,
            expected: TreeNode?
        ) {
            ConstructBSTFromPreorderTraversalNaiveKt.test(preorder, expected)
        }
    }

    @Nested
    inner class ConstructBSTFromPreorderTraversalKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the root node of a BST that matches the given preorder traversal`(
            preorder: IntArray,
            expected: TreeNode?
        ) {
            ConstructBSTFromPreorderTraversalKt.test(preorder, expected)
        }
    }

    @Nested
    inner class ConstructBSTFromPreorderTraversalJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the root node of a BST that matches the given preorder traversal`(
            preorder: IntArray,
            expected: TreeNode?
        ) {
            ConstructBSTFromPreorderTraversalJava().test(preorder, expected)
        }
    }

    private fun ConstructBSTFromPreorderTraversal.test(
        preorder: IntArray,
        expected: TreeNode?,
    ) {
        val actual = bstFromPreorder(preorder)
        assertTrue(expected.equalsTo(actual))
    }
}