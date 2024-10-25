package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RemoveSubFoldersFromFilesystem.RemoveSubFoldersFromFilesystemRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RemoveSubFoldersFromFilesystemTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("/a", "/a/b", "/c/d", "/c/d/e", "/c/f"),
                listOf("/a", "/c/d", "/c/f")
            ),
            Arguments.of(
                arrayOf("/a", "/a/b/c", "/a/b/d"),
                listOf("/a")
            ),
            Arguments.of(
                arrayOf("/a/b/c", "/a/b/ca", "/a/b/d"),
                listOf("/a/b/c", "/a/b/ca", "/a/b/d")
            )
        )
    }

    @Nested
    inner class RemoveSubFoldersFromFilesystemRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the folders after removing all sub-folders in those folders`(
            folder: Array<String>,
            expected: List<String>
        ) {
            RemoveSubFoldersFromFilesystemRev1().test(folder, expected)
        }
    }
}

private fun RemoveSubFoldersFromFilesystem.test(folder: Array<String>, expected: List<String>) {
    val actual = removeSubfolders(folder)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
