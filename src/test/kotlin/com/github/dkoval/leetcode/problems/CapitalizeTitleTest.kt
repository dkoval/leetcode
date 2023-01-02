package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.CapitalizeTitle.CapitalizeTitleRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CapitalizeTitleTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("First leTTeR of EACH Word", "First Letter of Each Word"),
            Arguments.of("i lOve leetcode", "i Love Leetcode")
        )
    }

    @Nested
    inner class CapitalizeTitleRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the capitalized title`(title: String, expected: String) {
            CapitalizeTitleRev1().test(title, expected)
        }
    }

    private fun CapitalizeTitle.test(title: String, expected: String) {
        val actual = capitalizeTitle(title)
        assertEquals(expected, actual)
    }
}