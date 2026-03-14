package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.KthLexicographicalStringOfAllHappyStringsOfLengthN.KthLexicographicalStringOfAllHappyStringsOfLengthNRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class KthLexicographicalStringOfAllHappyStringsOfLengthNTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> {
            return Stream.of(
                arguments(1, 3, "c"),
                arguments(1, 4, ""),
                arguments(3, 9, "cab")
            )
        }
    }

    @Nested
    inner class KthLexicographicalStringOfAllHappyStringsOfLengthNRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the k-th lexicographically smallest happy string of length n`(
            n: Int,
            k: Int,
            expected: String
        ) {
            KthLexicographicalStringOfAllHappyStringsOfLengthNRev1().test(n, k, expected)
        }
    }
}

private fun KthLexicographicalStringOfAllHappyStringsOfLengthN.test(n: Int, k: Int, expected: String) {
    val actual = getHappyString(n, k)
    assertEquals(expected, actual)
}
