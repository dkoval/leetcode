package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfArrayIsGood.CheckIfArrayIsGoodRev1
import com.github.dkoval.leetcode.challenge.CheckIfArrayIsGood.CheckIfArrayIsGoodRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class CheckIfArrayIsGoodTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 1, 3),
                false
            ),
            Arguments.of(
                intArrayOf(1, 3, 3, 2),
                true
            ),
            Arguments.of(
                intArrayOf(1, 1),
                true
            ),
            Arguments.of(
                intArrayOf(3, 4, 4, 1, 2, 1),
                false
            ),
            Arguments.of(
                intArrayOf(5, 7, 3, 1, 5, 2, 6, 4),
                false
            ),
            Arguments.of(
                intArrayOf(1),
                false
            ),
            Arguments.of(
                intArrayOf(9, 9),
                false
            )
        )
    }

    @Nested
    inner class CheckIfArrayIsGoodRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if the array is good or false otherwise`(nums: IntArray, expected: Boolean) {
            CheckIfArrayIsGoodRev1().test(nums, expected)
        }
    }

    @Nested
    inner class CheckIfArrayIsGoodRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if the array is good or false otherwise`(nums: IntArray, expected: Boolean) {
            CheckIfArrayIsGoodRev2().test(nums, expected)
        }
    }
}

private fun CheckIfArrayIsGood.test(nums: IntArray, expected: Boolean) {
    val actual = isGood(nums)
    assertEquals(expected, actual)
}
