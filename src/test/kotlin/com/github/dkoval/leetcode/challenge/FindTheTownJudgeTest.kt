package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.problems.FindTheTownJudge
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindTheTownJudgeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                2,
                arrayOf(
                    intArrayOf(1, 2)
                ),
                2
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 3)
                ),
                3
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 3),
                    intArrayOf(3, 1)
                ),
                -1
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3)
                ),
                -1
            ),
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(1, 4),
                    intArrayOf(2, 3),
                    intArrayOf(2, 4),
                    intArrayOf(4, 3)
                ),
                3
            ),
            Arguments.of(
                1,
                arrayOf<IntArray>(),
                1
            )
        )
    }

    @Nested
    inner class FindTheTownJudgeByComputingTrustTableTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the town judge`(N: Int, trust: Array<IntArray>, expected: Int) {
            FindTheTownJudgeByComputingTrustTable.test(N, trust, expected)
        }
    }

    @Nested
    inner class FindTheTownJudgeByCountingEdgesTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the town judge`(N: Int, trust: Array<IntArray>, expected: Int) {
            FindTheTownJudgeByComputingTrustTable.test(N, trust, expected)
        }
    }

    private fun FindTheTownJudge.test(N: Int, trust: Array<IntArray>, expected: Int) {
        val actual = findJudge(N, trust)
        assertEquals(expected, actual)
    }
}