package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.MaximumLevelSumOfBinaryTree.MaximumLevelSumOfBinaryTreeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumLevelSumOfBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(7).apply {
                        left = TreeNode(7)
                        right = TreeNode(-8)
                    }
                    right = TreeNode(0)
                },
                2
            ),
            Arguments.of(
                TreeNode(989).apply {
                    right = TreeNode(10250).apply {
                        left = TreeNode(98693)
                        right = TreeNode(-89388).apply {
                            right = TreeNode(-32127)
                        }
                    }
                },
                2
            )
        )
    }

    @Nested
    inner class MaximumLevelSumOfBinaryTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the smallest level x such that the sum of all the values of nodes at level x is maximal`(
            root: TreeNode,
            expected: Int
        ) {
            MaximumLevelSumOfBinaryTreeRev1().test(root, expected)
        }
    }
}

private fun MaximumLevelSumOfBinaryTree.test(root: TreeNode, expected: Int) {
    val actual = maxLevelSum(root)
    assertEquals(expected, actual)
}
