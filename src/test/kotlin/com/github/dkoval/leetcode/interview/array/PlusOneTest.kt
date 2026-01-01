package com.github.dkoval.leetcode.interview.array

import com.github.dkoval.leetcode.mock.PlusOne
import com.github.dkoval.leetcode.mock.PlusOne.PlusOneJavaRev1
import com.github.dkoval.leetcode.mock.PlusOne.PlusOneJavaRev2
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PlusOneTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(intArrayOf(1, 2, 3), intArrayOf(1, 2, 4)),
            Arguments.of(intArrayOf(4, 3, 2, 1), intArrayOf(4, 3, 2, 2)),
            Arguments.of(intArrayOf(1, 2, 9, 9), intArrayOf(1, 3, 0, 0)),
            Arguments.of(intArrayOf(9), intArrayOf(1, 0)),
            Arguments.of(intArrayOf(9, 9), intArrayOf(1, 0, 0)),
            Arguments.of(intArrayOf(9, 9, 9), intArrayOf(1, 0, 0, 0))
        )
    }

    @Nested
    inner class PlusOneKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compute plus one to the integer`(digits: IntArray, expected: IntArray) {
            PlusOneKt.test(digits, expected)
        }
    }

    @Nested
    inner class PlusOneJavaRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compute plus one to the integer`(digits: IntArray, expected: IntArray) {
            PlusOneJavaRev1().test(digits, expected)
        }
    }

    @Nested
    inner class PlusOneJavaRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compute plus one to the integer`(digits: IntArray, expected: IntArray) {
            PlusOneJavaRev2().test(digits, expected)
        }
    }
}

private fun PlusOne.test(digits: IntArray, expected: IntArray) {
    val actual = plusOne(digits)
    assertArrayEquals(expected, actual)
}
