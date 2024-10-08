package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.AddOneRowToTree.AddOneRowToTreeRev1
import com.github.dkoval.leetcode.challenge.AddOneRowToTree.AddOneRowToTreeRev2
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AddOneRowToTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(4) {
                    left = TreeNode(2) {
                        left = TreeNode(3)
                        right = TreeNode(1)
                    }
                    right = TreeNode(6) {
                        left = TreeNode(5)
                    }
                },
                1,
                2,
                TreeNode(4) {
                    left = TreeNode(1) {
                        left = TreeNode(2) {
                            left = TreeNode(3)
                            right = TreeNode(1)
                        }
                    }
                    right = TreeNode(1) {
                        right = TreeNode(6) {
                            left = TreeNode(5)
                        }
                    }
                }
            ),
            Arguments.of(
                TreeNode(4) {
                    left = TreeNode(2) {
                        left = TreeNode(3)
                        right = TreeNode(1)
                    }
                },
                1,
                3,
                TreeNode(4) {
                    left = TreeNode(2) {
                        left = TreeNode(1) {
                            left = TreeNode(3)
                        }
                        right = TreeNode(1) {
                            right = TreeNode(1)
                        }
                    }
                }
            ),
            Arguments.of(
                TreeNode(1) {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                1,
                1,
                TreeNode(1) {
                    left = TreeNode(1) {
                        left = TreeNode(2)
                        right = TreeNode(3)
                    }
                }
            ),
            Arguments.of(
                TreeNode(1) {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                1,
                3,
                TreeNode(1) {
                    left = TreeNode(2) {
                        left = TreeNode(1)
                        right = TreeNode(1)
                    }
                    right = TreeNode(3) {
                        left = TreeNode(1)
                        right = TreeNode(1)
                    }
                }
            )
        )
    }

    @Nested
    inner class AddOneRowToTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should add a row of nodes with value val at the given depth`(
            root: TreeNode,
            `val`: Int,
            depth: Int,
            expected: TreeNode
        ) {
            AddOneRowToTreeRev1().test(root, `val`, depth, expected)
        }
    }

    @Nested
    inner class AddOneRowToTreeRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should add a row of nodes with value val at the given depth`(
            root: TreeNode,
            `val`: Int,
            depth: Int,
            expected: TreeNode
        ) {
            AddOneRowToTreeRev2().test(root, `val`, depth, expected)
        }
    }
}

private fun AddOneRowToTree.test(
    root: TreeNode,
    `val`: Int,
    depth: Int,
    expected: TreeNode
) {
    val actual = addOneRow(root, `val`, depth)
    assertTrue(actual.equalsTo(expected))
}
