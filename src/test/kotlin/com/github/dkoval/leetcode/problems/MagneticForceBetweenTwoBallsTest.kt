package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.MagneticForceBetweenTwoBalls.MagneticForceBetweenTwoBallsUsingBinarySearchRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MagneticForceBetweenTwoBallsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 7),
                3,
                3
            ),
            Arguments.of(
                intArrayOf(5, 4, 3, 2, 1, 1000000000),
                2,
                999999999
            )
        )
    }

    @Nested
    inner class MagneticForceBetweenTwoBallsUsingBinarySearchRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the required force`(position: IntArray, m: Int, expected: Int) {
            MagneticForceBetweenTwoBallsUsingBinarySearchRev1().test(position, m, expected)
        }
    }

    private fun MagneticForceBetweenTwoBalls.test(position: IntArray, m: Int, expected: Int) {
        val actual = maxDistance(position, m)
        assertEquals(expected, actual)
    }
}