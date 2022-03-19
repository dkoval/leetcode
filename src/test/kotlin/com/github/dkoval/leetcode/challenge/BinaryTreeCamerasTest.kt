package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.BinaryTreeCameras.BinaryTreeCamerasTopDownWithMemoization
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BinaryTreeCamerasTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(0).apply {
                    left = TreeNode(0).apply {
                        left = TreeNode(0)
                        right = TreeNode(0)
                    }
                },
                1
            ),
            Arguments.of(
                TreeNode(0).apply {
                    left = TreeNode(0).apply {
                        left = TreeNode(0).apply {
                            left = TreeNode(0).apply {
                                right = TreeNode(0)
                            }
                        }
                    }
                },
                2
            )
        )
    }

    @Nested
    inner class BinaryTreeCamerasTopDownWithMemoizationTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should calculate the minimum number of cameras needed to monitor all nodes of the tree`(
            root: TreeNode?,
            expected: Int
        ) {
            BinaryTreeCamerasTopDownWithMemoization().test(root, expected)
        }
    }

    private fun BinaryTreeCameras.test(root: TreeNode?, expected: Int) {
        val actual = minCameraCover(root)
        assertEquals(expected, actual)
    }
}