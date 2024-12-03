package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.AddingSpacesToString.AddingSpacesToStringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AddingSpacesToStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "LeetcodeHelpsMeLearn",
                intArrayOf(8, 13, 15),
                "Leetcode Helps Me Learn"
            ),
            Arguments.of(
                "icodeinpython",
                intArrayOf(1, 5, 7, 9),
                "i code in py thon"
            ),
            Arguments.of(
                "spacing",
                intArrayOf(0, 1, 2, 3, 4, 5, 6),
                " s p a c i n g"
            )
        )
    }

    @Nested
    inner class AddingSpacesToStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the modified string after the spaces have been added`(
            s: String,
            spaces: IntArray,
            expected: String
        ) {
            AddingSpacesToStringRev1().test(s, spaces, expected)
        }
    }
}

private fun AddingSpacesToString.test(s: String, spaces: IntArray, expected: String) {
    val actual = addSpaces(s, spaces)
    assertEquals(expected, actual)
}
