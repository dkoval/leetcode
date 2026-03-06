package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfBinaryStringHasAtMostOneSegmentOfOnes.CheckIfBinaryStringHasAtMostOneSegmentOfOnesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class CheckIfBinaryStringHasAtMostOneSegmentOfOnesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "1001",
                false
            ),
            Arguments.of(
                "110",
                true
            ),
            Arguments.of(
                "1",
                true
            )
        )
    }

    @Nested
    inner class CheckIfBinaryStringHasAtMostOneSegmentOfOnesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if s contains at most one contiguous segment of ones`(
            s: String,
            expected: Boolean
        ) {
            CheckIfBinaryStringHasAtMostOneSegmentOfOnesRev1().test(s, expected)
        }
    }
}

private fun CheckIfBinaryStringHasAtMostOneSegmentOfOnes.test(s: String, expected: Boolean) {
    val actual = checkOnesSegment(s)
    assertEquals(expected, actual)
}
