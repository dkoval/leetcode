package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.SumOfLeftLeaves.SumOfLeftLeavesBFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SumOfLeftLeavesTest {

    class InputArguments : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                },
                24
            ),
            Arguments.of(
                TreeNode(1),
                0
            ),
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(2)
                },
                0
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4)
                        right = TreeNode(5)
                    }
                    right = TreeNode(3)
                },
                4
            ),
            Arguments.of(
                TreeNode(-9).apply {
                    left = TreeNode(-3).apply {
                        right = TreeNode(4).apply {
                            left = TreeNode(-6)
                        }
                    }
                    right = TreeNode(2).apply {
                        left = TreeNode(4).apply {
                            left = TreeNode(-5)
                        }
                        right = TreeNode(0)
                    }
                },
                -11
            )
        )
    }

    @Nested
    inner class SumOfLeftLeavesDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArguments::class)
        fun `should find the sum of all left leaves in a given binary tree`(root: TreeNode?, expected: Int) {
            SumOfLeftLeavesDFS.test(root, expected)
        }
    }

    @Nested
    inner class SumOfLeftLeavesBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArguments::class)
        fun `should find the sum of all left leaves in a given binary tree`(root: TreeNode?, expected: Int) {
            SumOfLeftLeavesBFS().test(root, expected)
        }
    }
}

private fun SumOfLeftLeaves.test(root: TreeNode?, expected: Int) {
    val actual = sumOfLeftLeaves(root)
    assertEquals(expected, actual)
}
