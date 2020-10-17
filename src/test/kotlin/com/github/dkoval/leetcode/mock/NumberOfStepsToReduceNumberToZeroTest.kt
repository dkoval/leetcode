package com.github.dkoval.leetcode.mock

import com.github.dkoval.leetcode.mock.NumberOfStepsToReduceNumberToZero.NumberOfStepsToReduceNumberToZeroStraightforward
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfStepsToReduceNumberToZeroTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(14, 6),
            Arguments.of(8, 4),
            Arguments.of(123, 12),
        )
    }

    @Nested
    inner class NumberOfStepsToReduceNumberToZeroStraightforwardTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of steps to reduce non-negative number to zero`(num: Int, expected: Int) {
            NumberOfStepsToReduceNumberToZeroStraightforward().test(num, expected)
        }
    }

    private fun NumberOfStepsToReduceNumberToZero.test(num: Int, expected: Int) {
        val actual = numberOfSteps(num)
        assertEquals(expected, actual)
    }
}