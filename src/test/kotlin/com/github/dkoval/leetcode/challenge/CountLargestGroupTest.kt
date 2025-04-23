package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountLargestGroup.CountLargestGroupRev1
import com.github.dkoval.leetcode.challenge.CountLargestGroup.CountLargestGroupRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountLargestGroupTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                13,
                4
            ),
            Arguments.of(
                2,
                2
            )
        )
    }

    @Nested
    inner class CountLargestGroupRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of groups with the largest size`(n: Int, expected: Int) {
            CountLargestGroupRev1().test(n, expected)
        }
    }

    @Nested
    inner class CountLargestGroupRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of groups with the largest size`(n: Int, expected: Int) {
            CountLargestGroupRev2().test(n, expected)
        }
    }
}

private fun CountLargestGroup.test(n: Int, expected: Int) {
    val actual = countLargestGroup(n)
    assertEquals(expected, actual)
}
