package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.TupleWithSameProduct.TupleWithSameProductRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class TupleWithSameProductTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 3, 4, 6),
                8
            ),
            Arguments.of(
                intArrayOf(1, 2, 4, 5, 10),
                16
            ),
            Arguments.of(
                intArrayOf(2, 3, 4, 6, 8, 12),
                40
            )
        )
    }

    @Nested
    inner class TupleWithSameProductRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the number of tuples (a, b, c, d) such that a x b = c x d`(nums: IntArray, expected: Int) {
            TupleWithSameProductRev1().test(nums, expected)
        }
    }
}

private fun TupleWithSameProduct.test(nums: IntArray, expected: Int) {
    val actual = tupleSameProduct(nums)
    assertEquals(expected, actual)
}
