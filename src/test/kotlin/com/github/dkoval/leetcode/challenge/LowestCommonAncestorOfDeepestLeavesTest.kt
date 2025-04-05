package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.LowestCommonAncestorOfDeepestLeaves.LowestCommonAncestorOfDeepestLeavesRev1
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LowestCommonAncestorOfDeepestLeavesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(3) {
                    left = TreeNode(5) {
                        left = TreeNode(6)
                        right = TreeNode(2) {
                            left = TreeNode(7)
                            right = TreeNode(4)
                        }
                    }
                    right = TreeNode(1) {
                        left = TreeNode(0)
                        right = TreeNode(8)
                    }
                },
                TreeNode(2) {
                    left = TreeNode(7)
                    right = TreeNode(4)
                }
            ),
            Arguments.of(
                TreeNode(1),
                TreeNode(1)
            ),
            Arguments.of(
                TreeNode(0) {
                    left = TreeNode(1) {
                        right = TreeNode(2)
                    }
                    right = TreeNode(3)
                },
                TreeNode(2)
            )
        )
    }

    @Nested
    inner class LowestCommonAncestorOfDeepestLeavesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the lowest common ancestor of deepest leaves`(
            root: TreeNode,
            expected: TreeNode
        ) {
            LowestCommonAncestorOfDeepestLeavesRev1().test(root, expected)
        }
    }
}

private fun LowestCommonAncestorOfDeepestLeaves.test(root: TreeNode, expected: TreeNode) {
    assertTrue { lcaDeepestLeaves(root).equalsTo(expected) }
}
