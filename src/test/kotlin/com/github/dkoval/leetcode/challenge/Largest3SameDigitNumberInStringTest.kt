package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.Largest3SameDigitNumberInString.Largest3SameDigitNumberInStringRev1
import com.github.dkoval.leetcode.challenge.Largest3SameDigitNumberInString.Largest3SameDigitNumberInStringRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class Largest3SameDigitNumberInStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "6777133339",
                "777"
            ),
            Arguments.of(
                "2300019",
                "000"
            ),
            Arguments.of(
                "42352338",
                ""
            )
        )
    }

    @Nested
    inner class Largest3SameDigitNumberInStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum good integer as a string or an empty string if no such integer exists`(
            num: String,
            expected: String
        ) {
            Largest3SameDigitNumberInStringRev1().test(num, expected)
        }
    }

    @Nested
    inner class Largest3SameDigitNumberInStringRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum good integer as a string or an empty string if no such integer exists`(
            num: String,
            expected: String
        ) {
            Largest3SameDigitNumberInStringRev2().test(num, expected)
        }
    }
}

private fun Largest3SameDigitNumberInString.test(num: String, expected: String) {
    val actual = largestGoodInteger(num)
    assertEquals(expected, actual)
}
