package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/">Remove Sub-Folders from the Filesystem</a>
 * <p>
 * Given a list of folders folder, return the folders after removing all sub-folders in those folders. You may return the answer in any order.
 * <p>
 * If a folder[i] is located within another folder[j], it is called a sub-folder of it.
 * A sub-folder of folder[j] must start with folder[j], followed by a "/".
 * For example, "/a/b" is a sub-folder of "/a", but "/b" is not a sub-folder of "/a/b/c".
 * <p>
 * The format of a path is one or more concatenated strings of the form: '/' followed by one or more lowercase English letters.
 * <p>
 * For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string and "/" are not.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= folder.length <= 4 * 10^4</li>
 *  <li>2 <= folder[i].length <= 100</li>
 *  <li>folder[i] contains only lowercase letters and '/'.</li>
 *  <li>folder[i] always starts with the character '/'.</li>
 *  <li>Each folder name is unique.</li>
 * </ul>
 */
public interface RemoveSubFoldersFromFilesystem {

    List<String> removeSubfolders(String[] folder);

    class RemoveSubFoldersFromFilesystemRev1 implements RemoveSubFoldersFromFilesystem {

        @Override
        public List<String> removeSubfolders(String[] folder) {
            int n = folder.length;
            Arrays.sort(folder);

            List<String> ans = new ArrayList<>();
            int i = 0;
            while (i < n) {
                ans.add(folder[i]);
                // skip all subfolders of folder[i]
                String prefix = folder[i] + "/";
                while (i + 1 < n && folder[i + 1].startsWith(prefix)) {
                    i++;
                }
                // proceed to the next unique folder
                i++;
            }
            return ans;
        }
    }
}
