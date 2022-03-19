package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.HouseRobber3.HouseRobber3DFSPreorder
import com.github.dkoval.leetcode.challenge.HouseRobber3.HouseRobber3DPTopDownWithMemoization
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class HouseRobber3Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(2).apply {
                        right = TreeNode(3)
                    }
                    right = TreeNode(3).apply {
                        right = TreeNode(1)
                    }
                },
                7
            ),
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(4).apply {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    }
                    right = TreeNode(5).apply {
                        right = TreeNode(1)
                    }
                },
                9
            )
        )
    }

    @Nested
    inner class HouseRobber3DPTopDownWithMemoizationTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum amount of money the thief can rob without alerting the police`(
            root: TreeNode?,
            expected: Int
        ) {
            HouseRobber3DPTopDownWithMemoization()
                .test(root, expected)
        }
    }

    @Nested
    inner class HouseRobber3DFSPreorderTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum amount of money the thief can rob without alerting the police`(
            root: TreeNode?,
            expected: Int
        ) {
            HouseRobber3DFSPreorder()
                .test(root, expected)
        }
    }

    private fun HouseRobber3.test(root: TreeNode?, expected: Int) {
        val actual = rob(root);
        assertEquals(expected, actual)
    }
}