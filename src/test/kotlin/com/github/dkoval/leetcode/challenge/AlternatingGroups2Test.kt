package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.AlternatingGroups2.AlternatingGroups2Rev1
import com.github.dkoval.leetcode.challenge.AlternatingGroups2.AlternatingGroups2Rev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AlternatingGroups2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0, 1, 0, 1, 0),
                3,
                3
            ),
            Arguments.of(
                intArrayOf(0, 1, 0, 0, 1, 0, 1),
                6,
                2
            ),
            Arguments.of(
                intArrayOf(1, 1, 0, 1),
                4,
                0
            )
        )
    }

    @Nested
    inner class AlternatingGroups2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of alternating groups`(colors: IntArray, k: Int, expected: Int) {
            AlternatingGroups2Rev1().test(colors, k, expected)

        }
    }

    @Nested
    inner class AlternatingGroups2Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of alternating groups`(colors: IntArray, k: Int, expected: Int) {
            AlternatingGroups2Rev2().test(colors, k, expected)
        }
    }
}

private fun AlternatingGroups2.test(colors: IntArray, k: Int, expected: Int) {
    val actual = numberOfAlternatingGroups(colors, k)
    assertEquals(expected, actual)
}
