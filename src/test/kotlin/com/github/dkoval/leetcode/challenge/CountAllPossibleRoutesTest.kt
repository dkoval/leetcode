package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountAllPossibleRoutes.CountAllPossibleRoutesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountAllPossibleRoutesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 3, 6, 8, 4),
                1,
                3,
                5,
                4
            ),
            Arguments.of(
                intArrayOf(4, 3, 1),
                1,
                0,
                6,
                5
            ),
            Arguments.of(
                intArrayOf(5, 2, 1),
                0,
                2,
                3,
                0
            )
        )
    }

    @Nested
    inner class CountAllPossibleRoutesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the count of all possible routes from start to finish`(
            locations: IntArray,
            start: Int,
            finish: Int,
            fuel: Int,
            expected: Int
        ) {
           CountAllPossibleRoutesRev1().test(locations, start, finish, fuel, expected)
        }
    }
}

private fun CountAllPossibleRoutes.test(locations: IntArray, start: Int, finish: Int, fuel: Int, expected: Int) {
    val actual = countRoutes(locations, start, finish, fuel)
    assertEquals(expected, actual)
}
