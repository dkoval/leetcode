package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.CarFleet.CarFleetWithStack
import com.github.dkoval.leetcode.problems.CarFleet.CarFleetWithoutStack
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CarFleetTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                12,
                intArrayOf(10, 8, 0, 5, 3),
                intArrayOf(2, 4, 1, 1, 3),
                3
            ),
            Arguments.of(
                10,
                intArrayOf(3),
                intArrayOf(3),
                1
            ),
            Arguments.of(
                100,
                intArrayOf(0, 2, 4),
                intArrayOf(4, 2, 1),
                1
            )
        )
    }

    @Nested
    inner class CarFleetWithStackTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of car fleets that will arrive at the destination`(
            target: Int,
            position: IntArray,
            speed: IntArray,
            expected: Int
        ) {
            CarFleetWithStack().test(target, position, speed, expected)
        }
    }

    @Nested
    inner class CarFleetWithoutStackTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of car fleets that will arrive at the destination`(
            target: Int,
            position: IntArray,
            speed: IntArray,
            expected: Int
        ) {
            CarFleetWithoutStack().test(target, position, speed, expected)
        }
    }

    private fun CarFleet.test(target: Int, position: IntArray, speed: IntArray, expected: Int) {
        val actual = carFleet(target, position, speed)
        assertEquals(expected, actual)
    }
}