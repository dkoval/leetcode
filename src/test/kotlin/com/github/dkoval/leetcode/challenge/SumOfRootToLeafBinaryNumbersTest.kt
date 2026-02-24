package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.SumOfRootToLeafBinaryNumbers.SumOfRootToLeafBinaryNumbersRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class SumOfRootToLeafBinaryNumbersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(0).apply {
                        left = TreeNode(0)
                        right = TreeNode(1)
                    }
                    right = TreeNode(1).apply {
                        left = TreeNode(0)
                        right = TreeNode(1)
                    }
                },
                22 // (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
            ),
            Arguments.of(
                TreeNode(0),
                0
            ),
            Arguments.of(
                TreeNode(1),
                1
            ),
            Arguments.of(
                null,
                0
            )
        )
    }

    @Nested
    inner class SumOfRootToLeafBinaryNumbersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return sum of root to leaf binary numbers`(root: TreeNode?, expected: Int) {
            SumOfRootToLeafBinaryNumbersRev1.test(root, expected)
        }
    }

    @Nested
    inner class SumOfRootToLeafBinaryNumbersRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return sum of root to leaf binary numbers`(root: TreeNode?, expected: Int) {
            SumOfRootToLeafBinaryNumbersRev2().test(root, expected)
        }
    }
}

private fun SumOfRootToLeafBinaryNumbers.test(root: TreeNode?, expected: Int) {
    val actual = sumRootToLeaf(root)
    assertEquals(expected, actual)
}
