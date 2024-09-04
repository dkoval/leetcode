package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.problems.WalkingRobotSimulation
import com.github.dkoval.leetcode.problems.WalkingRobotSimulation.WalkingRobotSimulationRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class WalkingRobotSimulationTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, -1, 3),
                emptyArray<IntArray>(),
                25
            ),
            Arguments.of(
                intArrayOf(4, -1, 4, -2, 4),
                arrayOf(
                    intArrayOf(2, 4)
                ),
                65
            ),
            Arguments.of(
                intArrayOf(6, -1, -1, 6),
                emptyArray<IntArray>(),
                36
            )
        )
    }

    @Nested
    inner class WalkingRobotSimulationRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum Euclidean distance that the robot ever gets from the origin squared`(
            commands: IntArray,
            obstacles: Array<IntArray>,
            expected: Int
        ) {
            WalkingRobotSimulationRev1().test(commands, obstacles, expected)
        }
    }
}

private fun WalkingRobotSimulation.test(commands: IntArray, obstacles: Array<IntArray>, expected: Int) {
    val actual = robotSim(commands, obstacles)
    assertEquals(expected, actual)
}