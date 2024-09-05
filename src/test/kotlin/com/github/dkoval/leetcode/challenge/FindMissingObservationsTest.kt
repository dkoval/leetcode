package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindMissingObservations.FindMissingObservationsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindMissingObservationsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 2, 4, 3),
                4,
                2,
                true
            ),
            Arguments.of(
                intArrayOf(1, 5, 6),
                3,
                4,
                true
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                6,
                4,
                false
            ),
            Arguments.of(
                intArrayOf(6, 1, 5, 2),
                4,
                4,
                true
            )
        )
    }

    @Nested
    inner class FindMissingObservationsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of length n containing the missing observations `(
            rolls: IntArray,
            mean: Int,
            n: Int,
            possible: Boolean
        ) {
            FindMissingObservationsRev1().test(rolls, mean, n, possible)
        }
    }
}

private fun FindMissingObservations.test(rolls: IntArray, mean: Int, n: Int, possible: Boolean) {
    val actual = missingRolls(rolls, mean, n)
    if (possible) {
        assertEquals(n, actual.size)
        assertEquals(mean * (rolls.size + n), rolls.sum() + actual.sum())
    } else {
        assertTrue(actual.isEmpty())
    }
}
