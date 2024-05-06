package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.RemoveNodesFromLinkedList.RemoveNodesFromLinkedListRev1
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RemoveNodesFromLinkedListTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode.headOf(5, 2, 13, 3, 8),
                ListNode.headOf(13, 8)
            ),
            Arguments.of(
                ListNode.headOf(1, 1, 1, 1),
                ListNode.headOf(1, 1, 1, 1)
            )
        )
    }

    @Nested
    inner class RemoveNodesFromLinkedListRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the head of the modified linked list`(head: ListNode, expected: ListNode) {
            RemoveNodesFromLinkedListRev1().test(head, expected)
        }
    }
}

private fun RemoveNodesFromLinkedList.test(head: ListNode, expected: ListNode) {
    assertTrue {
        val actual = removeNodes(head)
        actual.equalsTo(expected)
    }
}
