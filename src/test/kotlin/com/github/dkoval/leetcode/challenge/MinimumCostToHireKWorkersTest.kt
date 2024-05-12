package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumCostToHireKWorkers.MinimumCostToHireKWorkersRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumCostToHireKWorkersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(10, 20, 5),
                intArrayOf(70, 50, 30),
                2,
                105.00000
            ),
            Arguments.of(
                intArrayOf(3, 1, 10, 10, 1),
                intArrayOf(4, 8, 2, 2, 7),
                3,
                30.66667
            )
        )
    }

    @Nested
    inner class MinimumCostToHireKWorkersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the least amount of money needed to form a paid group`(
            quality: IntArray,
            wage: IntArray,
            k: Int,
            expected: Double
        ) {
            MinimumCostToHireKWorkersRev1().test(quality, wage, k, expected)
        }
    }
}

private fun MinimumCostToHireKWorkers.test(quality: IntArray, wage: IntArray, k: Int, expected: Double) {
    val actual = mincostToHireWorkers(quality, wage, k)
    assertEquals(expected, actual, 1e-5)
}
