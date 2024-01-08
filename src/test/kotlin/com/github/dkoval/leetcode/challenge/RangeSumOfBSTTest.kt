package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.RangeSumOfBST.RangeSumOfBSTRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RangeSumOfBSTTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(10).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(3)
                        right = TreeNode(7)
                    }
                    right = TreeNode(15).apply {
                        right = TreeNode(18)
                    }
                },
                7,
                15,
                32
            ),
            Arguments.of(
                TreeNode(10).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(3).apply {
                            left = TreeNode(1)
                        }
                        right = TreeNode(7).apply {
                            left = TreeNode(6)
                        }
                    }
                    right = TreeNode(15).apply {
                        left = TreeNode(13)
                        right = TreeNode(18)
                    }
                },
                6,
                10,
                23
            )
        )
    }

    @Nested
    inner class RangeSumOfBSTRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the sum of values of all nodes with a value in the inclusive range`(
            root: TreeNode,
            low: Int,
            high: Int,
            expected: Int
        ) {
            RangeSumOfBSTRev1().test(root, low, high, expected)
        }
    }
}

private fun RangeSumOfBST.test(root: TreeNode, low: Int, high: Int, expected: Int) {
    val actual = rangeSumBST(root, low, high)
    assertEquals(expected, actual)
}
