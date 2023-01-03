package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DeleteColumnsToMakeSorted.DeleteColumnsToMakeSortedRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DeleteColumnsToMakeSortedTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("cba", "daf", "ghi"),
                1
            ),
            Arguments.of(
                arrayOf("a", "b"),
                0
            ),
            Arguments.of(
                arrayOf("zyx", "wvu", "tsr"),
                3
            )
        )
    }

    @Nested
    inner class DeleteColumnsToMakeSortedRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of columns that you will delete`(strs: Array<String>, expected: Int) {
            DeleteColumnsToMakeSortedRev1().test(strs, expected)
        }
    }

    private fun DeleteColumnsToMakeSorted.test(strs: Array<String>, expected: Int) {
        val actual = minDeletionSize(strs)
        assertEquals(expected, actual)
    }
}
