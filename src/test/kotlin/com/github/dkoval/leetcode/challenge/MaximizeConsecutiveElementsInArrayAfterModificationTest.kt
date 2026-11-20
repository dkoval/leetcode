package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximizeConsecutiveElementsInArrayAfterModification.MaximizeConsecutiveElementsInArrayAfterModificationRev1
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

internal class MaximizeConsecutiveElementsInArrayAfterModificationTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                intArrayOf(2, 1, 5, 1, 1),
                3
            ),
            arguments(
                intArrayOf(1, 4, 7, 10),
                1
            )
        )
    }

    @Nested
    inner class MaximizeConsecutiveElementsInArrayAfterModificationRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of elements that you can select`(nums: IntArray, expected: Int) {
            MaximizeConsecutiveElementsInArrayAfterModificationRev1().test(nums, expected)
        }
    }
}

private fun MaximizeConsecutiveElementsInArrayAfterModificationRev1.test(nums: IntArray, expected: Int) {
    val actual = maxSelectedElements(nums)
    assertThat(actual).isEqualTo(expected)
}
