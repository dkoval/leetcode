package com.github.dkoval.leetcode.challenge

import java.util.*

/**
 * [Stream of Characters](https://leetcode.com/problems/stream-of-characters/)
 *
 * Design an algorithm that accepts a stream of characters and checks if a suffix of these characters is a string of
 * a given array of strings words.
 *
 * For example, if words = ["abc", "xyz"] and the stream added the four characters (one by one) 'a', 'x', 'y', and 'z',
 * your algorithm should detect that the suffix "xyz" of the characters "axyz" matches "xyz" from words.
 *
 * Implement the StreamChecker class:
 * - StreamChecker(String[] words) Initializes the object with the strings array words.
 * - boolean query(char letter) Accepts a new character from the stream and returns true if any non-empty suffix from the stream forms a word that is in words.
 *
 * Constraints:
 *
 * - 1 <= words.length <= 2000
 * - 1 <= words[i].length <= 2000
 * - words[i] consists of lowercase English letters.
 * - letter is a lowercase English letter.
 * - At most 4 * 10^4 calls will be made to query.
 */
class StreamChecker(words: Array<String>) {
    private val queriedLettersReversed: Deque<Char> = LinkedList()
    private val trie = Trie()

    init {
        for (word in words) {
            val reversedWord = word.reversed()
            trie.insert(reversedWord)
        }
    }

    // Resource: https://www.youtube.com/watch?v=Y37WA4advWw
    fun query(letter: Char): Boolean {
        queriedLettersReversed.addFirst(letter)
        return trie.search(queriedLettersReversed)
    }

    private class Trie {
        private val root = Node()

        private class Node {
            val children = mutableMapOf<Char, Node>()
            var endOfWord = false
        }

        fun insert(word: String) {
            var curr = root
            for (letter in word) {
                curr = curr.children.getOrPut(letter) { Node() }
            }
            curr.endOfWord = true
        }

        fun search(letters: Iterable<Char>): Boolean {
            var curr = root
            for (letter in letters) {
                curr = curr.children[letter] ?: return false
                if (curr.endOfWord) return true
            }
            return false
        }
    }
}