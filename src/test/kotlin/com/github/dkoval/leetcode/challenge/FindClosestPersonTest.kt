package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindClosestPerson.FindClosestPersonRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindClosestPersonTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(2, 7, 4, 1),
            Arguments.of(2, 5, 6, 2),
            Arguments.of(1, 5, 3, 0)
        )
    }

    @Nested
    inner class FindClosestPersonRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the closest person`(n: Int, a: Int, b: Int, expected: Int) {
            FindClosestPersonRev1().test(n, a, b, expected)
        }
    }
}

private fun FindClosestPerson.test(n: Int, a: Int, b: Int, expected: Int) {
    val actual = findClosest(n, a, b)
    assertEquals(expected, actual)
}
