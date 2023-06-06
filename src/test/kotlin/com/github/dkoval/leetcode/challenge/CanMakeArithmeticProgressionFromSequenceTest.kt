package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CanMakeArithmeticProgressionFromSequence.CanMakeArithmeticProgressionFromSequenceRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CanMakeArithmeticProgressionFromSequenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 5, 1),
                true
            ),
            Arguments.of(
                intArrayOf(1, 2, 4),
                false
            )
        )
    }

    @Nested
    inner class CanMakeArithmeticProgressionFromSequenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if the array can be rearranged to form an arithmetic progression`(
            arr: IntArray,
            expected: Boolean
        ) {
            CanMakeArithmeticProgressionFromSequenceRev1().test(arr, expected)
        }
    }
}

private fun CanMakeArithmeticProgressionFromSequence.test(arr: IntArray, expected: Boolean) {
    val actual = canMakeArithmeticProgression(arr)
    assertEquals(expected, actual)
}
