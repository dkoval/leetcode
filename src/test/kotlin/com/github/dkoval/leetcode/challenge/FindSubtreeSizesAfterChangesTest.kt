package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindSubtreeSizesAfterChanges.FindSubtreeSizesAfterChangesRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class FindSubtreeSizesAfterChangesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                intArrayOf(-1, 0, 0, 1, 1, 1),
                "abaabc",
                intArrayOf(6, 3, 1, 1, 1, 1)
            ),
            arguments(
                intArrayOf(-1, 0, 4, 0, 1),
                "abbba",
                intArrayOf(5, 2, 1, 1, 1)
            )
        )
    }

    @Nested
    inner class FindSubtreeSizesAfterChangesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find subtree sizes in the final tree`(
            parent: IntArray,
            s: String,
            expected: IntArray
        ) {
            FindSubtreeSizesAfterChangesRev1().test(parent, s, expected)
        }
    }
}

private fun FindSubtreeSizesAfterChangesRev1.test(
    parent: IntArray,
    s: String,
    expected: IntArray
) {
    val actual = findSubtreeSizes(parent, s)
    assertThat(actual).isEqualTo(expected)
}
