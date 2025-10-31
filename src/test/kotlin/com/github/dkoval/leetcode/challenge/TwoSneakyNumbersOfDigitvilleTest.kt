package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.TwoSneakyNumbersOfDigitville.TwoSneakyNumbersOfDigitvilleRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class TwoSneakyNumbersOfDigitvilleTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0, 1, 1, 0),
                intArrayOf(0, 1)
            ),
            Arguments.of(
                intArrayOf(0, 3, 2, 1, 3, 2),
                intArrayOf(2, 3)
            ),
            Arguments.of(
                intArrayOf(7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2),
                intArrayOf(4, 5)
            )
        )
    }

    @Nested
    inner class TwoSneakyNumbersOfDigitvilleRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the two sneaky numbers in Digitville`(
            nums: IntArray,
            expected: IntArray
        ) {
            TwoSneakyNumbersOfDigitvilleRev1().test(nums, expected)
        }
    }
}

private fun TwoSneakyNumbersOfDigitville.test(nums: IntArray, expected: IntArray) {
    val actual = getSneakyNumbers(nums)
    assertThat(actual).containsExactlyInAnyOrder(*expected)
}
