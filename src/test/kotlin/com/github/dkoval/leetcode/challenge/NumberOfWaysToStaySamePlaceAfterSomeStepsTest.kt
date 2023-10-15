package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfWaysToStaySamePlaceAfterSomeSteps.NumberOfWaysToStaySamePlaceAfterSomeStepsDPTopDownRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfWaysToStaySamePlaceAfterSomeStepsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(3, 2, 4),
            Arguments.of(2, 4, 2),
            Arguments.of(4, 2, 8),
            Arguments.of(430, 148488, 525833932)
        )
    }

    @Nested
    inner class NumberOfWaysToStaySamePlaceAfterSomeStepsDPTopDownRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of ways such that your pointer is still at index 0`(
            steps: Int,
            arrLen: Int,
            expected: Int
        ) {
            NumberOfWaysToStaySamePlaceAfterSomeStepsDPTopDownRev1().test(steps, arrLen, expected)
        }
    }
}

private fun NumberOfWaysToStaySamePlaceAfterSomeSteps.test(steps: Int, arrLen: Int, expected: Int) {
    val actual = numWays(steps, arrLen)
    assertEquals(expected, actual)
}
