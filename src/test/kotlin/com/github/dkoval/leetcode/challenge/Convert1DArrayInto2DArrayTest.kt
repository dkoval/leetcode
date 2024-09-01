package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.Convert1DArrayInto2DArray.Convert1DArrayInto2DArrayRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class Convert1DArrayInto2DArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                2,
                2,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 4)
                )
            ),
            Arguments.of(
                intArrayOf(1, 2, 3),
                1,
                3,
                arrayOf(
                    intArrayOf(1, 2, 3)
                )
            ),
            Arguments.of(
                intArrayOf(1, 2),
                1,
                1,
                emptyArray<IntArray>()
            )
        )
    }

    @Nested
    inner class Convert1DArrayInto2DArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should convert 1D array into 2D array`(
            original: IntArray,
            m: Int,
            n: Int,
            expected: Array<IntArray>
        ) {
            Convert1DArrayInto2DArrayRev1().test(original, m, n, expected)
        }
    }
}

private fun Convert1DArrayInto2DArray.test(original: IntArray, m: Int, n: Int, expected: Array<IntArray>) {
    val actual = construct2DArray(original, m, n)
    assertArrayEquals(expected, actual)
}
