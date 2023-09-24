package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ChampagneTower.ChampagneTowerRev1
import com.github.dkoval.leetcode.challenge.ChampagneTower.ChampagneTowerRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ChampagneTowerTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 1, 1, 0.0),
            Arguments.of(2, 1, 1, 0.5),
            Arguments.of(1, 1, 0, 0.0),
            Arguments.of(100000009, 33, 17, 1.0)
        )
    }

    @Nested
    inner class ChampagneTowerRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return how full the jth glass in the ith row is`(
            poured: Int,
            queryRow: Int,
            queryGlass: Int,
            expected: Double
        ) {
            ChampagneTowerRev1().test(poured, queryRow, queryGlass, expected)
        }
    }

    @Nested
    inner class ChampagneTowerRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return how full the jth glass in the ith row is`(
            poured: Int,
            queryRow: Int,
            queryGlass: Int,
            expected: Double
        ) {
            ChampagneTowerRev2().test(poured, queryRow, queryGlass, expected)
        }
    }
}

private fun ChampagneTower.test(poured: Int, queryRow: Int, queryGlass: Int, expected: Double) {
    val actual = champagneTower(poured, queryRow, queryGlass)
    assertEquals(expected, actual, 1E-6)
}
