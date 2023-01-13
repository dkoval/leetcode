package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestPathWithDifferentAdjacentCharacters.LongestPathWithDifferentAdjacentCharactersRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestPathWithDifferentAdjacentCharactersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(-1, 0, 1, 2, 3, 4),
                "zzabab",
                5
            ),
            Arguments.of(
                intArrayOf(-1,137,65,60,73,138,81,17,45,163,145,99,29,162,19,20,132,132,13,60,21,18,155,65,13,163,125,102,96,60,50,101,100,86,162,42,162,94,21,56,45,56,13,23,101,76,57,89,4,161,16,139,29,60,44,127,19,68,71,55,13,36,148,129,75,41,107,91,52,42,93,85,125,89,132,13,141,21,152,21,79,160,130,103,46,65,71,33,129,0,19,148,65,125,41,38,104,115,130,164,138,108,65,31,13,60,29,116,26,58,118,10,138,14,28,91,60,47,2,149,99,28,154,71,96,60,106,79,129,83,42,102,34,41,55,31,154,26,34,127,42,133,113,125,113,13,54,132,13,56,13,42,102,135,130,75,25,80,159,39,29,41,89,85,19),
                "ajunvefrdrpgxltugqqrwisyfwwtldxjgaxsbbkhvuqeoigqssefoyngykgtthpzvsxgxrqedntvsjcpdnupvqtroxmbpsdwoswxfarnixkvcimzgvrevxnxtkkovwxcjmtgqrrsqyshxbfxptuvqrytctujnzzydhpal",
                17
            )
        )
    }

    @Nested
    inner class LongestPathWithDifferentAdjacentCharactersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the longest path in the tree such that no pair of adjacent nodes on the path have the same character assigned to them`(
            parent: IntArray,
            s: String,
            expected: Int
        ) {
            LongestPathWithDifferentAdjacentCharactersRev1().test(parent, s, expected)
        }
    }

    private fun LongestPathWithDifferentAdjacentCharacters.test(parent: IntArray, s: String, expected: Int) {
        val actual = longestPath(parent, s)
        assertEquals(expected, actual)
    }
}
