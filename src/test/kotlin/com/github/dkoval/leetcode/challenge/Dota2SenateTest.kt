package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.Dota2Senate.Dota2SenateRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class Dota2SenateTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("RD", "Radiant"),
            Arguments.of("RDD", "Dire"),
            Arguments.of("DDRRR", "Dire"),
            Arguments.of("RRDDD", "Radiant"),
            Arguments.of("DRRDRDRDRDDRDRDR", "Radiant")
        )
    }

    @Nested
    inner class Dota2SenateRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should predict which party will finally announce the victory and change the Dota2 game`(
            senate: String,
            expected: String
        ) {
            Dota2SenateRev1().test(senate, expected)
        }
    }
}

private fun Dota2Senate.test(senate: String, expected: String) {
    val actual = predictPartyVictory(senate)
    assertEquals(expected, actual)
}
