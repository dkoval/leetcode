package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.KthLargestSumInBinaryTree.KthLargestSumInBinaryTreeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class KthLargestSumInBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(5) {
                    left = TreeNode(8) {
                        left = TreeNode(2) {
                            left = TreeNode(4)
                            right = TreeNode(6)
                        }
                        right = TreeNode(1)
                    }
                    right = TreeNode(9) {
                        left = TreeNode(3)
                        right = TreeNode(7)
                    }
                },
                2,
                13L
            ),
            Arguments.of(
                TreeNode(1) {
                    left = TreeNode(2) {
                        left = TreeNode(3)
                    }
                },
                1,
                3L
            )
        )
    }

    @Nested
    inner class KthLargestSumInBinaryTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the kth largest level sum in the tree`(root: TreeNode, k: Int, expected: Long) {
            KthLargestSumInBinaryTreeRev1().test(root, k, expected)
        }
    }
}

private fun KthLargestSumInBinaryTree.test(root: TreeNode, k: Int, expected: Long) {
    val actual = kthLargestLevelSum(root, k)
    assertEquals(expected, actual)
}
