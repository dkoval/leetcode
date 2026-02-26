package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfStepsToReduceNumberInBinaryRepresentationToOne.NumberOfStepsToReduceNumberInBinaryRepresentationToOneRev1
import com.github.dkoval.leetcode.challenge.NumberOfStepsToReduceNumberInBinaryRepresentationToOne.NumberOfStepsToReduceNumberInBinaryRepresentationToOneRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfStepsToReduceNumberInBinaryRepresentationToOneTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("1101", 6),
            Arguments.of("10", 1),
            Arguments.of("1", 0),
            Arguments.of("11000", 6),
            Arguments.of("1110", 5)
        )
    }

    @Nested
    inner class NumberOfStepsToReduceNumberInBinaryRepresentationToOneRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of steps to reduce it to 1`(s: String, expected: Int) {
            NumberOfStepsToReduceNumberInBinaryRepresentationToOneRev1().test(s, expected)
        }
    }

    @Nested
    inner class NumberOfStepsToReduceNumberInBinaryRepresentationToOneRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of steps to reduce it to 1`(s: String, expected: Int) {
            NumberOfStepsToReduceNumberInBinaryRepresentationToOneRev2().test(s, expected)
        }
    }
}

private fun NumberOfStepsToReduceNumberInBinaryRepresentationToOne.test(s: String, expected: Int) {
    val actual = numSteps(s)
    assertEquals(expected, actual)
}
