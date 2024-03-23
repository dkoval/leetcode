package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.equalsTo
import com.github.dkoval.leetcode.problems.ReorderList
import com.github.dkoval.leetcode.problems.ReorderList.*
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ReorderListTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode.headOf(1),
                ListNode.headOf(1)
            ),
            Arguments.of(
                ListNode.headOf(1, 2),
                ListNode.headOf(1, 2)
            ),
            Arguments.of(
                ListNode.headOf(1, 2, 3),
                ListNode.headOf(1, 3, 2)
            ),
            Arguments.of(
                ListNode.headOf(1, 2, 3, 4),
                ListNode.headOf(1, 4, 2, 3)
            ),
            Arguments.of(
                ListNode.headOf(1, 2, 3, 4, 5),
                ListNode.headOf(1, 5, 2, 4, 3)
            )
        )
    }

    @Nested
    inner class ReorderListUsingSplitAndReverseRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reorder list`(head: ListNode?, expected: ListNode?) {
            ReorderListUsingSplitAndReverseRev1().test(head, expected)
        }
    }

    @Nested
    inner class ReorderListUsingSplitAndReverseRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reorder list`(head: ListNode?, expected: ListNode?) {
            ReorderListUsingSplitAndReverseRev2().test(head, expected)
        }
    }

    @Nested
    inner class ReorderListByCalculatingNumberPairsToConnectTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reorder list`(head: ListNode?, expected: ListNode?) {
            ReorderListByCalculatingNumberPairsToConnect().test(head, expected)
        }
    }

}

private fun ReorderList.test(head: ListNode?, expected: ListNode?) {
    assertTrue {
        reorderList(head)
        head.equalsTo(expected)
    }
}
