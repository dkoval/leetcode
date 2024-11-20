package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.TakeKOfEachCharacterFromLeftAndRight.TakeKOfEachCharacterFromLeftAndRightRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class TakeKOfEachCharacterFromLeftAndRightTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("aabaaaacaabc", 2, 8),
            Arguments.of("a", 1, -1),
            Arguments.of("a", 0, 0)
        )
    }

    @Nested
    inner class TakeKOfEachCharacterFromLeftAndRightRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of minutes needed for you to take at least k of each character`(
            s: String,
            k: Int,
            expected: Int
        ) {
            TakeKOfEachCharacterFromLeftAndRightRev1().test(s, k, expected)
        }
    }
}

private fun TakeKOfEachCharacterFromLeftAndRight.test(s: String, k: Int, expected: Int) {
    val actual = takeCharacters(s, k)
    assertEquals(expected, actual)
}
