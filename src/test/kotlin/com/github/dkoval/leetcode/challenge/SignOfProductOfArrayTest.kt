package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SignOfProductOfArray.SignOfProductOfArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class SignOfProductOfArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(-1, -2, -3, -4, 3, 2, 1),
                1
            ),
            Arguments.of(
                intArrayOf(1, 5, 0, 2, -3),
                0
            ),
            Arguments.of(
                intArrayOf(-1, 1, -1, 1, -1),
                -1
            )
        )
    }

    @Nested
    inner class SignOfProductOfArrayTestRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the sign of the product of an array`(nums: IntArray, expected: Int) {
            SignOfProductOfArrayRev1().test(nums, expected)
        }
    }
}

private fun SignOfProductOfArray.test(nums: IntArray, expected: Int) {
    val actual = arraySign(nums)
    assertEquals(expected, actual)
}
