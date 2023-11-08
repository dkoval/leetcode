package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DetermineIfCellIsReachableAtGivenTime.DetermineIfCellIsReachableAtGivenTimeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DetermineIfCellIsReachableAtGivenTimeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(2, 4, 7, 7, 6, true),
            Arguments.of(3, 1, 7, 3, 3, false),
            Arguments.of(1, 1, 1, 1, 3, true),
            Arguments.of(1, 2, 1, 2, 1, false)
        )
    }

    @Nested
    inner class DetermineIfCellIsReachableAtGivenTimeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if you can reach cell (fx, fy) after exactly t seconds, or false otherwise`(
            sx: Int,
            sy: Int,
            fx: Int,
            fy: Int,
            t: Int,
            expected: Boolean
        ) {
            DetermineIfCellIsReachableAtGivenTimeRev1().test(sx, sy, fx, fy, t, expected)
        }
    }
}

private fun DetermineIfCellIsReachableAtGivenTime.test(sx: Int, sy: Int, fx: Int, fy: Int, t: Int, expected: Boolean) {
    val actual = isReachableAtTime(sx, sy, fx, fy, t)
    assertEquals(expected, actual)
}
