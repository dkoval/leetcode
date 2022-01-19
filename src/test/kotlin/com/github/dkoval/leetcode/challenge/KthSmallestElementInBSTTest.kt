package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class KthSmallestElementInBSTTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(1).apply {
                        right = TreeNode(2)
                    }
                    right = TreeNode(4)
                },
                1,
                1
            ),
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(2).apply {
                            left = TreeNode(1)
                        }
                        right = TreeNode(4)
                    }
                    right = TreeNode(6)
                },
                3,
                3
            )
        )
    }

    @Nested
    inner class KthSmallestElementInBSTRecursiveInorderTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return k-th smallest element in a BST`(root: TreeNode, k: Int, expected: Int) {
            KthSmallestElementInBSTRecursiveInorder.test(root, k, expected)
        }
    }

    @Nested
    inner class KthSmallestElementInBSTIterativeInorderTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return k-th smallest element in a BST`(root: TreeNode, k: Int, expected: Int) {
            KthSmallestElementInBSTIterativeInorder().test(root, k, expected)
        }
    }

    private fun KthSmallestElementInBST.test(root: TreeNode, k: Int, expected: Int) {
        val actual = kthSmallest(root, k)
        assertEquals(expected, actual)
    }
}