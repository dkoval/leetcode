package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/text-justification/">Text Justification (Hard)</a>
 * <p>
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters
 * and is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide
 * evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 * <p>
 * Note:
 * <ul>
 *  <li>A word is defined as a character sequence consisting of non-space characters only.</li>
 *  <li>Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.</li>
 *  <li>The input array words contains at least one word.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 300</li>
 *  <li>1 <= words[i].length <= 20</li>
 *  <li>words[i] consists of only English letters and symbols</li>
 *  <li>1 <= maxWidth <= 100</li>
 *  <li>words[i].length <= maxWidth</li>
 * </ul>
 */
public interface TextJustification {

    List<String> fullJustify(String[] words, int maxWidth);

    class TextJustificationRev1 implements TextJustification {

        @Override
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> ans = new ArrayList<>();
            int start = 0;
            while (start < words.length) {
                Line line = buildLine(words, start, maxWidth);
                start += line.words.size();
                ans.add(formatLine(line, maxWidth, line.words.size() == 1 || start == words.length));
            }
            return ans;
        }

        private Line buildLine(String[] words, int start, int maxWidth) {
            int slotsAvailable = maxWidth;
            int totalChars = 0;
            List<String> items = new ArrayList<>();
            int i = start;
            while (i < words.length) {
                // count for a space that needs to be prepended before words[i]
                int slotsNeeded = words[i].length() + (items.isEmpty() ? 0 : 1);
                if (slotsNeeded <= slotsAvailable) {
                    slotsAvailable -= slotsNeeded;
                    items.add(words[i]);
                    totalChars += words[i].length();
                    i++;
                } else {
                    break;
                }
            }
            return new Line(items, maxWidth - totalChars);
        }

        private String formatLine(Line line, int maxWidth, boolean leftJustified) {
            StringBuilder sb = new StringBuilder();
            if (leftJustified) {
                for (int i = 0; i < line.words.size(); i++) {
                    if (i > 0) {
                        sb.append(' ');
                    }
                    sb.append(line.words.get(i));
                }

                // pad extra spaces when necessary
                int currWidth = sb.length();
                while (currWidth < maxWidth) {
                    sb.append(' ');
                    currWidth++;
                }
            } else {
                int spaces = line.spaces;
                int gaps = line.words.size() - 1;

                for (int i = 0; i < line.words.size(); i++) {
                    if (i > 0) {
                        int repeat = spaces / gaps + (spaces % gaps != 0 ? 1 : 0);
                        spaces -= repeat;
                        gaps--;

                        // prepend spaces before words[i]
                        while (repeat-- > 0) {
                            sb.append(' ');
                        }
                    }
                    sb.append(line.words.get(i));
                }
            }
            return sb.toString();
        }

        private static class Line {
            final List<String> words;
            final int spaces;

            Line(List<String> words, int spaces) {
                this.words = words;
                this.spaces = spaces;
            }
        }
    }
}
