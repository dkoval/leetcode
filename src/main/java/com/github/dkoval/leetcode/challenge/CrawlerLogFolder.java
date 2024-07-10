package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/crawler-log-folder/">Crawler Log Folder</a>
 * <p>
 * The Leetcode file system keeps a log each time some user performs a change folder operation.
 * <p>
 * The operations are described below:
 * <ul>
 *  <li>"../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).</li>
 *  <li>"./" : Remain in the same folder.</li>
 *  <li>"x/" : Move to the child folder named x (This folder is guaranteed to always exist).</li>
 * </ul>
 * You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.
 * <p>
 * The file system starts in the main folder, then the operations in logs are performed.
 * <p>
 * Return the minimum number of operations needed to go back to the main folder after the change folder operations.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= logs.length <= 103</li>
 *  <li>2 <= logs[i].length <= 10</li>
 *  <li>logs[i] contains lowercase English letters, digits, '.', and '/'.</li>
 *  <li>logs[i] follows the format described in the statement.</li>
 *  <li>Folder names consist of lowercase English letters and digits.</li>
 * </ul>
 */
public interface CrawlerLogFolder {

    int minOperations(String[] logs);

    class CrawlerLogFolderRev1 implements CrawlerLogFolder {

        @Override
        public int minOperations(String[] logs) {
            int depth = 0;
            for (String folder : logs) {
                if ("./".equals(folder)) {
                    continue;
                }
                depth += ("../".equals(folder)) ? (depth > 0 ? -1 : 0) : 1;
            }
            return depth;
        }
    }
}
