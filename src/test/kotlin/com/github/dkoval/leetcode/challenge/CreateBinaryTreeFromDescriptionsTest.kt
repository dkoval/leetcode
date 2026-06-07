package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.CreateBinaryTreeFromDescriptions.CreateBinaryTreeFromDescriptionsRev1
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class CreateBinaryTreeFromDescriptionsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(20, 15, 1),
                    intArrayOf(20, 17, 0),
                    intArrayOf(50, 20, 1),
                    intArrayOf(50, 80, 0),
                    intArrayOf(80, 19, 1)
                ),
                TreeNode(50) {
                    left = TreeNode(20) {
                        left = TreeNode(15)
                        right = TreeNode(17)
                    }
                    right = TreeNode(80) {
                        left = TreeNode(19)
                    }
                }
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 1),
                    intArrayOf(2, 3, 0),
                    intArrayOf(3, 4, 1)
                ),
                TreeNode(1) {
                    left = TreeNode(2) {
                        right = TreeNode(3) {
                            left = TreeNode(4)
                        }
                    }
                }
            )
        )
    }

    @Nested
    inner class CreateBinaryTreeFromDescriptionsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should create a binary tree from a list of descriptions`(
            descriptions: Array<IntArray>,
            expected: TreeNode
        ) {
            CreateBinaryTreeFromDescriptionsRev1().test(descriptions, expected)
        }
    }
}

private fun CreateBinaryTreeFromDescriptions.test(descriptions: Array<IntArray>, expected: TreeNode) {
    val actual = createBinaryTree(descriptions)
    assertTrue(actual.equalsTo(expected))
}
