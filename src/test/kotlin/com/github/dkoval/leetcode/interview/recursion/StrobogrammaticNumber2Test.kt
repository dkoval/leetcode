package com.github.dkoval.leetcode.interview.recursion

import com.github.dkoval.leetcode.interview.recursion.StrobogrammaticNumber2.StrobogrammaticNumber2Recursive
import com.github.dkoval.leetcode.interview.recursion.StrobogrammaticNumber2.StrobogrammaticNumber2RecursiveOvercomplicated
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class StrobogrammaticNumber2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                1,
                listOf("0", "1", "8")
            ),
            Arguments.of(
                2,
                listOf("11", "69", "88", "96")
            ),
            Arguments.of(
                3,
                listOf("101", "111", "181", "609", "619", "689", "808", "818", "888", "906", "916", "986")
            ),
            Arguments.of(
                4,
                listOf(
                    "1001",
                    "1111",
                    "1691",
                    "1881",
                    "1961",
                    "6009",
                    "6119",
                    "6699",
                    "6889",
                    "6969",
                    "8008",
                    "8118",
                    "8698",
                    "8888",
                    "8968",
                    "9006",
                    "9116",
                    "9696",
                    "9886",
                    "9966"
                )
            )
        )
    }

    @Nested
    inner class StrobogrammaticNumber2RecursiveOvercomplicatedTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `find all strobogrammatic numbers that are of length n`(n: Int, expected: List<String>) {
            StrobogrammaticNumber2RecursiveOvercomplicated().test(n, expected)
        }
    }

    @Nested
    inner class StrobogrammaticNumber2RecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `find all strobogrammatic numbers that are of length n`(n: Int, expected: List<String>) {
            StrobogrammaticNumber2Recursive().test(n, expected)
        }
    }

    private fun StrobogrammaticNumber2.test(n: Int, expected: List<String>) {
        val actual = findStrobogrammatic(n)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}