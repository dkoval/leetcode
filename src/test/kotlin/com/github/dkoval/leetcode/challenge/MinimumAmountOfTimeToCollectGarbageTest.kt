package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumAmountOfTimeToCollectGarbage.MinimumAmountOfTimeToCollectGarbageRev1
import com.github.dkoval.leetcode.challenge.MinimumAmountOfTimeToCollectGarbage.MinimumAmountOfTimeToCollectGarbageRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumAmountOfTimeToCollectGarbageTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("G", "P", "GP", "GG"),
                intArrayOf(2, 4, 3),
                21
            ),
            Arguments.of(
                arrayOf("MMM", "PGM", "GP"),
                intArrayOf(3, 10),
                37
            )
        )
    }

    @Nested
    inner class MinimumAmountOfTimeToCollectGarbageRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of minutes needed to pick up all the garbage`(
            garbage: Array<String>,
            travel: IntArray,
            expected: Int
        ) {
            MinimumAmountOfTimeToCollectGarbageRev1().test(garbage, travel, expected)
        }
    }

    @Nested
    inner class MinimumAmountOfTimeToCollectGarbageRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of minutes needed to pick up all the garbage`(
            garbage: Array<String>,
            travel: IntArray,
            expected: Int
        ) {
            MinimumAmountOfTimeToCollectGarbageRev2().test(garbage, travel, expected)
        }
    }
}

private fun MinimumAmountOfTimeToCollectGarbage.test(garbage: Array<String>, travel: IntArray, expected: Int) {
    val actual = garbageCollection(garbage, travel)
    assertEquals(expected, actual)
}
