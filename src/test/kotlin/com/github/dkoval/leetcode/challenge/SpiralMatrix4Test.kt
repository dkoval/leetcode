package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.SpiralMatrix4.SpiralMatrix4Rev1
import com.github.dkoval.leetcode.challenge.SpiralMatrix4.SpiralMatrix4Rev2
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SpiralMatrix4Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                3, 5,
                ListNode.headOf(3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0),
                arrayOf(
                    intArrayOf(3, 0, 2, 6, 8),
                    intArrayOf(5, 0, -1, -1, 1),
                    intArrayOf(5, 2, 4, 9, 7)
                )
            ),
            Arguments.of(
                1, 4,
                ListNode.headOf(0, 1, 2),
                arrayOf(
                    intArrayOf(0, 1, 2, -1)
                )
            )
        )
    }

    @Nested
    inner class SpiralMatrix4Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the generated matrix`(m: Int, n: Int, head: ListNode, expected: Array<IntArray>) {
            SpiralMatrix4Rev1().test(m, n, head, expected)
        }
    }

    @Nested
    inner class SpiralMatrix4Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the generated matrix`(m: Int, n: Int, head: ListNode, expected: Array<IntArray>) {
            SpiralMatrix4Rev2().test(m, n, head, expected)
        }
    }
}

private fun SpiralMatrix4.test(m: Int, n: Int, head: ListNode, expected: Array<IntArray>) {
    val actual = spiralMatrix(m, n, head)
    assertArrayEquals(expected, actual)
}
