package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.TopKFrequentWords.TopKFrequentWordsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class TopKFrequentWordsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("i", "love", "leetcode", "i", "love", "coding"),
                2,
                listOf("i", "love")
            ),
            Arguments.of(
                arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"),
                4,
                listOf("the", "is", "sunny", "day")
            ),
            Arguments.of(
                arrayOf("i", "love", "leetcode", "i", "love", "coding"),
                3,
                listOf("i", "love", "coding")
            ),
            Arguments.of(
                arrayOf(
                    "glarko",
                    "zlfiwwb",
                    "nsfspyox",
                    "pwqvwmlgri",
                    "qggx",
                    "qrkgmliewc",
                    "zskaqzwo",
                    "zskaqzwo",
                    "ijy",
                    "htpvnmozay",
                    "jqrlad",
                    "ccjel",
                    "qrkgmliewc",
                    "qkjzgws",
                    "fqizrrnmif",
                    "jqrlad",
                    "nbuorw",
                    "qrkgmliewc",
                    "htpvnmozay",
                    "nftk",
                    "glarko",
                    "hdemkfr",
                    "axyak",
                    "hdemkfr",
                    "nsfspyox",
                    "nsfspyox",
                    "qrkgmliewc",
                    "nftk",
                    "nftk",
                    "ccjel",
                    "qrkgmliewc",
                    "ocgjsu",
                    "ijy",
                    "glarko",
                    "nbuorw",
                    "nsfspyox",
                    "qkjzgws",
                    "qkjzgws",
                    "fqizrrnmif",
                    "pwqvwmlgri",
                    "nftk",
                    "qrkgmliewc",
                    "jqrlad",
                    "nftk",
                    "zskaqzwo",
                    "glarko",
                    "nsfspyox",
                    "zlfiwwb",
                    "hwlvqgkdbo",
                    "htpvnmozay",
                    "nsfspyox",
                    "zskaqzwo",
                    "htpvnmozay",
                    "zskaqzwo",
                    "nbuorw",
                    "qkjzgws",
                    "zlfiwwb",
                    "pwqvwmlgri",
                    "zskaqzwo",
                    "qengse",
                    "glarko",
                    "qkjzgws",
                    "pwqvwmlgri",
                    "fqizrrnmif",
                    "nbuorw",
                    "nftk",
                    "ijy",
                    "hdemkfr",
                    "nftk",
                    "qkjzgws",
                    "jqrlad",
                    "nftk",
                    "ccjel",
                    "qggx",
                    "ijy",
                    "qengse",
                    "nftk",
                    "htpvnmozay",
                    "qengse",
                    "eonrg",
                    "qengse",
                    "fqizrrnmif",
                    "hwlvqgkdbo",
                    "qengse",
                    "qengse",
                    "qggx",
                    "qkjzgws",
                    "qggx",
                    "pwqvwmlgri",
                    "htpvnmozay",
                    "qrkgmliewc",
                    "qengse",
                    "fqizrrnmif",
                    "qkjzgws",
                    "qengse",
                    "nftk",
                    "htpvnmozay",
                    "qggx",
                    "zlfiwwb",
                    "bwp",
                    "ocgjsu",
                    "qrkgmliewc",
                    "ccjel",
                    "hdemkfr",
                    "nsfspyox",
                    "hdemkfr",
                    "qggx",
                    "zlfiwwb",
                    "nsfspyox",
                    "ijy",
                    "qkjzgws",
                    "fqizrrnmif",
                    "qkjzgws",
                    "qrkgmliewc",
                    "glarko",
                    "hdemkfr",
                    "pwqvwmlgri"
                ),
                14,
                listOf(
                    "nftk",
                    "qkjzgws",
                    "qrkgmliewc",
                    "nsfspyox",
                    "qengse",
                    "htpvnmozay",
                    "fqizrrnmif",
                    "glarko",
                    "hdemkfr",
                    "pwqvwmlgri",
                    "qggx",
                    "zskaqzwo",
                    "ijy",
                    "zlfiwwb"
                )
            )
        )
    }

    @Nested
    inner class TopKFrequentWordsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the k most frequent strings`(words: Array<String>, k: Int, expected: List<String>) {
            TopKFrequentWordsRev1().test(words, k, expected)
        }
    }

    private fun TopKFrequentWords.test(words: Array<String>, k: Int, expected: List<String>) {
        val actual = topKFrequent(words, k)
        assertEquals(expected, actual)
    }
}
