package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfSeniorCitizens.NumberOfSeniorCitizensRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfSeniorCitizensTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("7868190130M7522", "5303914400F9211", "9273338290F4010"),
                2
            ),
            Arguments.of(
                arrayOf("1313579440F2036", "2921522980M5644"),
                0
            )
        )
    }

    @Nested
    inner class NumberOfSeniorCitizensRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of passengers who are strictly more than 60 years old`(
            details: Array<String>,
            expected: Int
        ) {
            NumberOfSeniorCitizensRev1().test(details, expected)
        }
    }
}

private fun NumberOfSeniorCitizens.test(details: Array<String>, expected: Int) {
    val actual = countSeniors(details)
    assertEquals(expected, actual)
}
