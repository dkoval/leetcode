package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.EliminateMaximumNumberOfMonsters.EliminateMaximumNumberOfMonstersRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class EliminateMaximumNumberOfMonstersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 4),
                intArrayOf(1, 1, 1),
                3
            ),
            Arguments.of(
                intArrayOf(1, 1, 2, 3),
                intArrayOf(1, 1, 1, 1),
                1
            ),
            Arguments.of(
                intArrayOf(3, 2, 4),
                intArrayOf(5, 3, 2),
                1
            )
        )
    }

    @Nested
    inner class EliminateMaximumNumberOfMonstersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of monsters that you can eliminate`(
            dist: IntArray,
            speed: IntArray,
            expected: Int
        ) {
            EliminateMaximumNumberOfMonstersRev1().test(dist, speed, expected)
        }
    }
}

private fun EliminateMaximumNumberOfMonsters.test(dist: IntArray, speed: IntArray, expected: Int) {
    val actual = eliminateMaximum(dist, speed)
    assertEquals(expected, actual)
}
