package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.NumberOfProvinces.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfProvincesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 1, 0),
                    intArrayOf(0, 0, 1)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 1)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 0, 1),
                    intArrayOf(0, 1, 1, 0),
                    intArrayOf(0, 1, 1, 1),
                    intArrayOf(1, 0, 1, 1)
                ),
                1
            )
        )
    }

    @Nested
    inner class NumberOfProvincesUsingDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the total number of provinces`(connected: Array<IntArray>, expected: Int) {
            NumberOfProvincesUsingDFS().test(connected, expected)
        }
    }

    @Nested
    inner class NumberOfProvincesUsingBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the total number of provinces`(connected: Array<IntArray>, expected: Int) {
            NumberOfProvincesUsingBFS().test(connected, expected)
        }
    }

    @Nested
    inner class NumberOfProvincesUsingUnionFindTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the total number of provinces`(connected: Array<IntArray>, expected: Int) {
            NumberOfProvincesUsingUnionFind().test(connected, expected)
        }
    }

    private fun NumberOfProvinces.test(connected: Array<IntArray>, expected: Int) {
        val actual = findCircleNum(connected)
        assertEquals(expected, actual)
    }
}