package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DistributeElementsIntoTwoArrays1.DistributeElementsIntoTwoArrays1Rev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class DistributeElementsIntoTwoArrays1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 1, 3),
                intArrayOf(2, 3, 1)
            ),
            Arguments.of(
                intArrayOf(5, 4, 3, 8),
                intArrayOf(5, 3, 4, 8)
            )
        )
    }

    @Nested
    inner class DistributeElementsIntoTwoArrays1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the two arrays after distributing the elements`(nums: IntArray, expected: IntArray) {
            DistributeElementsIntoTwoArrays1Rev1().test(nums, expected)
        }
    }
}

private fun DistributeElementsIntoTwoArrays1.test(nums: IntArray, expected: IntArray) {
    val actual = resultArray(nums)
    assertArrayEquals(expected, actual)
}
