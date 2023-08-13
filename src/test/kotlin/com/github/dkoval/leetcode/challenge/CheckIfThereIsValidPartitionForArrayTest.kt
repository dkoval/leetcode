package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfThereIsValidPartitionForArray.CheckIfThereIsValidPartitionForArrayDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CheckIfThereIsValidPartitionForArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 4, 4, 5, 6),
                true
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 2),
                false
            )
        )
    }

    @Nested
    inner class CheckIfThereIsValidPartitionForArrayDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if the array has at least one valid partition`(nums: IntArray, expected: Boolean) {
            CheckIfThereIsValidPartitionForArrayDPTopDown().test(nums, expected)
        }
    }
}

private fun CheckIfThereIsValidPartitionForArray.test(nums: IntArray, expected: Boolean) {
    val actual = validPartition(nums)
    assertEquals(expected, actual)
}
