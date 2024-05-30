package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountTripletsThatCanFormTwoArraysOfEqualXOR.CountTripletsThatCanFormTwoArraysOfEqualXORRev1
import com.github.dkoval.leetcode.challenge.CountTripletsThatCanFormTwoArraysOfEqualXOR.CountTripletsThatCanFormTwoArraysOfEqualXORRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountTripletsThatCanFormTwoArraysOfEqualXORTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 3, 1, 6, 7),
                4
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 1, 1),
                10
            )
        )
    }

    @Nested
    inner class CountTripletsThatCanFormTwoArraysOfEqualXORRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of triplets`(arr: IntArray, expected: Int) {
            CountTripletsThatCanFormTwoArraysOfEqualXORRev1().test(arr, expected)
        }
    }

    @Nested
    inner class CountTripletsThatCanFormTwoArraysOfEqualXORRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of triplets`(arr: IntArray, expected: Int) {
            CountTripletsThatCanFormTwoArraysOfEqualXORRev2().test(arr, expected)
        }
    }
}

private fun CountTripletsThatCanFormTwoArraysOfEqualXOR.test(arr: IntArray, expected: Int) {
    val actual = countTriplets(arr)
    assertEquals(expected, actual)
}
