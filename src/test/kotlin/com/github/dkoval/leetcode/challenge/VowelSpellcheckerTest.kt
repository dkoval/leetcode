package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class VowelSpellcheckerTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf("KiTe", "kite", "hare", "Hare"),
                arrayOf("kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"),
                arrayOf("kite", "KiTe", "KiTe", "Hare", "hare", "", "", "KiTe", "", "KiTe")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should converts a query word into a correct word`(
        wordlist: Array<String>,
        queries: Array<String>,
        expected: Array<String>
    ) {
        val actual = VowelSpellchecker().spellchecker(wordlist, queries)
        println(Arrays.deepToString(actual))
        assertArrayEquals(expected, actual)
    }
}