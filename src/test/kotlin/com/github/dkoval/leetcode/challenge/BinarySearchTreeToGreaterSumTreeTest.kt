package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.BinarySearchTreeToGreaterSumTree.BinarySearchTreeToGreaterSumTreeRev1
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BinarySearchTreeToGreaterSumTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(0)
                        right = TreeNode(2).apply {
                            right = TreeNode(3)
                        }
                    }
                    right = TreeNode(6).apply {
                        left = TreeNode(5)
                        right = TreeNode(7).apply {
                            right = TreeNode(8)
                        }
                    }
                },
                TreeNode(30).apply {
                    left = TreeNode(36).apply {
                        left = TreeNode(36)
                        right = TreeNode(35).apply {
                            right = TreeNode(33)
                        }
                    }
                    right = TreeNode(21).apply {
                        left = TreeNode(26)
                        right = TreeNode(15).apply {
                            right = TreeNode(8)
                        }
                    }
                }
            ),
            Arguments.of(
                TreeNode(0).apply {
                    right = TreeNode(1)
                },
                TreeNode(1).apply {
                    right = TreeNode(1)
                }
            )
        )
    }

    @Nested
    inner class BinarySearchTreeToGreaterSumTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should convert BST to a Greater Tree`(root: TreeNode, expected: TreeNode) {
            BinarySearchTreeToGreaterSumTreeRev1().test(root, expected)
        }
    }
}

private fun BinarySearchTreeToGreaterSumTree.test(root: TreeNode, expected: TreeNode) {
    assertTrue { bstToGst(root).equalsTo(expected) }
}
