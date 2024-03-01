package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.problems.FindBottomLeftTreeValue.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindBottomLeftTreeValueTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                },
                1
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4)
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(5).apply {
                            left = TreeNode(7)
                        }
                        right = TreeNode(6)
                    }
                },
                7
            ),
            Arguments.of(
                TreeNode(0),
                0
            )
        )
    }

    @Nested
    inner class FindBottomLeftTreeValueRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the leftmost value in the last row of the tree`(root: TreeNode, expected: Int) {
            FindBottomLeftTreeValueRev1().test(root, expected)
        }
    }

    @Nested
    inner class FindBottomLeftTreeValueRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the leftmost value in the last row of the tree`(root: TreeNode, expected: Int) {
            FindBottomLeftTreeValueRev2().test(root, expected)
        }
    }

    @Nested
    inner class FindBottomLeftTreeValueRev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the leftmost value in the last row of the tree`(root: TreeNode, expected: Int) {
            FindBottomLeftTreeValueRev3().test(root, expected)
        }
    }
}

private fun FindBottomLeftTreeValue.test(root: TreeNode, expected: Int) {
    val actual = findBottomLeftValue(root)
    assertEquals(expected, actual)
}
