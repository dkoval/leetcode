package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PartitioningIntoMinimumNumberOfDeciBinaryNumbers.PartitioningIntoMinimumNumberOfDeciBinaryNumbersRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class PartitioningIntoMinimumNumberOfDeciBinaryNumbersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "32",
                3
            ),
            Arguments.of(
                "82734",
                8
            ),
            Arguments.of(
                "27346209830709182346",
                9
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `should return the minimum number of positive deci-binary numbers needed so that they sum up to n`(
        n: String,
        expected: Int
    ) {
        PartitioningIntoMinimumNumberOfDeciBinaryNumbersRev1().test(n, expected)
    }
}

private fun PartitioningIntoMinimumNumberOfDeciBinaryNumbers.test(n: String, expected: Int) {
    val actual = minPartitions(n)
    assertEquals(expected, actual)
}
