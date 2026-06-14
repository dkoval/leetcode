package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.problems.MaximumTwinSumOfLinkedList.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumTwinSumOfLinkedListTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode(5) {
                    next = ListNode(4) {
                        next = ListNode(2) {
                            next = ListNode(1)
                        }
                    }
                },
                6
            ),
            Arguments.of(
                ListNode(4) {
                    next = ListNode(2) {
                        next = ListNode(2) {
                            next = ListNode(3)
                        }
                    }
                },
                7
            ),
            Arguments.of(
                ListNode(1) {
                    next = ListNode(100000)
                },
                100001
            )
        )
    }

    @Nested
    inner class MaximumTwinSumOfLinkedListUsingExtraSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should  return the maximum twin sum of the linked list`(head: ListNode, expected: Int) {
            MaximumTwinSumOfLinkedListUsingExtraSpace().test(head, expected)
        }
    }

    @Nested
    inner class MaximumTwinSumOfLinkedListByReversingSecondHalfTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should  return the maximum twin sum of the linked list`(head: ListNode, expected: Int) {
            MaximumTwinSumOfLinkedListByReversingSecondHalf().test(head, expected)
        }
    }

    @Nested
    inner class MaximumTwinSumOfLinkedListByReversingSecondHalfRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should  return the maximum twin sum of the linked list`(head: ListNode, expected: Int) {
            MaximumTwinSumOfLinkedListByReversingSecondHalfRev2().test(head, expected)
        }
    }
}

private fun MaximumTwinSumOfLinkedList.test(head: ListNode, expected: Int) {
    val actual = pairSum(head)
    assertEquals(expected, actual)
}
