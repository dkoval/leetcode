package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumMatchingOfPlayersWithTrainers.MaximumMatchingOfPlayersWithTrainersRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumMatchingOfPlayersWithTrainersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 7, 9),
                intArrayOf(8, 2, 5, 8),
                2
            ),
            Arguments.of(
                intArrayOf(1, 1, 1),
                intArrayOf(10),
                1
            )
        )
    }

    @Nested
    inner class MaximumMatchingOfPlayersWithTrainersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return maximum number of players that can be matched with trainers`(
            players: IntArray,
            trainers: IntArray,
            expected: Int
        ) {
            MaximumMatchingOfPlayersWithTrainersRev1().test(players, trainers, expected)
        }
    }
}

private fun MaximumMatchingOfPlayersWithTrainers.test(players: IntArray, trainers: IntArray, expected: Int) {
    val actual = matchPlayersAndTrainers(players, trainers)
    assertEquals(expected, actual)
}
