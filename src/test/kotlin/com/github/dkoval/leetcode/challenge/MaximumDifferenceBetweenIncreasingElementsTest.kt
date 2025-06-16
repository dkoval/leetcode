package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumDifferenceBetweenIncreasingElements.MaximumDifferenceBetweenIncreasingElementsRev1
import com.github.dkoval.leetcode.challenge.MaximumDifferenceBetweenIncreasingElements.MaximumDifferenceBetweenIncreasingElementsRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumDifferenceBetweenIncreasingElementsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(7, 1, 5, 4),
                4
            ),
            Arguments.of(
                intArrayOf(9, 4, 3, 2),
                -1
            ),
            Arguments.of(
                intArrayOf(1, 5, 2, 10),
                9
            )
        )
    }

    @Nested
    inner class MaximumDifferenceBetweenIncreasingElementsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum difference between increasing elements`(
            nums: IntArray,
            expected: Int
        ) {
            MaximumDifferenceBetweenIncreasingElementsRev1().test(nums, expected)
        }
    }

    @Nested
    inner class MaximumDifferenceBetweenIncreasingElementsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum difference between increasing elements`(
            nums: IntArray,
            expected: Int
        ) {
            MaximumDifferenceBetweenIncreasingElementsRev2().test(nums, expected)
        }
    }
}

private fun MaximumDifferenceBetweenIncreasingElements.test(nums: IntArray, expected: Int) {
    val actual = maximumDifference(nums)
    assertEquals(expected, actual)
}
