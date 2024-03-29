package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/simplify-path/">Simplify Path</a>
 * <p>
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style
 * file system, convert it to the simplified canonical path.
 * <p>
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the
 * directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'.
 * For this problem, any other format of periods such as '...' are treated as file/directory names.
 * <p>
 * The canonical path should have the following format:
 * <ul>
 *  <li>The path starts with a single slash '/'.</li>
 *  <li>Any two directories are separated by a single slash '/'.</li>
 *  <li>The path does not end with a trailing '/'.</li>
 *  <li>The path only contains the directories on the path from the root directory to the target file or directory
 *  (i.e., no period '.' or double period '..')</li>
 *  </ul>
 * Return the simplified canonical path.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= path.length <= 3000</li>
 *  <li>path consists of English letters, digits, period '.', slash '/' or '_'.</li>
 *  <li>path is a valid absolute Unix path.</li>
 * </ul>
 */
public class SimplifyPath {

    // O(N) time | O(N) space
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Deque<String> dq = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.isEmpty() || ".".equals(token)) {
                continue;
            }

            if ("..".equals(token)) {
                if (!dq.isEmpty()) {
                    dq.pollLast();
                }
            } else {
                dq.offerLast(token);
            }
        }

        if (dq.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : dq) {
            sb.append("/").append(dir);
        }
        return sb.toString();
    }
}
