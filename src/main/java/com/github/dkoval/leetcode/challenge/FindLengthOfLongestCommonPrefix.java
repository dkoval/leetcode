package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/">Find the Length of the Longest Common Prefix</a>
 * <p>
 * You are given two arrays with positive integers arr1 and arr2.
 * <p>
 * A prefix of a positive integer is an integer formed by one or more of its digits, starting from its leftmost digit.
 * For example, 123 is a prefix of the integer 12345, while 234 is not.
 * <p>
 * A common prefix of two integers a and b is an integer c, such that c is a prefix of both a and b.
 * For example, 5655359 and 56554 have a common prefix 5655 while 1223 and 43456 do not have a common prefix.
 * <p>
 * You need to find the length of the longest common prefix between all pairs of integers (x, y) such that x belongs to
 * arr1 and y belongs to arr2.
 * <p>
 * Return the length of the longest common prefix among all pairs. If no common prefix exists among them, return 0.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr1.length, arr2.length <= 5 * 10^4</li>
 *  <li>1 <= arr1[i], arr2[i] <= 10^8</li>
 * </ul>
 */
public interface FindLengthOfLongestCommonPrefix {

    int longestCommonPrefix(int[] arr1, int[] arr2);

    class FindLengthOfLongestCommonPrefixRev1 implements FindLengthOfLongestCommonPrefix {

        @Override
        public int longestCommonPrefix(int[] arr1, int[] arr2) {
            Trie t = new Trie(arr1, arr2);
            return t.getLongestCommonPrefixLength();
        }

        private static class Trie {

            private final Node root = new Node();

            private Trie(int[] arr1, int[] arr2) {
                insert(arr1, 0);
                insert(arr2, 1);
            }

            // array IDs: 0 - arr1[], 1 - arr2[]
            private void insert(int[] xs, int id) {
                for (int x : xs) {
                    String s = Integer.toString(x);
                    Node curr = root;
                    for (int i = 0; i < s.length(); i++) {
                        curr = curr.branches.computeIfAbsent(s.charAt(i), __ -> new Node());
                        curr.prefix[id] = true;
                    }
                }
            }

            int getLongestCommonPrefixLength() {
                // level order traversal
                int len = -1;
                Queue<Node> q = new ArrayDeque<>();
                q.offer(root);
                while (!q.isEmpty()) {
                    len++;
                    int size = q.size();
                    while (size-- > 0) {
                        Node curr = q.poll();
                        for (Node next : curr.branches.values()) {
                            if (next.prefix[0] && next.prefix[1]) {
                                q.offer(next);
                            }
                        }
                    }
                }
                return len;
            }

            static class Node {
                final Map<Character, Node> branches = new HashMap<>();
                // indices: 0 - arr1[], 1 - arr2[]
                final boolean[] prefix = new boolean[2];
            }
        }
    }
}
