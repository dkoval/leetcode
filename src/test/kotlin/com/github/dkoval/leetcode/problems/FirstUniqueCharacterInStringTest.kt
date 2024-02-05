package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.FirstUniqueCharacterInString.FirstUniqueCharacterInStringRev1
import com.github.dkoval.leetcode.problems.FirstUniqueCharacterInString.FirstUniqueCharacterInStringRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class FirstUniqueCharacterInStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("leetcode", 0),
            Arguments.of("loveleetcode", 2),
            Arguments.of("aabb", -1)
        )
    }

    @Nested
    inner class FirstUniqueCharacterInStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should  find the first non-repeating character in it and return its index`(s: String, expected: Int) {
            FirstUniqueCharacterInStringRev1().test(s, expected)
        }
    }

    @Nested
    inner class FirstUniqueCharacterInStringRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should  find the first non-repeating character in it and return its index`(s: String, expected: Int) {
            FirstUniqueCharacterInStringRev2().test(s, expected)
        }
    }
}

private fun FirstUniqueCharacterInString.test(s: String, expected: Int) {
    val actual = firstUniqChar(s)
    assertEquals(expected, actual)
}
