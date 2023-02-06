package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ShuffleArray.ShuffleArrayInplace
import com.github.dkoval.leetcode.challenge.ShuffleArray.ShuffleArrayNaive
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ShuffleArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 5, 1, 3, 4, 7),
                3,
                intArrayOf(2, 3, 5, 4, 1, 7)
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 4, 3, 2, 1),
                4,
                intArrayOf(1, 4, 2, 3, 3, 2, 4, 1)
            ),
            Arguments.of(
                intArrayOf(1, 1, 2, 2),
                2,
                intArrayOf(1, 2, 1, 2)
            )
        )
    }

    @Nested
    inner class ShuffleArrayNaiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should shuffle the array`(nums: IntArray, n: Int, expected: IntArray) {
            ShuffleArrayNaive().test(nums, n, expected)
        }
    }

    @Nested
    inner class ShuffleArrayInplaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should shuffle the array`(nums: IntArray, n: Int, expected: IntArray) {
            ShuffleArrayInplace().test(nums, n, expected)
        }
    }
}

private fun ShuffleArray.test(nums: IntArray, n: Int, expected: IntArray) {
    val actual = shuffle(nums, n)
    assertArrayEquals(expected, actual)
}
