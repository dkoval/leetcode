package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfNumberIsSumOfPowersOfThree.CheckIfNumberIsSumOfPowersOfThreeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CheckIfNumberIsSumOfPowersOfThreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(12, true),
            Arguments.of(91, true),
            Arguments.of(21, false)
        )
    }

    @Nested
    inner class CheckIfNumberIsSumOfPowersOfThreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if a number is a sum of powers of 3`(n: Int, expected: Boolean) {
            CheckIfNumberIsSumOfPowersOfThreeRev1().test(n, expected)
        }
    }
}

private fun CheckIfNumberIsSumOfPowersOfThree.test(n: Int, expected: Boolean) {
    val actual = checkPowersOfThree(n)
    assertEquals(expected, actual)
}
