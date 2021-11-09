package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.problems.UniqueBinarySearchTrees
import com.github.dkoval.leetcode.problems.UniqueBinarySearchTrees.UniqueBinarySearchTreesDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class UniqueBinarySearchTreesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 1),
            Arguments.of(2, 2),
            Arguments.of(3, 5),
            Arguments.of(4, 14),
            Arguments.of(5, 42)
        )
    }

    @Nested
    inner class UniqueBinarySearchTreesDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count the number of structurally unique BSTs`(n: Int, expected: Int) {
            UniqueBinarySearchTreesDPTopDown().test(n, expected)
        }
    }

    @Nested
    inner class UniqueBinarySearchTreesDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count the number of structurally unique BSTs`(n: Int, expected: Int) {
            UniqueBinarySearchTreesDPBottomUp.test(n, expected)
        }
    }

    private fun UniqueBinarySearchTrees.test(n: Int, expected: Int) {
        val actual = numTrees(n)
        assertEquals(expected, actual)
    }
}