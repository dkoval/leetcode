package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumTimeToRepairCars.MinimumTimeToRepairCarsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumTimeToRepairCarsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 2, 3, 1),
                10,
                16L
            ),
            Arguments.of(
                intArrayOf(5, 1, 8),
                6,
                16L
            )
        )
    }

    @Nested
    inner class MinimumTimeToRepairCarsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum time taken to repair all the cars`(ranks: IntArray, cars: Int, expected: Long) {
            MinimumTimeToRepairCarsRev1().test(ranks, cars, expected)
        }
    }
}

private fun MinimumTimeToRepairCars.test(ranks: IntArray, cars: Int, expected: Long) {
    val actual = repairCars(ranks, cars)
    assertEquals(expected, actual)
}
