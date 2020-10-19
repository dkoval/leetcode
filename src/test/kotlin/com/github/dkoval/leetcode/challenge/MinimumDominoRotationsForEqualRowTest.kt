package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumDominoRotationsForEqualRowTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 1, 2, 4, 2, 2),
                intArrayOf(5, 2, 6, 2, 3, 2),
                2
            ),
            Arguments.of(
                intArrayOf(3, 5, 1, 2, 3),
                intArrayOf(3, 6, 3, 3, 4),
                -1
            )
        )
    }

    @Nested
    inner class MinimumDominoRotationsForEqualRowGreedyWithFourCheckTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same`() {

        }
    }
}