package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.VerifyPreorderSerializationOfBinaryTree.VerifyPreorderSerializationOfBinaryTreeRecursively
import com.github.dkoval.leetcode.challenge.VerifyPreorderSerializationOfBinaryTree.VerifyPreorderSerializationOfBinaryTreeUsingVacanciesCount
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class VerifyPreorderSerializationOfBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of("9,3,4,#,#,1,#,#,2,#,6,#,#", true),
            Arguments.of("1,#", false),
            Arguments.of("9,#,#,1", false),
            Arguments.of("9,#,92,#,#", true)
        )
    }

    @Nested
    inner class VerifyPreorderSerializationOfBinaryTreeRecursivelyTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should verify preorder serialization of a binary tree`(preorder: String, expected: Boolean) {
            VerifyPreorderSerializationOfBinaryTreeRecursively().test(preorder, expected)
        }
    }

    @Nested
    inner class VerifyPreorderSerializationOfBinaryTreeUsingVacanciesCountTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should verify preorder serialization of a binary tree`(preorder: String, expected: Boolean) {
            VerifyPreorderSerializationOfBinaryTreeUsingVacanciesCount().test(preorder, expected)
        }
    }

    private fun VerifyPreorderSerializationOfBinaryTree.test(preorder: String, expected: Boolean) {
        val actual = isValidSerialization(preorder)
        assertEquals(expected, actual)
    }
}