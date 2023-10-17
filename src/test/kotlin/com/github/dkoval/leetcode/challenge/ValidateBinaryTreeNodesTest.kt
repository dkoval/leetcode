package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ValidateBinaryTreeNodes.ValidateBinaryTreeNodesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ValidateBinaryTreeNodesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                4,
                intArrayOf(1, -1, 3, -1),
                intArrayOf(2, -1, -1, -1),
                true
            ),
            Arguments.of(
                4,
                intArrayOf(1, -1, 3, -1),
                intArrayOf(2, 3, -1, -1),
                false
            ),
            Arguments.of(
                2,
                intArrayOf(1, 0),
                intArrayOf(-1, -1),
                false
            ),
            Arguments.of(
                6,
                intArrayOf(1, -1, -1, 4, -1, -1),
                intArrayOf(2, -1, -1, 5, -1, -1),
                false
            ),
            Arguments.of(
                4,
                intArrayOf(3, -1, 1, -1),
                intArrayOf(-1, -1, 0, -1),
                true
            ),
            Arguments.of(
                4,
                intArrayOf(1, 0, 3, -1),
                intArrayOf(-1, -1, -1, -1),
                false
            ),
            Arguments.of(
                4,
                intArrayOf(1, 2, 0, -1),
                intArrayOf(-1, -1, -1, -1),
                false
            )
        )
    }

    @Nested
    inner class ValidateBinaryTreeNodesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if and only if all the given nodes form exactly one valid binary tree`(
            n: Int,
            leftChild: IntArray,
            rightChild: IntArray,
            expected: Boolean
        ) {
            ValidateBinaryTreeNodesRev1().test(n, leftChild, rightChild, expected)
        }
    }
}

private fun ValidateBinaryTreeNodes.test(n: Int, leftChild: IntArray, rightChild: IntArray, expected: Boolean) {
    val actual = validateBinaryTreeNodes(n, leftChild, rightChild)
    assertEquals(expected, actual)
}
