package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindMissingElements.FindMissingElementsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class FindMissingElementsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 1),
                listOf(2, 3, 4)
            ),
            Arguments.of(
                intArrayOf(7, 8, 6, 9),
                emptyList<Int>()
            ),
            Arguments.of(
                intArrayOf(5, 1),
                listOf(2, 3, 4)
            )
        )
    }

    @Nested
    inner class FindMissingElementsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should Return a sorted list of all the missing integers in this range`(
            nums: IntArray, expected: List<Int>
        ) {
            FindMissingElementsRev1().test(nums, expected)
        }
    }
}

private fun FindMissingElements.test(nums: IntArray, expected: List<Int>) {
    val actual = findMissingElements(nums)
    assertEquals(expected, actual)
}
