package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.FindMinimumAndMaximumNumberOfNodesBetweenCriticalPoints.FindMinimumAndMaximumNumberOfNodesBetweenCriticalPointsRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindMinimumAndMaximumNumberOfNodesBetweenCriticalPointsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode.headOf(3, 1),
                intArrayOf(-1, -1)
            ),
            Arguments.of(
                ListNode.headOf(5, 3, 1, 2, 5, 1, 2),
                intArrayOf(1, 3)
            ),
            Arguments.of(
                ListNode.headOf(1, 3, 2, 2, 3, 2, 2, 2, 7),
                intArrayOf(3, 3)
            ),
        )
    }

    @Nested
    inner class FindMinimumAndMaximumNumberOfNodesBetweenCriticalPointsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum and the maximum distances between any two distinct critical points`(
            head: ListNode,
            expected: IntArray
        ) {
            FindMinimumAndMaximumNumberOfNodesBetweenCriticalPointsRev1().test(head, expected)
        }
    }
}

private fun FindMinimumAndMaximumNumberOfNodesBetweenCriticalPoints.test(head: ListNode, expected: IntArray) {
    val actual = nodesBetweenCriticalPoints(head)
    assertArrayEquals(expected, actual)
}
