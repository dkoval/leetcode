package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.FlipEquivalentBinaryTrees.FlipEquivalentBinaryTreesRev1
import com.github.dkoval.leetcode.challenge.FlipEquivalentBinaryTrees.FlipEquivalentBinaryTreesRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FlipEquivalentBinaryTreesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1) {
                    left = TreeNode(2) {
                        left = TreeNode(4)
                        right = TreeNode(5) {
                            left = TreeNode(7)
                            right = TreeNode(8)
                        }
                    }
                    right = TreeNode(3) {
                        left = TreeNode(6)
                    }
                },
                TreeNode(1) {
                    left = TreeNode(3) {
                        right = TreeNode(6)
                    }
                    right = TreeNode(2) {
                        left = TreeNode(4)
                        right = TreeNode(5) {
                            left = TreeNode(8)
                            right = TreeNode(7)
                        }
                    }
                },
                true
            ),
            Arguments.of(
                null,
                null,
                true
            ),
            Arguments.of(
                null,
                TreeNode(1),
                false
            ),
            Arguments.of(
                TreeNode(1),
                null,
                false
            )
        )
    }

    @Nested
    inner class FlipEquivalentBinaryTreesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if the two trees are flip equivalent or false otherwise`(
            root1: TreeNode?,
            root2: TreeNode?,
            expected: Boolean
        ) {
            FlipEquivalentBinaryTreesRev1().test(root1, root2, expected)
        }
    }

    @Nested
    inner class FlipEquivalentBinaryTreesRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if the two trees are flip equivalent or false otherwise`(
            root1: TreeNode?,
            root2: TreeNode?,
            expected: Boolean
        ) {
            FlipEquivalentBinaryTreesRev2().test(root1, root2, expected)
        }
    }
}

private fun FlipEquivalentBinaryTrees.test(root1: TreeNode?, root2: TreeNode?, expected: Boolean) {
    val actual = flipEquiv(root1, root2)
    assertEquals(expected, actual)
}
