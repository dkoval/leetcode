package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.IPO.IPORev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class IPOTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                2,
                0,
                intArrayOf(1, 2, 3),
                intArrayOf(0, 1, 1),
                4
            ),
            Arguments.of(
                3,
                0,
                intArrayOf(1, 2, 3),
                intArrayOf(0, 1, 2),
                6
            )
        )
    }

    @Nested
    inner class IPORev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the final maximized capital`(k: Int, w: Int, profits: IntArray, capital: IntArray, expected: Int) {
            IPORev1().test(k, w, profits, capital, expected)
        }
    }
}

private fun IPO.test(k: Int, w: Int, profits: IntArray, capital: IntArray, expected: Int) {
    val actual = findMaximizedCapital(k, w, profits, capital)
    assertEquals(expected, actual)
}
