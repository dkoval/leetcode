package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PatchingArray.PatchingArrayRev1
import com.github.dkoval.leetcode.challenge.PatchingArray.PatchingArrayRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PatchingArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3),
                6,
                // add 2
                1
            ),
            Arguments.of(
                intArrayOf(1, 5, 10),
                20,
                // add 2, 4
                2
            ),
            Arguments.of(
                intArrayOf(1, 2, 2),
                5,
                0
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 9),
                45,
                2
            ),
            Arguments.of(
                intArrayOf(1, 2, 2, 6, 34, 38, 41, 44, 47, 56, 59, 62, 73, 77, 83, 87, 89, 94),
                20,
                1
            ),
            Arguments.of(
                intArrayOf(1, 2, 31, 33),
                2147483647,
                28
            )
        )
    }

    @Nested
    inner class PatchingArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of patches required`(nums: IntArray, n: Int, expected: Int) {
            PatchingArrayRev1().test(nums, n, expected)
        }
    }

    @Nested
    inner class PatchingArrayRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of patches required`(nums: IntArray, n: Int, expected: Int) {
            PatchingArrayRev2().test(nums, n, expected)
        }
    }
}

private fun PatchingArray.test(nums: IntArray, n: Int, expected: Int) {
    val actual = minPatches(nums, n)
    assertEquals(expected, actual)
}
