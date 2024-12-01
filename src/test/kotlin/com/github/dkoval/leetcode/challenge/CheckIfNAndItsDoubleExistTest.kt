package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfNAndItsDoubleExist.CheckIfNAndItsDoubleExistRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CheckIfNAndItsDoubleExistTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(10, 2, 5, 3),
                true
            ),
            Arguments.of(
                intArrayOf(3, 1, 7, 11),
                false
            ),
            Arguments.of(
                intArrayOf(-10, 12, -20, -8, 15),
                true
            )
        )
    }

    @Nested
    inner class CheckIfNAndItsDoubleExistRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if n and its double exist`(arr: IntArray, expected: Boolean) {
            CheckIfNAndItsDoubleExistRev1().test(arr, expected)
        }
    }
}

private fun CheckIfNAndItsDoubleExist.test(arr: IntArray, expected: Boolean) {
    val actual = checkIfExist(arr)
    assertEquals(expected, actual)
}
