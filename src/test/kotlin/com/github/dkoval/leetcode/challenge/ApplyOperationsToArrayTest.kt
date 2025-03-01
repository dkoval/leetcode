package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ApplyOperationsToArray.*
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ApplyOperationsToArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments?>? = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 2, 1, 1, 0),
                intArrayOf(1, 4, 2, 0, 0, 0)
            ),
            Arguments.of(
                intArrayOf(0, 1),
                intArrayOf(1, 0)
            )
        )
    }

    @Nested
    inner class ApplyOperationsToArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the final array after performing all operations`(
            nums: IntArray,
            expected: IntArray
        ) {
            ApplyOperationsToArrayRev1().test(nums, expected)
        }
    }

    @Nested
    inner class ApplyOperationsToArrayRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the final array after performing all operations`(
            nums: IntArray,
            expected: IntArray
        ) {
            ApplyOperationsToArrayRev2().test(nums, expected)
        }
    }

    @Nested
    inner class ApplyOperationsToArrayRev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the final array after performing all operations`(
            nums: IntArray,
            expected: IntArray
        ) {
            ApplyOperationsToArrayRev3().test(nums, expected)
        }
    }
}

private fun ApplyOperationsToArray.test(nums: IntArray, expected: IntArray) {
    val actual = applyOperations(nums)
    assertArrayEquals(expected, actual)
}
