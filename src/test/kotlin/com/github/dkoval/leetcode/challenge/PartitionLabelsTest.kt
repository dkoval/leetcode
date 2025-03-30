package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PartitionLabels.PartitionLabelsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PartitionLabelsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "ababcbacadefegdehijhklij",
                listOf(9, 7, 8)
            ),
            Arguments.of(
                "eccbbbbdec",
                listOf(10)
            )
        )
    }

    @Nested
    inner class PartitionLabelsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should partition labels`(S: String, expected: List<Int>) {
            PartitionLabelsRev1().test(S, expected)
        }
    }

    @Nested
    inner class PartitionLabelsKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should partition labels`(S: String, expected: List<Int>) {
            PartitionLabelsKt.test(S, expected)
        }
    }
}

private fun PartitionLabels.test(S: String, expected: List<Int>) {
    val actual = partitionLabels(S)
    assertEquals(expected, actual)
}
