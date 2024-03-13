package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindPivotInteger.FindPivotIntegerRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindPivotIntegerTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(8, 6),
            Arguments.of(1, 1),
            Arguments.of(4, -1)
        )
    }

    @Nested
    inner class FindPivotIntegerRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the pivot integer x, if no such integer exists, return -1`(n: Int, expected: Int) {
            FindPivotIntegerRev1().test(n, expected)
        }
    }
}

private fun FindPivotInteger.test(n: Int, expected: Int) {
    val actual = pivotInteger(n)
    assertEquals(expected, actual)
}
