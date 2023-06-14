package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.MinimumAbsoluteDifferenceInBST.MinimumAbsoluteDifferenceInBSTRev1
import com.github.dkoval.leetcode.challenge.MinimumAbsoluteDifferenceInBST.MinimumAbsoluteDifferenceInBSTRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumAbsoluteDifferenceInBSTTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    }
                    right = TreeNode(6)
                },
                1
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(0)
                    right = TreeNode(48).apply {
                        left = TreeNode(12)
                        right = TreeNode(49)
                    }
                },
                1
            )
        )
    }

    @Nested
    inner class MinimumAbsoluteDifferenceInBSTRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum absolute difference between the values of any two different nodes in the tree`(
            root: TreeNode,
            expected: Int
        ) {
            MinimumAbsoluteDifferenceInBSTRev1().test(root, expected)
        }
    }

    @Nested
    inner class MinimumAbsoluteDifferenceInBSTRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum absolute difference between the values of any two different nodes in the tree`(
            root: TreeNode,
            expected: Int
        ) {
            MinimumAbsoluteDifferenceInBSTRev2().test(root, expected)
        }
    }
}

private fun MinimumAbsoluteDifferenceInBST.test(root: TreeNode, expected: Int) {
    val actual = getMinimumDifference(root)
    assertEquals(expected, actual)
}
