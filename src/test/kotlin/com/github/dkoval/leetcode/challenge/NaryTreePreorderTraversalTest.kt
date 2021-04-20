package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NaryTreePreorderTraversal.*
import com.github.dkoval.leetcode.challenge.NaryTreePreorderTraversal.Node
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NaryTreePreorderTraversalTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                Node(1).apply {
                    children = listOf(
                        Node(3).apply {
                            children = listOf(
                                Node(5),
                                Node(6)
                            )
                        },
                        Node(2),
                        Node(4)
                    )
                },
                listOf(1, 3, 5, 6, 2, 4)
            )
        )
    }

    @Nested
    inner class NaryTreePreorderTraversalRecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the preorder traversal of n-ary tree node values`(root: Node?, expected: List<Int>) {
            NaryTreePreorderTraversalRecursive().test(root, expected)
        }
    }

    @Nested
    inner class NaryTreePreorderTraversalIterTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the preorder traversal of n-ary tree node values`(root: Node?, expected: List<Int>) {
            NaryTreePreorderTraversalIter().test(root, expected)
        }
    }

    private fun NaryTreePreorderTraversal.test(root: Node?, expected: List<Int>) {
        val actual = preorder(root)
        assertEquals(expected, actual)
    }
}