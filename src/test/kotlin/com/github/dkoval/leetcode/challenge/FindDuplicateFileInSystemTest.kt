package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindDuplicateFileInSystemTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    "root/a 1.txt(abcd) 2.txt(efgh)",
                    "root/c 3.txt(abcd)",
                    "root/c/d 4.txt(efgh)",
                    "root 4.txt(efgh)"
                ),
                listOf(
                    listOf("root/a/2.txt", "root/c/d/4.txt", "root/4.txt"),
                    listOf("root/a/1.txt", "root/c/3.txt")
                )
            ),
            Arguments.of(
                arrayOf(
                    "root/a 1.txt(abcd) 2.txt(efgh)",
                    "root/c 3.txt(abcd)",
                    "root/c/d 4.txt(efgh)"
                ),
                listOf(
                    listOf("root/a/2.txt", "root/c/d/4.txt"),
                    listOf("root/a/1.txt","root/c/3.txt")
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return a list of groups of duplicate file paths`(paths: Array<String>, expected: List<List<String>>) {
        val actual = FindDuplicateFileInSystem().findDuplicate(paths)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}