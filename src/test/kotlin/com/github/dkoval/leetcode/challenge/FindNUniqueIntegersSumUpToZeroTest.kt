package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindNUniqueIntegersSumUpToZero.FindNUniqueIntegersSumUpToZeroRev1
import com.github.dkoval.leetcode.challenge.FindNUniqueIntegersSumUpToZero.FindNUniqueIntegersSumUpToZeroRev2
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindNUniqueIntegersSumUpToZeroTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(5),
            Arguments.of(3),
            Arguments.of(1)
        )
    }

    @Nested
    inner class FindNUniqueIntegersSumUpToZeroRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return any array of n unique integers such that they add up to 0`(n: Int) {
            FindNUniqueIntegersSumUpToZeroRev1().test(n)
        }
    }

    @Nested
    inner class FindNUniqueIntegersSumUpToZeroRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return any array of n unique integers such that they add up to 0`(n: Int) {
            FindNUniqueIntegersSumUpToZeroRev2().test(n)
        }
    }
}

private fun FindNUniqueIntegersSumUpToZero.test(n: Int) {
    val actual = sumZero(n)
    // verify that the size of the resulting array is correct
    assert(actual.size == n)
    // verify that all elements are unique
    assert(actual.toSet().size == n)
    // verify that the sum of all elements is zero
    assert(actual.sum() == 0)
}
