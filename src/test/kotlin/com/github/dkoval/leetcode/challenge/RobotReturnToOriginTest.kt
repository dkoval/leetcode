package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RobotReturnToOrigin.RobotReturnToOriginRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class RobotReturnToOriginTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of("UD", true),
            Arguments.of("LL", false)
        )
    }

    @Nested
    inner class RobotReturnToOriginRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if after performing all the moves the robot returns to its original position`(
            moves: String,
            expected: Boolean
        ) {
            RobotReturnToOriginRev1().test(moves, expected)
        }
    }
}

private fun RobotReturnToOrigin.test(moves: String, expected: Boolean) {
    val actual = judgeCircle(moves)
    assertEquals(expected, actual)
}
