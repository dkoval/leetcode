package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.MinimumDistanceBetweenBSTNodes.MinimumDistanceBetweenBSTNodesUsingInorderTraversal
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumDistanceBetweenBSTNodesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    }
                    right = TreeNode(6)
                },
                1
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(0)
                    right = TreeNode(48).apply {
                        left = TreeNode(12)
                        right = TreeNode(49)
                    }
                },
                1
            ),
            Arguments.of(
                TreeNode(27).apply {
                    right = TreeNode(34).apply {
                        right = TreeNode(58).apply {
                            left = TreeNode(50).apply {
                                left = TreeNode(44)
                            }
                        }
                    }
                },
                6
            ),
        )
    }

    @Nested
    inner class MinimumDistanceBetweenBSTNodesUsingInorderTraversalTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum difference between the values of any two different nodes in the tree`(
            root: TreeNode,
            expected: Int
        ) {
            MinimumDistanceBetweenBSTNodesUsingInorderTraversal().test(root, expected)
        }
    }
}

private fun MinimumDistanceBetweenBSTNodes.test(root: TreeNode, expected: Int) {
    val actual = minDiffInBST(root)
    assertEquals(expected, actual)
}
