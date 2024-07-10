package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CrawlerLogFolder.CrawlerLogFolderRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CrawlerLogFolderTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("d1/", "d2/", "../", "d21/", "./"),
                2
            ),
            Arguments.of(
                arrayOf("d1/", "d2/", "./", "d3/", "../", "d31/"),
                3
            )
        )
    }

    @Nested
    inner class CrawlerLogFolderRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should Return the minimum number of operations needed to go back to the main folder after the change folder operations`(
            logs: Array<String>,
            expected: Int
        ) {
            CrawlerLogFolderRev1().test(logs, expected)
        }
    }
}

private fun CrawlerLogFolder.test(logs: Array<String>, expected: Int) {
    val actual = minOperations(logs)
    assertEquals(expected, actual)
}
