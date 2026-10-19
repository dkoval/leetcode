package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindTargetIndicesAfterSortingArray.FindTargetIndicesAfterSortingArrayRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class FindTargetIndicesAfterSortingArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                intArrayOf(1, 2, 5, 2, 3),
                2,
                listOf(1, 2)
            ),
            arguments(
                intArrayOf(1, 2, 5, 2, 3),
                3,
                listOf(3)
            ),
            arguments(
                intArrayOf(1, 2, 5, 2, 3),
                5,
                listOf(4)
            )
        )
    }

    @Nested
    inner class FindTargetIndicesAfterSortingArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a list of the target indices of nums after sorting nums in non-decreasing order`(
            nums: IntArray,
            target: Int,
            expected: List<Int>
        ) {
            FindTargetIndicesAfterSortingArrayRev1().test(nums, target, expected)
        }
    }
}

private fun FindTargetIndicesAfterSortingArray.test(nums: IntArray, target: Int, expected: List<Int>) {
    val actual = targetIndices(nums, target)
    assertThat(actual).isEqualTo(expected)
}
