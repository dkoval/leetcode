package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class AccountsMergeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                listOf(
                    listOf("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                    listOf("John", "johnsmith@mail.com", "john00@mail.com"),
                    listOf("Mary", "mary@mail.com"),
                    listOf("John", "johnnybravo@mail.com")
                ),
                listOf(
                    listOf("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
                    listOf("Mary", "mary@mail.com"),
                    listOf("John", "johnnybravo@mail.com")
                )
            ),
            Arguments.of(
                listOf(
                    listOf("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"),
                    listOf("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"),
                    listOf("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"),
                    listOf("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"),
                    listOf("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co")
                ),
                listOf(
                    listOf("Ethan", "Ethan0@m.co", "Ethan4@m.co", "Ethan5@m.co"),
                    listOf("Gabe", "Gabe0@m.co", "Gabe1@m.co", "Gabe3@m.co"),
                    listOf("Hanzo", "Hanzo0@m.co", "Hanzo1@m.co", "Hanzo3@m.co"),
                    listOf("Kevin", "Kevin0@m.co", "Kevin3@m.co", "Kevin5@m.co"),
                    listOf("Fern", "Fern0@m.co", "Fern1@m.co", "Fern5@m.co")
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should merge the accounts`(accounts: List<List<String>>, expected: List<List<String>>) {
        val actual = AccountsMerge().accountsMerge(accounts)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}