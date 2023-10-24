package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.FindLargestValueInEachTreeRow.FindLargestValueInEachTreeRowRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindLargestValueInEachTreeRowTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(5)
                        right = TreeNode(3)
                    }
                    right = TreeNode(2).apply {
                        right = TreeNode(9)
                    }
                },
                listOf(1, 3, 9)
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                listOf(1, 3)
            ),
            Arguments.of(
                null,
                emptyList<Int>()
            )
        )
    }

    @Nested
    inner class FindLargestValueInEachTreeRowRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of the largest value in each row of the tree`(
            root: TreeNode?,
            expected: List<Int>
        ) {
            FindLargestValueInEachTreeRowRev1().test(root, expected)
        }
    }
}

private fun FindLargestValueInEachTreeRow.test(root: TreeNode?, expected: List<Int>) {
    val actual = largestValues(root)
    assertEquals(expected, actual)
}
