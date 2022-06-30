package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.WaterAndJugProblem.WaterAndJugProblemBFSSlow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class WaterAndJugProblemTest {

    class InputArgumentProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(3, 5, 4, true),
            Arguments.of(2, 6, 5, false),
            Arguments.of(1, 2, 3, true)
        )
    }

    @Nested
    inner class WaterAndJugProblemBFSSlowTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentProvider::class)
        fun `should determine whether it is possible to measure exactly targetCapacity liters using these two jugs`(
            jug1Capacity: Int,
            jug2Capacity: Int,
            targetCapacity: Int,
            expected: Boolean
        ) {
            WaterAndJugProblemBFSSlow().test(jug1Capacity, jug2Capacity, targetCapacity, expected)
        }
    }

    private fun WaterAndJugProblem.test(jug1Capacity: Int, jug2Capacity: Int, targetCapacity: Int, expected: Boolean) {
        val actual = canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity)
        assertEquals(expected, actual)
    }
}