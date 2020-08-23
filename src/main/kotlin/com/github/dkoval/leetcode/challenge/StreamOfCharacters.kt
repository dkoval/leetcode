package com.github.dkoval.leetcode.challenge

import java.util.*

class StreamChecker(words: Array<String>) {
    private val queriedLettersReversed: Deque<Char> = LinkedList()
    private val trie = Trie()

    init {
        for (word in words) {
            val reversedWord = word.reversed()
            trie.insert(reversedWord)
        }
    }

    // Resource: https://www.youtube.com/watch?v=Y37WA4advWw&t=6s
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