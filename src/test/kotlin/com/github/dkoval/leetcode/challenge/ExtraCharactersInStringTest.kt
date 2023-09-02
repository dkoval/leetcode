package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ExtraCharactersInString.ExtraCharactersInStringDPTopDownRev1
import com.github.dkoval.leetcode.challenge.ExtraCharactersInString.ExtraCharactersInStringDPTopDownRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ExtraCharactersInStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "leetscode",
                arrayOf("leet", "code", "leetcode"),
                1
            ),
            Arguments.of(
                "sayhelloworld",
                arrayOf("hello", "world"),
                3
            )
        )
    }

    @Nested
    inner class ExtraCharactersInStringDPTopDownRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of extra characters left over if you break up s optimally`(
            s: String,
            dictionary: Array<String>,
            expected: Int
        ) {
            ExtraCharactersInStringDPTopDownRev1().test(s, dictionary, expected)
        }
    }

    @Nested
    inner class ExtraCharactersInStringDPTopDownRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of extra characters left over if you break up s optimally`(
            s: String,
            dictionary: Array<String>,
            expected: Int
        ) {
            ExtraCharactersInStringDPTopDownRev2().test(s, dictionary, expected)
        }
    }
}

private fun ExtraCharactersInString.test(s: String, dictionary: Array<String>, expected: Int) {
    val actual = minExtraChar(s, dictionary)
    assertEquals(expected, actual)
}
