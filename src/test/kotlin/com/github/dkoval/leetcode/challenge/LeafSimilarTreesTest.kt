package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.LeafSimilarTrees.LeafSimilarTreesDFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LeafSimilarTreesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(6)
                        right = TreeNode(2).apply {
                            left = TreeNode(7)
                            right = TreeNode(4)
                        }
                    }
                    right = TreeNode(1).apply {
                        left = TreeNode(9)
                        right = TreeNode(8)
                    }
                },
                TreeNode(3).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(6)
                        right = TreeNode(7)
                    }
                    right = TreeNode(1).apply {
                        left = TreeNode(4)
                        right = TreeNode(2).apply {
                            left = TreeNode(9)
                            right = TreeNode(8)
                        }
                    }
                },
                true
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                TreeNode(1).apply {
                    left = TreeNode(3)
                    right = TreeNode(2)
                },
                false
            )
        )
    }

    @Nested
    inner class LeafSimilarTreesDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true IFF the two given trees with head nodes root1 and root2 are leaf-similar`(
            root1: TreeNode,
            root2: TreeNode,
            expected: Boolean
        ) {
            LeafSimilarTreesDFS().test(root1, root2, expected)
        }
    }

    private fun LeafSimilarTrees.test(root1: TreeNode, root2: TreeNode, expected: Boolean) {
        val actual = leafSimilar(root1, root2)
        assertEquals(expected, actual)
    }
}