package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ValidateStackSequences.ValidateStackSequencesRev1
import com.github.dkoval.leetcode.challenge.ValidateStackSequences.ValidateStackSequencesRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ValidateStackSequencesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(4, 5, 3, 2, 1),
                true
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(4, 3, 5, 1, 2),
                false
            )
        )
    }

    @Nested
    inner class ValidateStackSequencesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate stack sequences`(pushed: IntArray, popped: IntArray, expected: Boolean) {
            ValidateStackSequencesRev1().test(pushed, popped, expected)
        }
    }

    @Nested
    inner class ValidateStackSequencesRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate stack sequences`(pushed: IntArray, popped: IntArray, expected: Boolean) {
            ValidateStackSequencesRev2().test(pushed, popped, expected)
        }
    }
}

private fun ValidateStackSequences.test(pushed: IntArray, popped: IntArray, expected: Boolean) {
    val actual = validateStackSequences(pushed, popped)
    assertEquals(expected, actual)
}
