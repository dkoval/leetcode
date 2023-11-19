package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ReductionOperationsToMakeArrayElementsEqual.ReductionOperationsToMakeArrayElementsEqualRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ReductionOperationsToMakeArrayElementsEqualTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 1, 3),
                3
            ),
            Arguments.of(
                intArrayOf(1, 1, 1),
                0
            ),
            Arguments.of(
                intArrayOf(1, 1, 2, 2, 3),
                4
            )
        )
    }

    @Nested
    inner class ReductionOperationsToMakeArrayElementsEqualRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of operations to make all elements in nums equal`(nums: IntArray, expected: Int) {
            ReductionOperationsToMakeArrayElementsEqualRev1().test(nums, expected)
        }
    }
}

private fun ReductionOperationsToMakeArrayElementsEqual.test(nums: IntArray, expected: Int) {
    val actual = reductionOperations(nums)
    assertEquals(expected, actual)
}
