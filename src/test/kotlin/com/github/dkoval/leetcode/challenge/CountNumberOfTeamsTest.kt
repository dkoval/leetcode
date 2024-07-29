package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountNumberOfTeams.CountNumberOfTeamsRev1
import com.github.dkoval.leetcode.challenge.CountNumberOfTeams.CountNumberOfTeamsRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountNumberOfTeamsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 5, 3, 4, 1),
                3
            ),
            Arguments.of(
                intArrayOf(2, 1, 3),
                0
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                4
            )
        )
    }

    @Nested
    inner class CountNumberOfTeamsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of teams you can form given the conditions`(rating: IntArray, expected: Int) {
            CountNumberOfTeamsRev1().test(rating, expected)
        }
    }

    @Nested
    inner class CountNumberOfTeamsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of teams you can form given the conditions`(rating: IntArray, expected: Int) {
            CountNumberOfTeamsRev2().test(rating, expected)
        }
    }
}

private fun CountNumberOfTeams.test(rating: IntArray, expected: Int) {
    val actual = numTeams(rating)
    assertEquals(expected, actual)
}
