package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.CountNodesEqualToAverageOfSubtree.CountNodesEqualToAverageOfSubtreeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountNodesEqualToAverageOfSubtreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(8).apply {
                        left = TreeNode(0)
                        right = TreeNode(1)
                    }
                    right = TreeNode(5).apply {
                        right = TreeNode(6)
                    }
                },
                5
            ),
            Arguments.of(
                TreeNode(1),
                1
            )
        )
    }

    @Nested
    inner class CountNodesEqualToAverageOfSubtreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of nodes where the value of the node is equal to the average of the values in its subtree`(
            root: TreeNode,
            expected: Int
        ) {
            CountNodesEqualToAverageOfSubtreeRev1().test(root, expected)
        }
    }
}

private fun CountNodesEqualToAverageOfSubtree.test(root: TreeNode, expected: Int) {
    val actual = averageOfSubtree(root)
    assertEquals(expected, actual)
}
