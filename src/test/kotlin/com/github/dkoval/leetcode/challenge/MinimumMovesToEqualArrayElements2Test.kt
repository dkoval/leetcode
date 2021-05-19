package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumMovesToEqualArrayElements2.MinimumMovesToEqualArrayElements2BruteForce
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumMovesToEqualArrayElements2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3),
                2
            ),
            Arguments.of(
                intArrayOf(1, 10, 2, 9),
                16
            ),
            Arguments.of(
                intArrayOf(
                    203125577,
                    -349566234,
                    230332704,
                    48321315,
                    66379082,
                    386516853,
                    50986744,
                    -250908656,
                    -425653504,
                    -212123143
                ),
                2127271182
            )
        )

    }

    @Nested
    inner class MinimumMovesToEqualArrayElements2BruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of moves required to make all array elements equal`(
            nums: IntArray,
            expected: Int
        ) {
            MinimumMovesToEqualArrayElements2BruteForce().test(nums, expected)
        }
    }

    private fun MinimumMovesToEqualArrayElements2.test(nums: IntArray, expected: Int) {
        val actual = minMoves2(nums)
        assertEquals(expected, actual)
    }
}