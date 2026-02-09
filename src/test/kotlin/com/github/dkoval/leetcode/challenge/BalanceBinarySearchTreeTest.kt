package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.BalanceBinarySearchTree.BalanceBinarySearchTreeRev1
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class BalanceBinarySearchTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(2).apply {
                        right = TreeNode(3).apply {
                            right = TreeNode(4)
                        }
                    }
                },
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3).apply {
                        right = TreeNode(4)
                    }
                }
            ),
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                },
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                }
            )
        )
    }

    @Nested
    inner class BalanceBinarySearchTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a balanced binary search tree with the same node values`(
            root: TreeNode,
            expected: TreeNode
        ) {
            BalanceBinarySearchTreeRev1().test(root, expected)
        }
    }
}

private fun BalanceBinarySearchTree.test(root: TreeNode, expected: TreeNode) {
    assertTrue { balanceBST(root).equalsTo(expected) }
}
