package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.SmallestStringStartingFromLeaf.SmallestStringStartingFromLeafRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SmallestStringStartingFromLeafTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(0).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(3)
                        right = TreeNode(4)
                    }
                    right = TreeNode(2).apply {
                        left = TreeNode(3)
                        right = TreeNode(4)
                    }
                },
                "dba"
            ),
            Arguments.of(
                TreeNode(25).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(0)
                        right = TreeNode(2)
                    }
                },
                "adz"
            ),
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(2).apply {
                        right = TreeNode(1).apply {
                            left = TreeNode(0)
                        }
                    }
                    right = TreeNode(1).apply {
                        left = TreeNode(0)
                    }
                },
                "abc"
            )
        )
    }

    @Nested
    inner class SmallestStringStartingFromLeafRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the lexicographically smallest string that starts at a leaf of this tree and ends at the root`(
            root: TreeNode,
            expected: String
        ) {
            SmallestStringStartingFromLeafRev1().test(root, expected)
        }
    }
}

private fun SmallestStringStartingFromLeaf.test(root: TreeNode, expected: String) {
    val actual = smallestFromLeaf(root)
    assertEquals(expected, actual)
}
