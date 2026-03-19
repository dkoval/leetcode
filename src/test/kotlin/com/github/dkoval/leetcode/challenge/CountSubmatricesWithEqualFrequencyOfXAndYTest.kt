package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountSubmatricesWithEqualFrequencyOfXAndY.CountSubmatricesWithEqualFrequencyOfXAndYRev1
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

internal class CountSubmatricesWithEqualFrequencyOfXAndYTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                arrayOf(
                    charArrayOf('X', 'Y', '.'),
                    charArrayOf('Y', '.', '.')
                ),
                3
            ),
            arguments(
                arrayOf(
                    charArrayOf('X', 'X'),
                    charArrayOf('X', 'Y')
                ),
                0
            ),
            arguments(
                arrayOf(
                    charArrayOf('.', '.'),
                    charArrayOf('.', '.')
                ),
                0
            )
        )
    }

    @Nested
    inner class CountSubmatricesWithEqualFrequencyOfXAndYRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of submatrices that have an equal number of 'X' and 'Y' characters`(
            grid: Array<CharArray>,
            expected: Int
        ) {
            CountSubmatricesWithEqualFrequencyOfXAndYRev1().test(grid, expected)
        }
    }
}

private fun CountSubmatricesWithEqualFrequencyOfXAndY.test(grid: Array<CharArray>, expected: Int) {
    val actual = numberOfSubmatrices(grid)
    assertEquals(expected, actual)
}
