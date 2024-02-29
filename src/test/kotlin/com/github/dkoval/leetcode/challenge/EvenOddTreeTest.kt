package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.EvenOddTree.EvenOddTreeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class EvenOddTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(10).apply {
                        left = TreeNode(3).apply {
                            left = TreeNode(12)
                            right = TreeNode(8)
                        }
                    }
                    right = TreeNode(4).apply {
                        left = TreeNode(7).apply {
                            left = TreeNode(6)
                        }
                        right = TreeNode(9).apply {
                            right = TreeNode(2)
                        }
                    }
                }
            ),
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(4).apply {
                        left = TreeNode(3)
                        right = TreeNode(3)
                    }
                    right = TreeNode(2).apply {
                        left = TreeNode(7)
                    }
                }
            ),
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(9).apply {
                        left = TreeNode(3)
                        right = TreeNode(5)
                    }
                    right = TreeNode(1).apply {
                        left = TreeNode(7)
                    }
                }
            )
        )
    }

    @Nested
    inner class EvenOddTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if the binary tree is Even-Odd, otherwise return false`(
            root: TreeNode,
            expected: Boolean
        ) {
            EvenOddTreeRev1().test(root, expected)
        }
    }
}

private fun EvenOddTree.test(root: TreeNode, expected: Boolean) {
    val actual = isEvenOddTree(root)
    assertEquals(expected, actual)
}
