package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.TotalCharactersInStringAfterTransformations1.TotalCharactersInStringAfterTransformations1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class TotalCharactersInStringAfterTransformations1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abcyy",
                2,
                7
            ),
            Arguments.of(
                "azbk",
                1,
                5
            )
        )
    }

    @Nested
    inner class TotalCharactersInStringAfterTransformations1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the total number of characters in the string after transformations`(
            s: String,
            t: Int,
            expected: Int
        ) {
            TotalCharactersInStringAfterTransformations1Rev1().test(s, t, expected)
        }
    }
}

private fun TotalCharactersInStringAfterTransformations1.test(s: String, t: Int, expected: Int) {
    val actual = lengthAfterTransformations(s, t)
    assertEquals(expected, actual)
}
