package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LetterCombinationsOfPhoneNumber.LetterCombinationsOfPhoneNumberRev1
import com.github.dkoval.leetcode.challenge.LetterCombinationsOfPhoneNumber.LetterCombinationsOfPhoneNumberRev2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LetterCombinationsOfPhoneNumberTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "",
                listOf<String>()
            ),
            Arguments.of(
                "2",
                listOf("a", "b", "c")
            ),
            Arguments.of(
                "23",
                listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
            )
        )
    }

    @Nested
    inner class LetterCombinationsOfPhoneNumberRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible letter combinations that the number could represent`(
            digits: String,
            expected: List<String>
        ) {
            LetterCombinationsOfPhoneNumberRev1().test(digits, expected)
        }
    }

    @Nested
    inner class LetterCombinationsOfPhoneNumberRev2Test {


        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible letter combinations that the number could represent`(
            digits: String,
            expected: List<String>
        ) {
            LetterCombinationsOfPhoneNumberRev2().test(digits, expected)
        }
    }
}

private fun LetterCombinationsOfPhoneNumber.test(digits: String, expected: List<String>) {
    val actual = letterCombinations(digits)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
