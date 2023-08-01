package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.Combinations.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CombinationsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                4,
                2,
                listOf(
                    listOf(1, 2),
                    listOf(1, 3),
                    listOf(1, 4),
                    listOf(2, 3),
                    listOf(2, 4),
                    listOf(3, 4)
                )
            ),
            Arguments.of(
                1,
                1,
                listOf(
                    listOf(1)
                )
            ),
            Arguments.of(
                2,
                1,
                listOf(
                    listOf(1),
                    listOf(2)
                )
            )
        )
    }

    @Nested
    inner class CombinationsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible combinations of k numbers out of the range (1, n)`(
            n: Int,
            k: Int,
            expected: List<List<Int>>
        ) {
            CombinationsRev1().test(n, k, expected)
        }
    }

    @Nested
    inner class CombinationsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible combinations of k numbers out of the range (1, n)`(
            n: Int,
            k: Int,
            expected: List<List<Int>>
        ) {
            CombinationsRev2().test(n, k, expected)
        }
    }

    @Nested
    inner class CombinationsRev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible combinations of k numbers out of the range (1, n)`(
            n: Int,
            k: Int,
            expected: List<List<Int>>
        ) {
            CombinationsRev3().test(n, k, expected)
        }
    }
}

private fun Combinations.test(n: Int, k: Int, expected: List<List<Int>>) {
    val actual = combine(n, k)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
