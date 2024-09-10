package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.InsertGreatestCommonDivisorsInLinkedList.InsertGreatestCommonDivisorsInLinkedListRev1
import com.github.dkoval.leetcode.challenge.InsertGreatestCommonDivisorsInLinkedList.InsertGreatestCommonDivisorsInLinkedListRev2
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class InsertGreatestCommonDivisorsInLinkedListTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode.headOf(18, 6, 10, 3),
                ListNode.headOf(18, 6, 6, 2, 10, 1, 3)
            ),
            Arguments.of(
                ListNode.headOf(7),
                ListNode.headOf(7)
            )
        )
    }

    @Nested
    inner class InsertGreatestCommonDivisorsInLinkedListRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the linked list after insertion`(head: ListNode, expected: ListNode) {
            InsertGreatestCommonDivisorsInLinkedListRev1().test(head, expected)
        }
    }

    @Nested
    inner class InsertGreatestCommonDivisorsInLinkedListRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the linked list after insertion`(head: ListNode, expected: ListNode) {
            InsertGreatestCommonDivisorsInLinkedListRev2().test(head, expected)
        }
    }
}

fun InsertGreatestCommonDivisorsInLinkedList.test(head: ListNode, expected: ListNode) {
    assertTrue { insertGreatestCommonDivisors(head).equalsTo(expected) }
}
