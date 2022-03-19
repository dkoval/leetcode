package com.github.dkoval.leetcode.mock

import com.github.dkoval.leetcode.mock.LongestLineOfConsecutiveOneInMatrix.LongestLineOfConsecutiveOneInMatrixUsing3DDynamicProgramming
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestLineOfConsecutiveOneInMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 1, 0),
                    intArrayOf(0, 1, 1, 0),
                    intArrayOf(0, 0, 0, 1)
                ),
                3
            )
        )
    }

    @Nested
    inner class LongestLineOfConsecutiveOneInMatrixUsing3DDynamicProgrammingTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the longest line of 1s`(M: Array<IntArray>, expected: Int) {
            LongestLineOfConsecutiveOneInMatrixUsing3DDynamicProgramming().test(M, expected)
        }
    }

    private fun LongestLineOfConsecutiveOneInMatrix.test(M: Array<IntArray>, expected: Int) {
        val actual = longestLine(M)
        assertEquals(expected, actual)
    }
}