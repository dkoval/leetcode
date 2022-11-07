package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.Maximum69Number.Maximum69NumberRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class Maximum69NumberTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(9669, 9969),
            Arguments.of(9996, 9999),
            Arguments.of(9999, 9999)
        )
    }

    @Nested
    inner class Maximum69NumberRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number you can get by changing at most one digit`(num: Int, expected: Int) {
            Maximum69NumberRev1().test(num, expected)
        }
    }

    private fun Maximum69Number.test(num: Int, expected: Int) {
        val actual = maximum69Number(num)
        assertEquals(expected, actual)
    }
}