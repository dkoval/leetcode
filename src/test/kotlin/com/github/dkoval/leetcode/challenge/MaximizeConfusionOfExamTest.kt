package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximizeConfusionOfExam.MaximizeConfusionOfExamRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximizeConfusionOfExamTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("TTFF", 2, 4),
            Arguments.of("TFFT", 1, 3),
            Arguments.of("TTFTTFTT", 1, 5),
            Arguments.of("FFFTTFTTFT", 3, 8)
        )
    }

    @Nested
    inner class MaximizeConfusionOfExamRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should maximize the confusion of an exam`(answerKey: String, k: Int, expected: Int) {
            MaximizeConfusionOfExamRev1().test(answerKey, k, expected)
        }
    }
}

private fun MaximizeConfusionOfExam.test(answerKey: String, k: Int, expected: Int) {
    val actual = maxConsecutiveAnswers(answerKey, k)
    assertEquals(expected, actual)
}
