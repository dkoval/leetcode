package com.github.dkoval.leetcode.interview.array

import com.github.dkoval.leetcode.interview.array.ContainerWithMostWater.ContainerWithMostWaterBruteForce
import com.github.dkoval.leetcode.interview.array.ContainerWithMostWater.ContainerWithMostWaterTwoPointers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ContainerWithMostWaterTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 1),
                1
            ),
            Arguments.of(
                intArrayOf(4, 3, 2, 1, 4),
                16
            ),
            Arguments.of(
                intArrayOf(1, 2, 1),
                2
            ),
            Arguments.of(
                intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7),
                49
            )
        )
    }

    @Nested
    inner class ContainerWithMostWaterBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find container with most water`(height: IntArray, expected: Int) {
            ContainerWithMostWaterBruteForce().test(height, expected)
        }
    }

    @Nested
    inner class ContainerWithMostWaterTwoPointersTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find container with most water`(height: IntArray, expected: Int) {
            ContainerWithMostWaterTwoPointers().test(height, expected)
        }
    }
}

private fun ContainerWithMostWater.test(height: IntArray, expected: Int) {
    val actual = maxArea(height)
    assertEquals(expected, actual)
}
