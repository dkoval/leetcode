package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.DeleteLeavesWithGivenValue.DeleteLeavesWithGivenValueRev1
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DeleteLeavesWithGivenValueTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(2)
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(2)
                        right = TreeNode(4)
                    }
                },
                2,
                TreeNode(1).apply {
                    right = TreeNode(3).apply {
                        right = TreeNode(4)
                    }
                }
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(3)
                        right = TreeNode(2)
                    }
                    right = TreeNode(3)
                },
                3,
                TreeNode(1).apply {
                    left = TreeNode(3).apply {
                        right = TreeNode(2)
                    }
                }
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(2).apply {
                            left = TreeNode(2)
                        }
                    }
                },
                2,
                TreeNode(1)
            )
        )
    }

    @Nested
    inner class DeleteLeavesWithGivenValueRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should delete all the leaf nodes with value target`(root: TreeNode, target: Int, expected: TreeNode) {
            DeleteLeavesWithGivenValueRev1().test(root, target, expected)
        }
    }
}

private fun DeleteLeavesWithGivenValue.test(root: TreeNode, target: Int, expected: TreeNode) {
    assertTrue {
        val actual = removeLeafNodes(root, target)
        actual.equalsTo(expected)
    }
}
