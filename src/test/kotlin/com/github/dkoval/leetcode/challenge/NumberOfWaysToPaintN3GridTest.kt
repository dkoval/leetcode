package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfWaysToPaintN3Grid.NumberOfWaysToPaintN3GridRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfWaysToPaintN3GridTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 12)
        )
    }

    @Nested
    inner class NumberOfWaysToPaintN3GridRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of ways to paint the grid`(n: Int, expected: Int) {
            NumberOfWaysToPaintN3GridRev1().test(n, expected)
        }
    }
}

private fun NumberOfWaysToPaintN3Grid.test(n: Int, expected: Int) {
    val actual = numOfWays(n)
    assertEquals(expected, actual)
}
