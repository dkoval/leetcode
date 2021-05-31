package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SearchSuggestionsSystemTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf("mobile", "mouse", "moneypot", "monitor", "mousepad"),
                "mouse",
                listOf(
                    listOf("mobile", "moneypot", "monitor"),
                    listOf("mobile", "moneypot", "monitor"),
                    listOf("mouse", "mousepad"),
                    listOf("mouse", "mousepad"),
                    listOf("mouse", "mousepad")
                )
            ),
            Arguments.of(
                arrayOf("havana"),
                "havana",
                listOf(
                    listOf("havana"),
                    listOf("havana"),
                    listOf("havana"),
                    listOf("havana"),
                    listOf("havana"),
                    listOf("havana")
                )
            ),
            Arguments.of(
                arrayOf("bags", "baggage", "banner", "box", "cloths"),
                "bags",
                listOf(
                    listOf("baggage", "bags", "banner"),
                    listOf("baggage", "bags", "banner"),
                    listOf("baggage", "bags"),
                    listOf("bags")
                )
            ),
            Arguments.of(
                arrayOf("havana"),
                "tatiana",
                listOf(
                    listOf<String>(),
                    listOf(),
                    listOf(),
                    listOf(),
                    listOf(),
                    listOf(),
                    listOf()
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return list of lists of the suggested products after each character of searchWord is typed`(
        products: Array<String>,
        searchWord: String,
        expected: List<List<String>>
    ) {
        val actual = SearchSuggestionsSystem().suggestedProducts(products, searchWord)
        assertThat(actual).containsExactlyElementsOf(expected)
    }
}