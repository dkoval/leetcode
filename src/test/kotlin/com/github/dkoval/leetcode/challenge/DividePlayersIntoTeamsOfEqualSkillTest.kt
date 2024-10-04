package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DividePlayersIntoTeamsOfEqualSkill.DividePlayersIntoTeamsOfEqualSkillRev1
import com.github.dkoval.leetcode.challenge.DividePlayersIntoTeamsOfEqualSkill.DividePlayersIntoTeamsOfEqualSkillRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DividePlayersIntoTeamsOfEqualSkillTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 2, 5, 1, 3, 4),
                22
            ),
            Arguments.of(
                intArrayOf(3, 4),
                12
            ),
            Arguments.of(
                intArrayOf(1, 1, 2, 3),
                -1
            ),
            Arguments.of(
                intArrayOf(2, 1, 5, 2),
                -1
            ),
            Arguments.of(
                intArrayOf(5, 3, 7, 1),
                22
            ),
            Arguments.of(
                intArrayOf(5, 4, 4, 5, 5, 4),
                60
            ),
            Arguments.of(
                intArrayOf(11, 11, 20, 6, 15, 11, 15, 15, 19, 7),
                748
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 2, 3, 3, 3, 7, 7, 8, 8, 8, 9, 9),
                -1
            )
        )
    }

    @Nested
    inner class DividePlayersIntoTeamsOfEqualSkillRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the sum of the chemistry of all the teams`(skill: IntArray, expected: Long) {
            DividePlayersIntoTeamsOfEqualSkillRev1().test(skill, expected)
        }
    }

    @Nested
    inner class DividePlayersIntoTeamsOfEqualSkillRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the sum of the chemistry of all the teams`(skill: IntArray, expected: Long) {
            DividePlayersIntoTeamsOfEqualSkillRev2().test(skill, expected)
        }
    }
}

private fun DividePlayersIntoTeamsOfEqualSkill.test(skill: IntArray, expected: Long) {
    val actual = dividePlayers(skill)
    assertEquals(expected, actual)
}
