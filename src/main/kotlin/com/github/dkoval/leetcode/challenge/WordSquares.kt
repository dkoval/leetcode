package com.github.dkoval.leetcode.challenge

/**
 * [Word Squares](https://leetcode.com/explore/featured/card/september-leetcoding-challenge/558/week-5-september-29th-september-30th/3476/)
 *
 * Given a set of words (without duplicates), find all word squares you can build from them.
 *
 * A sequence of words forms a valid word square if the kth row and column read the exact same string,
 * where 0 ≤ k < max(numRows, numColumns).
 *
 * For example, the word sequence ```["ball","area","lead","lady"]``` forms a word square because each word reads
 * the same both horizontally and vertically.
 *
 * Note:
 * - There are at least 1 and at most 1000 words.
 * - All words will have the exact same length.
 * - Word length is at least 1 and at most 5.
 * - Each word contains only lowercase English alphabet a-z.
 */
interface WordSquares {

    fun wordSquares(words: Array<String>): List<List<String>>
}

// Resource: https://zhuhan0.blogspot.com/2017/09/leetcode-425-word-squares.html
object WordSquaresRecursiveWithTrie : WordSquares {

    private class Trie(words: Array<String>) {
        private val root = Node()

        class Node {
            val children = mutableMapOf<Char, Node>()
            var word: String? = null
        }

        init {
            for (word in words) {
                var curr = root
                for (c in word) {
                    curr = curr.children.getOrPut(c) { Node() }
                }
                curr.word = word
            }
        }

        fun wordsWithPrefix(prefix: String): List<String> =
            findNode(prefix)?.let { node -> collectWords(node) } ?: listOf()

        private fun findNode(prefix: String): Node? {
            var curr = root
            for (c in prefix) {
                curr = curr.children[c] ?: return null
            }
            return curr
        }

        private fun collectWords(start: Node): List<String> {
            fun doCollectWords(node: Node, result: MutableList<String>) {
                node.word?.also { word ->
                    result.add(word)
                    return
                }
                for ((_, child) in node.children) {
                    doCollectWords(child, result)
                }
            }
            val result = mutableListOf<String>()
            doCollectWords(start, result)
            return result
        }
    }

    override fun wordSquares(words: Array<String>): List<List<String>> {
        val trie = Trie(words)
        val result = mutableListOf<List<String>>()
        for (word in words) {
            val square = mutableListOf(word)
            doWordSquares(trie, square, word.length, result)
        }
        return result
    }

    private fun doWordSquares(
        trie: Trie,
        square: MutableList<String>,
        length: Int,
        result: MutableList<List<String>>
    ) {
        if (square.size == length) {
            result.add(square.toList()) // make a copy before adding to the result
            return
        }
        val prefix = nextPrefix(square)
        val words = trie.wordsWithPrefix(prefix)
        for (word in words) {
            // try all words starting with `prefix`
            square.add(word)
            doWordSquares(trie, square, length, result)
            // backtrack
            square.removeAt(square.lastIndex)
        }
    }

    private fun nextPrefix(square: List<String>): String =
        buildString {
            for (word in square) {
                append(word[square.size])
            }
        }
}
