package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.DeleteNodesFromLinkedListPresentInArray.DeleteNodesFromLinkedListPresentInArrayRev1
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DeleteNodesFromLinkedListPresentInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3),
                ListNode.headOf(1, 2, 3, 4, 5),
                ListNode.headOf(4, 5)
            ),
            Arguments.of(
                intArrayOf(1),
                ListNode.headOf(1, 2, 1, 2, 1, 2),
                ListNode.headOf(2, 2, 2)
            ),
            Arguments.of(
                intArrayOf(5),
                ListNode.headOf(1, 2, 3, 4),
                ListNode.headOf(1, 2, 3, 4)
            )
        )
    }

    @Nested
    inner class DeleteNodesFromLinkedListPresentInArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums`(
            nums: IntArray,
            head: ListNode,
            expected: ListNode
        ) {
            DeleteNodesFromLinkedListPresentInArrayRev1().test(nums, head, expected)
        }
    }
}

private fun DeleteNodesFromLinkedListPresentInArray.test(nums: IntArray, head: ListNode, expected: ListNode) {
    assertTrue { modifiedList(nums, head).equalsTo(expected) }
}
