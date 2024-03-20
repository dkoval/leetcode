package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.MergeInBetweenLinkedLists.MergeInBetweenLinkedListsRev1
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MergeInBetweenLinkedListsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode.headOf(10, 1, 13, 6, 9, 5),
                3,
                4,
                ListNode.headOf(1000000, 1000001, 1000002),
                ListNode.headOf(10, 1, 13, 1000000, 1000001, 1000002, 5)
            ),
            Arguments.of(
                ListNode.headOf(0, 1, 2, 3, 4, 5, 6),
                2,
                5,
                ListNode.headOf(1000000, 1000001, 1000002, 1000003, 1000004),
                ListNode.headOf(0, 1, 1000000, 1000001, 1000002, 1000003, 1000004, 6)
            )
        )
    }

    @Nested
    inner class MergeInBetweenLinkedListsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should remove list1's nodes from the a-th node to the b-th node, and put list2 in their place`(
            list1: ListNode,
            a: Int,
            b: Int,
            list2: ListNode,
            expected: ListNode
        ) {
            MergeInBetweenLinkedListsRev1().test(list1, a, b, list2, expected)
        }
    }
}

private fun MergeInBetweenLinkedLists.test(list1: ListNode, a: Int, b: Int, list2: ListNode, expected: ListNode) {
    val actual = mergeInBetween(list1, a, b, list2)
    assertTrue { expected.equalsTo(actual) }
}
