package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.AssignCookies.AssignCookiesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AssignCookiesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3),
                intArrayOf(1, 1),
                1
            ),
            Arguments.of(
                intArrayOf(1, 2),
                intArrayOf(1, 2, 3),
                2
            )
        )
    }

    @Nested
    inner class AssignCookiesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should maximize the number of your content children and output the maximum number`(
            g: IntArray,
            s: IntArray,
            expected: Int
        ) {
            AssignCookiesRev1().test(g, s, expected)
        }
    }
}

private fun AssignCookies.test(g: IntArray, s: IntArray, expected: Int) {
    val actual = findContentChildren(g, s)
    assertEquals(expected, actual)
}
