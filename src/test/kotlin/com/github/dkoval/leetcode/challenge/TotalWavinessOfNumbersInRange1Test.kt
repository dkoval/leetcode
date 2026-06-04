package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.TotalWavinessOfNumbersInRange1.TotalWavinessOfNumbersInRange1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class TotalWavinessOfNumbersInRange1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(120, 130, 3),
            Arguments.of(198, 202, 3),
            Arguments.of(4848, 4848, 2)
        )
    }

    @Nested
    inner class TotalWavinessOfNumbersInRange1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the total sum of waviness for all numbers in the range`(
            num1: Int,
            num2: Int,
            expected: Int
        ) {
            TotalWavinessOfNumbersInRange1Rev1().test(num1, num2, expected)
        }
    }
}

private fun TotalWavinessOfNumbersInRange1Rev1.test(num1: Int, num2: Int, expected: Int) {
    val actual = totalWaviness(num1, num2)
    assertEquals(expected, actual)
}