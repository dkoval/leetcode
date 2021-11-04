package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import com.github.dkoval.leetcode.problems.MergeTwoBinaryTrees.MergeTwoBinaryTreesRecursive
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MergeTwoBinaryTreesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(5)
                    }
                    right = TreeNode(2)
                },
                TreeNode(2).apply {
                    left = TreeNode(1).apply {
                        right = TreeNode(4)
                    }
                    right = TreeNode(3).apply {
                        right = TreeNode(7)
                    }
                },
                TreeNode(3).apply {
                    left = TreeNode(4).apply {
                        left = TreeNode(5)
                        right = TreeNode(4)
                    }
                    right = TreeNode(5).apply {
                        right = TreeNode(7)
                    }
                }
            ),
            Arguments.of(
                TreeNode(1),
                TreeNode(1).apply {
                    left = TreeNode(2)
                },
                TreeNode(2).apply {
                    left = TreeNode(2)
                }
            ),
            Arguments.of(
                TreeNode(1),
                TreeNode(1).apply {
                    right = TreeNode(2)
                },
                TreeNode(2).apply {
                    right = TreeNode(2)
                }
            )
        )
    }

    @Nested
    inner class MergeTwoBinaryTreesRecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the merged tree`(root1: TreeNode?, root2: TreeNode?, expected: TreeNode?) {
            val actual = MergeTwoBinaryTreesRecursive().mergeTrees(root1, root2)
            assertTrue { expected.equalsTo(actual) }
        }
    }
}