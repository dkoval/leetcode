package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.CheckCompletenessOfBinaryTree.CheckCompletenessOfBinaryTreeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CheckCompletenessOfBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4)
                        right = TreeNode(5)
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(6)
                    }
                },
                true
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4)
                        right = TreeNode(5)
                    }
                    right = TreeNode(3).apply {
                        right = TreeNode(7)
                    }
                },
                false
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(5)
                    }
                    right = TreeNode(3)
                },
                true
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(5)
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(7)
                        right = TreeNode(8)
                    }
                },
                false
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4).apply {
                            left = TreeNode(8).apply {
                                left = TreeNode(15)
                            }
                            right = TreeNode(9)
                        }
                        right = TreeNode(5).apply {
                            left = TreeNode(10)
                            right = TreeNode(11)
                        }
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(6).apply {
                            left = TreeNode(12)
                            right = TreeNode(13)
                        }
                        right = TreeNode(7)
                    }
                },
                false
            )
        )
    }

    @Nested
    inner class CheckCompletenessOfBinaryTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine if it is a complete binary tree`(root: TreeNode, expected: Boolean) {
            CheckCompletenessOfBinaryTreeRev1().test(root, expected)
        }
    }
}

private fun CheckCompletenessOfBinaryTree.test(root: TreeNode, expected: Boolean) {
    val actual = isCompleteTree(root)
    assertEquals(expected, actual)
}
