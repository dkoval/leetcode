package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfWaysToDivideLongCorridor.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfWaysToDivideLongCorridorTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "SSPPSPS",
                3
            ),
            Arguments.of(
                "PPSPSP",
                1
            ),
            Arguments.of(
                "S",
                0
            ),
            Arguments.of(
                "SSSPPPSPPSPSSSSSSPPPSPP",
                3
            ),
            Arguments.of(
                "PPPPPSPPSPPSPPPSPPPPSPPPPSPPPPSPPSPPPSPSPPPSPSPPPSPSPPPSPSPPPPSPPPPSPPPSPPSPPPPSPSPPPPSPSPPPPSPSPPPSPPSPPPPSPSPSS",
                919999993
            ),
            Arguments.of(
                "SPPPPPPPSPPPSPSSSPPPPPPPPPPPPPPPPPSPPPPPPPPPPPPPPPPSPPPPPSPSPPPPPPSPSPPSPSPPPSPSPPSSPPPPPSPPSSPP",
                0
            ),
            Arguments.of(
                "P",
                0
            )
        )
    }

    @Nested
    inner class NumberOfWaysToDivideLongCorridorCombinatoricsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of ways to divide the corridor`(corridor: String, expected: Int) {
            NumberOfWaysToDivideLongCorridorCombinatoricsRev1().test(corridor, expected)
        }
    }

    @Nested
    inner class NumberOfWaysToDivideLongCorridorCombinatoricsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of ways to divide the corridor`(corridor: String, expected: Int) {
            NumberOfWaysToDivideLongCorridorCombinatoricsRev2().test(corridor, expected)
        }
    }

    @Nested
    inner class NumberOfWaysToDivideLongCorridorDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of ways to divide the corridor`(corridor: String, expected: Int) {
            NumberOfWaysToDivideLongCorridorDPTopDown().test(corridor, expected)
        }
    }
}

private fun NumberOfWaysToDivideLongCorridor.test(corridor: String, expected: Int) {
    val actual = numberOfWays(corridor)
    assertEquals(expected, actual)
}
