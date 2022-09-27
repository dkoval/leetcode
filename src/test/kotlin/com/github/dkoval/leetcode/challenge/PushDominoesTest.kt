package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PushDominoes.PushDominoesRev1
import com.github.dkoval.leetcode.challenge.PushDominoes.PushDominoesRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PushDominoesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "RR.L",
                "RR.L"
            ),
            Arguments.of(
                ".L.R...LR..L..",
                "LL.RR.LLRRLL.."
            ),
            Arguments.of(
                "L.....RR.RL.....L.R.",
                "L.....RRRRLLLLLLL.RR"
            )
        )
    }

    @Nested
    inner class PushDominoesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return string representing the final state after dominoes were pushed`(
            dominoes: String,
            expected: String
        ) {
            PushDominoesRev1().test(dominoes, expected)
        }
    }

    @Nested
    inner class PushDominoesRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return string representing the final state after dominoes were pushed`(
            dominoes: String,
            expected: String
        ) {
            PushDominoesRev2().test(dominoes, expected)
        }
    }

    private fun PushDominoes.test(dominoes: String, expected: String) {
        val actual = pushDominoes(dominoes)
        assertEquals(expected, actual)
    }
}