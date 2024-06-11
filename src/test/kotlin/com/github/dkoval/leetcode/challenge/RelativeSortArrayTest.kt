package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RelativeSortArray.RelativeSortArrayRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RelativeSortArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19),
                intArrayOf(2, 1, 4, 3, 9, 6),
                intArrayOf(2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19)
            ),
            Arguments.of(
                intArrayOf(28, 6, 22, 8, 44, 17),
                intArrayOf(22, 28, 8, 6),
                intArrayOf(22, 28, 8, 6, 17, 44)
            )
        )
    }

    @Nested
    inner class RelativeSortArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2`(
            arr1: IntArray,
            arr2: IntArray,
            expected: IntArray
        ) {
            RelativeSortArrayRev1().test(arr1, arr2, expected)
        }
    }
}

private fun RelativeSortArray.test(arr1: IntArray, arr2: IntArray, expected: IntArray) {
    val actual = relativeSortArray(arr1, arr2)
    assertArrayEquals(expected, actual)
}
