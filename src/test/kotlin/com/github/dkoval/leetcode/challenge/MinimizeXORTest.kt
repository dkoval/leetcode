package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimizeXOR.MinimizeXORRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimizeXORTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(3, 5, 3),
            Arguments.of(1, 12, 3)
        )
    }

    @Nested
    inner class MinimizeXORRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number that minimizes XOR`(num1: Int, num2: Int, expected: Int) {
            MinimizeXORRev1().test(num1, num2, expected)
        }
    }
}

private fun MinimizeXOR.test(num1: Int, num2: Int, expeted: Int) {
    val actual = minimizeXor(num1, num2)
    assertEquals(expeted, actual)
}
