package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3642/">Letter Case Permutation</a>
 * <p>
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * <p>
 * Return a list of all possible strings we could create. You can return the output in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>S will be a string with length between 1 and 12.</li>
 *  <li>S will consist only of letters or digits.</li>
 * </ul>
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        letterCasePermutation(S, 0, "", result);
        return result;
    }

    private void letterCasePermutation(String S, int idx, String permutation, List<String> result) {
        if (idx == S.length()) {
            result.add(permutation);
        } else {
            char c = S.charAt(idx);
            if (Character.isLetter(c)) {
                letterCasePermutation(S, idx + 1, permutation + Character.toLowerCase(c), result);
                letterCasePermutation(S, idx + 1, permutation + Character.toUpperCase(c), result);
            } else {
                letterCasePermutation(S, idx + 1, permutation + c, result);
            }
        }
    }
}
