package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PassThePillow.PassThePillowRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PassThePillowTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(4, 5, 2),
            Arguments.of(3, 2, 3),
            Arguments.of(8, 9, 6),
            Arguments.of(20, 9, 10),
            Arguments.of(18, 38, 5)
        )
    }

    @Nested
    inner class PassThePillowRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the index of the person holding the pillow after time seconds`(
            n: Int,
            time: Int,
            expected: Int
        ) {
            PassThePillowRev1().test(n, time, expected)
        }
    }
}

private fun PassThePillowRev1.test(n: Int, time: Int, expected: Int) {
    val actual = passThePillow(n, time)
    assertEquals(expected, actual)
}
