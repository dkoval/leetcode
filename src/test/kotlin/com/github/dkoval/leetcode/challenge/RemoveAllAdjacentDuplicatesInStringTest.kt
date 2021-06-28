package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RemoveAllAdjacentDuplicatesInString.RemoveAllAdjacentDuplicatesInStringUsingDeque
import com.github.dkoval.leetcode.challenge.RemoveAllAdjacentDuplicatesInString.RemoveAllAdjacentDuplicatesInStringUsingStack
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class RemoveAllAdjacentDuplicatesInStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of("abbaca", "ca"),
            Arguments.of("azxxzy", "ay")
        )
    }

    @Nested
    inner class RemoveAllAdjacentDuplicatesInStringUsingStackTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the final string after all such duplicate removals have been made`(
            s: String,
            expected: String
        ) {
            RemoveAllAdjacentDuplicatesInStringUsingStack().test(s, expected)
        }
    }

    @Nested
    inner class RemoveAllAdjacentDuplicatesInStringUsingDequeTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the final string after all such duplicate removals have been made`(
            s: String,
            expected: String
        ) {
            RemoveAllAdjacentDuplicatesInStringUsingDeque().test(s, expected)
        }
    }

    private fun RemoveAllAdjacentDuplicatesInString.test(s: String, expected: String) {
        val actual = removeDuplicates(s)
        assertEquals(expected, actual)
    }
}