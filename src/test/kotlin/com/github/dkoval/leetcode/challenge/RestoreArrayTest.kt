package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RestoreArray.RestoreArrayDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RestoreArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("1000", 10000, 1),
            Arguments.of("1000", 10, 0),
            Arguments.of("1317", 2000, 8),
            Arguments.of("2020", 30, 1),
            Arguments.of("407780786171321121429620765476840275495357129574174233567552131453038760763182952432348422252546559691171161181440370120987634895458140447952079749439961325982629462531738374032416182281868731817661954890417245087359968833257550123324827240537957646002494771036413572415", 823924906, 427125123)
        )
    }

    @Nested
    inner class RestoreArrayDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of the possible arrays that can be printed as s`(s: String, k: Int, expected: Int) {
            RestoreArrayDPTopDown().test(s, k, expected)
        }
    }
}

private fun RestoreArray.test(s: String, k: Int, expected: Int) {
    val actual = numberOfArrays(s, k)
    assertEquals(expected, actual)
}
