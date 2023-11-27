package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.KnightDialer.KnightDialerDPTopDownRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class KnightDialerTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 10),
            Arguments.of(2, 20),
            Arguments.of(3131, 136006598)
        )
    }

    @Nested
    inner class KnightDialerDPTopDownRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return how many distinct phone numbers of length n we can dial`(n: Int, expected: Int) {
            KnightDialerDPTopDownRev1().test(n, expected)
        }
    }
}

private fun KnightDialer.test(n: Int, expected: Int) {
    val actual = knightDialer(n)
    assertEquals(expected, actual)
}
