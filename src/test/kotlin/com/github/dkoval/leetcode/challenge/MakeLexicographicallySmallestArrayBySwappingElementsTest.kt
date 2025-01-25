package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MakeLexicographicallySmallestArrayBySwappingElements.MakeLexicographicallySmallestArrayBySwappingElementsRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MakeLexicographicallySmallestArrayBySwappingElementsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 5, 3, 9, 8),
                2,
                intArrayOf(1, 3, 5, 8, 9)
            ),
            Arguments.of(
                intArrayOf(1, 7, 6, 18, 2, 1),
                3,
                intArrayOf(1, 6, 7, 18, 1, 2)
            ),
            Arguments.of(
                intArrayOf(1, 7, 28, 19, 10),
                3,
                intArrayOf(1, 7, 28, 19, 10)
            )
        )
    }

    @Nested
    inner class MakeLexicographicallySmallestArrayBySwappingElementsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the lexicographically smallest array `(nums: IntArray, limit: Int, expected: IntArray) {
            MakeLexicographicallySmallestArrayBySwappingElementsRev1().test(nums, limit, expected)
        }
    }
}

private fun MakeLexicographicallySmallestArrayBySwappingElements.test(nums: IntArray, limit: Int, expected: IntArray) {
    val actual = lexicographicallySmallestArray(nums, limit)
    assertArrayEquals(expected, actual)
}
