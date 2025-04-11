package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountSymmetricIntegers.CountSymmetricIntegersRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountSymmetricIntegersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 100, 9),
            Arguments.of(1200, 1230, 4)
        )
    }

    @Nested
    inner class CountSymmetricIntegersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of symmetric integers in the range`(low: Int, high: Int, expected: Int) {
            CountSymmetricIntegersRev1().test(low, high, expected)
        }
    }
}

private fun CountSymmetricIntegers.test(low: Int, high: Int, expected: Int) {
    val actual = countSymmetricIntegers(low, high)
    assertEquals(expected, actual)
}
