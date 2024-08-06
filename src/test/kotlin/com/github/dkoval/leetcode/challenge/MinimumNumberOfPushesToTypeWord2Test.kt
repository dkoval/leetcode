package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumNumberOfPushesToTypeWord2.MinimumNumberOfPushesToTypeWord2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumNumberOfPushesToTypeWord2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("abcde", 5),
            Arguments.of("xyzxyzxyzxyz", 12),
            Arguments.of("aabbccddeeffgghhiiiiii", 24)
        )
    }

    @Nested
    inner class MinimumNumberOfPushesToTypeWord2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of pushes needed to type word after remapping the keys`(
            word: String,
            expected: Int
        ) {
            MinimumNumberOfPushesToTypeWord2Rev1().test(word, expected)
        }
    }
}

private fun MinimumNumberOfPushesToTypeWord2.test(word: String, expected: Int) {
    val actual = minimumPushes(word)
    assertEquals(expected, actual)
}
