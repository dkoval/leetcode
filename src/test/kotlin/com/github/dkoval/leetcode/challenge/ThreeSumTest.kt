package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.problems.ThreeSum
import com.github.dkoval.leetcode.problems.ThreeSum.ThreeSumRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ThreeSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(-1, 0, 1, 2, -1, -4),
                listOf(
                    listOf(-1, -1, 2),
                    listOf(-1, 0, 1)
                )
            ),
            Arguments.of(
                intArrayOf(0, 1, 1),
                emptyList<Int>()
            ),
            Arguments.of(
                intArrayOf(0, 0, 0),
                listOf(
                    listOf(0, 0, 0)
                )
            ),
            Arguments.of(
                intArrayOf(-2, 0, 0, 2, 2),
                listOf(
                    listOf(-2, 0, 2)
                )
            ),
            Arguments.of(
                intArrayOf(-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0),
                listOf(
                    listOf(-5, 1, 4),
                    listOf(-4, 0, 4),
                    listOf(-4, 1, 3),
                    listOf(-2, -2, 4),
                    listOf(-2, 1, 1),
                    listOf(0, 0, 0)
                )
            )
        )
    }

    @Nested
    inner class ThreeSumRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find all unique triplets in the array which gives the sum of zero`(
            nums: IntArray,
            expected: List<List<Int>>
        ) {
            ThreeSumRev1().test(nums, expected)
        }
    }

    @Nested
    inner class ThreeSumRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find all unique triplets in the array which gives the sum of zero`(
            nums: IntArray,
            expected: List<List<Int>>
        ) {
            ThreeSumRev2.test(nums, expected)
        }
    }
}

private fun ThreeSum.test(nums: IntArray, expected: List<List<Int>>) {
    val actual = threeSum(nums)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
