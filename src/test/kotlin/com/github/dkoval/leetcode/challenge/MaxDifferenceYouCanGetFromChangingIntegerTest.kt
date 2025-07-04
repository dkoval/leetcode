package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaxDifferenceYouCanGetFromChangingInteger.MaxDifferenceYouCanGetFromChangingIntegerRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaxDifferenceYouCanGetFromChangingIntegerTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(555, 888),
            Arguments.of(9, 8),
            Arguments.of(123456, 820000)
        )
    }

    @Nested
    inner class MaxDifferenceYouCanGetFromChangingIntegerRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum difference you can get from changing an integer`(
            num: Int,
            expected: Int
        ) {
            MaxDifferenceYouCanGetFromChangingIntegerRev1().test(num, expected)
        }
    }
}

private fun MaxDifferenceYouCanGetFromChangingInteger.test(num: Int, expected: Int) {
    val actual = maxDiff(num)
    assertEquals(expected, actual)
}
