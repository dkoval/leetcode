package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.WaterBottles2.WaterBottles2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class WaterBottles2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(13, 6, 15),
            Arguments.of(10, 3, 13)
        )
    }

    @Nested
    inner class WaterBottles2TestRev1 {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of water bottles you can drink`(
            numBottles: Int,
            numExchange: Int,
            expected: Int
        ) {
            WaterBottles2Rev1().test(numBottles, numExchange, expected)
        }
    }
}

private fun WaterBottles2.test(numBottles: Int, numExchange: Int, expected: Int) {
    val actual = maxBottlesDrunk(numBottles, numExchange)
    assertEquals(expected, actual)
}
