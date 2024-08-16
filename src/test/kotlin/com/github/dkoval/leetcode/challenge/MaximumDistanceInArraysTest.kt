package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumDistanceInArrays.MaximumDistanceInArraysRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumDistanceInArraysTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    listOf(1, 2, 3),
                    listOf(4, 5),
                    listOf(1, 2, 3)
                ),
                4
            ),
            Arguments.of(
                listOf(
                    listOf(1, 4),
                    listOf(0, 5)
                ),
                4
            ),
            Arguments.of(
                listOf(
                    listOf(1, 4, 5),
                    listOf(0, 2)
                ),
                5
            )
        )
    }

    @Nested
    inner class MaximumDistanceInArraysRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the maximum distance in arrays`(arrays: List<List<Int>>, expected: Int) {
            MaximumDistanceInArraysRev1().test(arrays, expected)
        }
    }

    @Nested
    inner class MaximumDistanceInArraysKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the maximum distance in arrays`(arrays: List<List<Int>>, expected: Int) {
            MaximumDistanceInArraysKt.test(arrays, expected)
        }
    }
}

private fun MaximumDistanceInArrays.test(arrays: List<List<Int>>, expected: Int) {
    val actual = maxDistance(arrays)
    assertEquals(expected, actual)
}
