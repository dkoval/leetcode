package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SpecialArrayWithXElementGreaterThanOrEqualX.SpecialArrayWithXElementGreaterThanOrEqualXRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SpecialArrayWithXElementGreaterThanOrEqualXTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 5),
                2
            ),
            Arguments.of(
                intArrayOf(0, 0),
                -1
            ),
            Arguments.of(
                intArrayOf(0, 4, 3, 0, 4),
                3
            )
        )
    }

    @Nested
    inner class SpecialArrayWithXElementGreaterThanOrEqualXRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return x if the array is special, otherwise, return -1`(nums: IntArray, expected: Int) {
            SpecialArrayWithXElementGreaterThanOrEqualXRev1().test(nums, expected)
        }
    }
}

private fun SpecialArrayWithXElementGreaterThanOrEqualX.test(nums: IntArray, expected: Int) {
    val actual = specialArray(nums)
    assertEquals(expected, actual)
}
