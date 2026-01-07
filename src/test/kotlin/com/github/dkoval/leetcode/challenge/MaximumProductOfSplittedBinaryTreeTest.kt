package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.MaximumProductOfSplittedBinaryTree.MaximumProductOfSplittedBinaryTreeRev1
import com.github.dkoval.leetcode.challenge.MaximumProductOfSplittedBinaryTree.MaximumProductOfSplittedBinaryTreeRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumProductOfSplittedBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4)
                        right = TreeNode(5)
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(6)
                    }
                },
                110
            ),
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(2).apply {
                        left = TreeNode(3)
                        right = TreeNode(4).apply {
                            left = TreeNode(5)
                            right = TreeNode(6)
                        }
                    }
                },
                90
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(1)
                },
                1
            )
        )
    }

    @Nested
    inner class MaximumProductOfSplittedBinaryTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum product of the sums of the two subtrees`(root: TreeNode?, expected: Int) {
            MaximumProductOfSplittedBinaryTreeRev1().test(root, expected)
        }
    }

    @Nested
    inner class MaximumProductOfSplittedBinaryTreeRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum product of the sums of the two subtrees`(root: TreeNode?, expected: Int) {
            MaximumProductOfSplittedBinaryTreeRev2().test(root, expected)
        }
    }
}

private fun MaximumProductOfSplittedBinaryTree.test(root: TreeNode?, expected: Int) {
    val actual = maxProduct(root)
    assertEquals(expected, actual)
}
