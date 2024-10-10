package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumWidthRamp.MaximumWidthRampRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumWidthRampTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(6, 0, 8, 2, 1, 5),
                4
            ),
            Arguments.of(
                intArrayOf(9, 8, 1, 0, 1, 9, 4, 0, 4, 1),
                7
            )
        )
    }

    @Nested
    inner class MaximumWidthRampRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum width of a ramp in nums`(nums: IntArray, expected: Int) {
            MaximumWidthRampRev1().test(nums, expected)
        }
    }
}

private fun MaximumWidthRamp.test(nums: IntArray, expected: Int) {
    val actual = maxWidthRamp(nums)
    assertEquals(expected, actual)
}
