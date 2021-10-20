package com.github.dkoval.leetcode.challenge;

public interface ReverseWordsInString {

    String reverseWords(String s);

    // O(N) time | O(N) space
    class ReverseWordsInStringJava implements ReverseWordsInString {

        @Override
        public String reverseWords(String s) {
            int n = s.length();
            StringBuilder sb = new StringBuilder();

            int end = n - 1;
            while (end > 0) {
                // skip trailing spaces
                while (end >= 0 && s.charAt(end) == ' ') {
                    end--;
                }

                if (end < 0) {
                    break;
                }

                // find start index of the current word
                int start = end;
                while (start >= 0 && s.charAt(start) != ' ') {
                    start--;
                }

                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(s, start + 1, end + 1);
                end = start;
            }
            return sb.toString();
        }
    }
}
