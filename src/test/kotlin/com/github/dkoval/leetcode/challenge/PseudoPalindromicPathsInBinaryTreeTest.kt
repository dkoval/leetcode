package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.PseudoPalindromicPathsInBinaryTree.PseudoPalindromicPathsInBinaryTreeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PseudoPalindromicPathsInBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(3)
                        right = TreeNode(1)
                    }
                    right = TreeNode(1).apply {
                        right = TreeNode(1)
                    }
                },
                2
            ),
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(1)
                        right = TreeNode(3).apply {
                            right = TreeNode(1)
                        }
                    }
                    right = TreeNode(1)
                },
                1
            ),
            Arguments.of(
                TreeNode(9),
                1
            )
        )
    }

    @Nested
    inner class PseudoPalindromicPathsInBinaryTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of pseudo-palindromic paths going from the root node to leaf nodes`(
            root: TreeNode,
            expected: Int
        ) {
            PseudoPalindromicPathsInBinaryTreeRev1().test(root, expected)
        }
    }
}

private fun PseudoPalindromicPathsInBinaryTree.test(root: TreeNode, expected: Int) {
    val actual = pseudoPalindromicPaths(root)
    assertEquals(expected, actual)
}
