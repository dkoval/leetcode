package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfTwoStringArraysAreEquivalent.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CheckIfTwoStringArraysAreEquivalentTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("ab", "c"),
                arrayOf("a", "bc"),
                true
            ),
            Arguments.of(
                arrayOf("a", "cb"),
                arrayOf("ab", "c"),
                false
            ),
            Arguments.of(
                arrayOf("abc", "d", "defg"),
                arrayOf("abcddefg"),
                true
            )
        )
    }

    abstract class BaseCheckIfTwoStringArraysAreEquivalentTestSupport(
        private val solution: CheckIfTwoStringArraysAreEquivalent
    ) {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if two string arrays are equivalent`(
            word1: Array<String>,
            word2: Array<String>,
            expected: Boolean
        ) {
            val actual = solution.arrayStringsAreEqual(word1, word2)
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class CheckIfTwoStringArraysAreEquivalentRev1Test :
        BaseCheckIfTwoStringArraysAreEquivalentTestSupport(CheckIfTwoStringArraysAreEquivalentRev1())

    @Nested
    inner class CheckIfTwoStringArraysAreEquivalentRev2Test :
        BaseCheckIfTwoStringArraysAreEquivalentTestSupport(CheckIfTwoStringArraysAreEquivalentRev2())

    @Nested
    inner class CheckIfTwoStringArraysAreEquivalentRev3Test :
        BaseCheckIfTwoStringArraysAreEquivalentTestSupport(CheckIfTwoStringArraysAreEquivalentRev3())
}