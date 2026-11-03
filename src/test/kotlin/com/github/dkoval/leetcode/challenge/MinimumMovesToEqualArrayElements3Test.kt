package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumMovesToEqualArrayElements3.MinimumMovesToEqualArrayElements3Rev1
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

internal class MinimumMovesToEqualArrayElements3Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                intArrayOf(2, 1, 3),
                3
            ),
            arguments(
                intArrayOf(4, 4, 5),
                2
            )
        )
    }

    @Nested
    inner class MinimumMovesToEqualArrayElements3Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum total number of moves required so that all elements in nums become equal`(
            nums: IntArray,
            expected: Int
        ) {
            MinimumMovesToEqualArrayElements3Rev1().test(nums, expected)
        }
    }
}

private fun MinimumMovesToEqualArrayElements3Rev1.test(
    nums: IntArray,
    expected: Int
) {
    val actual = minMoves(nums)
    assertThat(actual).isEqualTo(expected)
}
