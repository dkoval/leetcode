package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfWaysToFormTargetStringGivenDictionary.NumberOfWaysToFormTargetStringGivenDictionaryPreprocessing
import com.github.dkoval.leetcode.challenge.NumberOfWaysToFormTargetStringGivenDictionary.NumberOfWaysToFormTargetStringGivenDictionaryTLE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfWaysToFormTargetStringGivenDictionaryTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("acca", "bbbb", "caca"),
                "aba",
                6
            ),
            Arguments.of(
                arrayOf("abba", "baab"),
                "bab",
                4
            ),
            Arguments.of(
                arrayOf(
                    "cbabddddbc",
                    "addbaacbbd",
                    "cccbacdccd",
                    "cdcaccacac",
                    "dddbacabbd",
                    "bdbdadbccb",
                    "ddadbacddd",
                    "bbccdddadd",
                    "dcabaccbbd",
                    "ddddcddadc",
                    "bdcaaaabdd",
                    "adacdcdcdd",
                    "cbaaadbdbb",
                    "bccbabcbab",
                    "accbdccadd",
                    "dcccaaddbc",
                    "cccccacabd",
                    "acacdbcbbc",
                    "dbbdbaccca",
                    "bdbddbddda",
                    "daabadbacb",
                    "baccdbaada",
                    "ccbabaabcb",
                    "dcaabccbbb",
                    "bcadddaacc",
                    "acddbbdccb",
                    "adbddbadab",
                    "dbbcdcbcdd",
                    "ddbabbadbb",
                    "bccbcbbbab",
                    "dabbbdbbcb",
                    "dacdabadbb",
                    "addcbbabab",
                    "bcbbccadda",
                    "abbcacadac",
                    "ccdadcaada",
                    "bcacdbccdb"
                ),
                "bcbbcccc",
                677452090
            )
        )
    }

    @Nested
    inner class NumberOfWaysToFormTargetStringGivenDictionaryTLETest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of ways to form target from words`(words: Array<String>, target: String, expected: Int) {
            NumberOfWaysToFormTargetStringGivenDictionaryTLE().test(words, target, expected)
        }
    }

    @Nested
    inner class NumberOfWaysToFormTargetStringGivenDictionaryPreprocessingTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of ways to form target from words`(words: Array<String>, target: String, expected: Int) {
            NumberOfWaysToFormTargetStringGivenDictionaryPreprocessing().test(words, target, expected)
        }
    }
}

private fun NumberOfWaysToFormTargetStringGivenDictionary.test(words: Array<String>, target: String, expected: Int) {
    val actual = numWays(words, target)
    assertEquals(expected, actual)
}
