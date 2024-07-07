package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.WaterBottles.WaterBottlesRev1
import com.github.dkoval.leetcode.problems.WaterBottles.WaterBottlesRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class WaterBottlesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(9, 3, 13),
            Arguments.of(15, 4, 19)
        )
    }

    @Nested
    inner class WaterBottlesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of water bottles you can drink`(
            numBottles: Int,
            numExchange: Int,
            expected: Int
        ) {
            WaterBottlesRev1().test(numBottles, numExchange, expected)
        }
    }

    @Nested
    inner class WaterBottlesRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of water bottles you can drink`(
            numBottles: Int,
            numExchange: Int,
            expected: Int
        ) {
            WaterBottlesRev2().test(numBottles, numExchange, expected)
        }
    }
}

private fun WaterBottles.test(numBottles: Int, numExchange: Int, expected: Int) {
    val actual = numWaterBottles(numBottles, numExchange)
    assertEquals(expected, actual)
}
