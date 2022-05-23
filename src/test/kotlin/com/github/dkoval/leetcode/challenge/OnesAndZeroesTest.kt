package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.OnesAndZeroes.OnesAndZeroesDPBottomUp
import com.github.dkoval.leetcode.challenge.OnesAndZeroes.OnesAndZeroesDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class OnesAndZeroesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("10", "0001", "111001", "1", "0"),
                5,
                3,
                // The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
                // Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
                // {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
                4
            ),
            Arguments.of(
                arrayOf("10", "0", "1"),
                1,
                1,
                // The largest subset is {"0", "1"}, so the answer is 2.
                2
            )
        )
    }

    @Nested
    inner class OnesAndZeroesDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the size of the largest subset of strs such that there are at most m 0s and n 1s in the subset`(
            strs: Array<String>,
            m: Int,
            n: Int,
            expected: Int
        ) {
            OnesAndZeroesDPTopDown().test(strs, m, n, expected)
        }
    }

    @Nested
    inner class OnesAndZeroesDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the size of the largest subset of strs such that there are at most m 0s and n 1s in the subset`(
            strs: Array<String>,
            m: Int,
            n: Int,
            expected: Int
        ) {
            OnesAndZeroesDPBottomUp().test(strs, m, n, expected)
        }
    }

    private fun OnesAndZeroes.test(strs: Array<String>, m: Int, n: Int, expected: Int) {
        val actual = findMaxForm(strs, m, n)
        assertEquals(expected, actual)
    }
}