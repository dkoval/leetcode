package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.problems.UniquePaths
import com.github.dkoval.leetcode.problems.UniquePaths.UniquePathsDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class UniquePathsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(3, 7, 28),
            Arguments.of(3, 2, 3),
            Arguments.of(7, 3, 28),
            Arguments.of(3, 3, 6)
        )
    }

    @Nested
    inner class UniquePathsDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count possible unique paths`(m: Int, n: Int, expected: Int) {
            UniquePathsDPTopDown().test(m, n, expected)
        }
    }

    @Nested
    inner class UniquePathsDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count possible unique paths`(m: Int, n: Int, expected: Int) {
            UniquePathsDPBottomUp.test(m, n, expected)
        }
    }

    private fun UniquePaths.test(m: Int, n: Int, expected: Int) {
        val actual = uniquePaths(m, n)
        assertEquals(expected, actual)
    }
}