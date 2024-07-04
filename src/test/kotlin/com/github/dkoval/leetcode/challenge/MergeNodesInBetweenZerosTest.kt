package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.MergeNodesInBetweenZeros.MergeNodesInBetweenZerosRev1
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MergeNodesInBetweenZerosTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode.headOf(0, 3, 1, 0, 4, 5, 2, 0),
                ListNode.headOf(4, 11)
            ),
            Arguments.of(
                ListNode.headOf(0, 1, 0, 3, 0, 2, 2, 0),
                ListNode.headOf(1, 3, 4)
            )
        )
    }

    @Nested
    inner class MergeNodesInBetweenZerosRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the head of the modified linked list`(head: ListNode, expected: ListNode) {
            MergeNodesInBetweenZerosRev1().test(head, expected)
        }
    }
}

private fun MergeNodesInBetweenZeros.test(head: ListNode, expected: ListNode) {
    assertTrue { mergeNodes(head).equalsTo(expected) }
}
