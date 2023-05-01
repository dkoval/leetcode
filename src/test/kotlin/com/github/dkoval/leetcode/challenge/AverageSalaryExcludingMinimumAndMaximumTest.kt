package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.AverageSalaryExcludingMinimumAndMaximum.AverageSalaryExcludingMinimumAndMaximumRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AverageSalaryExcludingMinimumAndMaximumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4000, 3000, 1000, 2000),
                2500.00000
            ),
            Arguments.of(
                intArrayOf(1000, 2000, 3000),
                2000.00000
            )
        )
    }

    @Nested
    inner class AverageSalaryExcludingMinimumAndMaximumRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the average salary of employees excluding the minimum and maximum salary`(
            salary: IntArray,
            expected: Double
        ) {
            AverageSalaryExcludingMinimumAndMaximumRev1().test(salary, expected)
        }
    }
}

private fun AverageSalaryExcludingMinimumAndMaximum.test(salary: IntArray, expected: Double) {
    val actual = average(salary)
    assertEquals(expected, actual, 1E-5)
}
