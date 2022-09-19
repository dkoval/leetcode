package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <a href="https://leetcode.com/problems/find-duplicate-file-in-system/">Find Duplicate File in System</a>
 * <p>
 * Given a list paths of directory info, including the directory path, and all the files with contents in this directory,
 * return all the duplicate files in the file system in terms of their paths. You may return the answer in any order.
 * <p>
 * A group of duplicate files consists of at least two files that have the same content.
 * <p>
 * A single directory info string in the input list has the following format:
 * <p>
 * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
 * <p>
 * It means there are n files (f1.txt, f2.txt ... fn.txt) with content (f1_content, f2_content ... fn_content) respectively
 * in the directory "root/d1/d2/.../dm". Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.
 * <p>
 * The output is a list of groups of duplicate file paths. For each group, it contains all the file paths of the files
 * that have the same content. A file path is a string that has the following format:
 * <p>
 * "directory_path/file_name.txt"
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= paths.length <= 2 * 104</li>
 *  <li>1 <= paths[i].length <= 3000</li>
 *  <li>1 <= sum(paths[i].length) <= 5 * 105</li>
 *  <li>paths[i] consist of English letters, digits, '/', '.', '(', ')', and ' '.</li>
 *  <li>You may assume no files or directories share the same name in the same directory.</li>
 *  <li>You may assume each given directory info represents a unique directory. A single blank space separates the directory path and file info.</li>
 * </ul>
 */
public class FindDuplicateFileInSystem {

    public List<List<String>> findDuplicate(String[] paths) {
        // holds content -> paths mapping
        Map<String, List<String>> groups = new HashMap<>();
        for (String path : paths) {
            int baseDirEndIndex = path.indexOf(' ');
            String baseDir = path.substring(0, baseDirEndIndex);
            String[] tokens = path.substring(baseDirEndIndex + 1).split(" ");
            for (String token : tokens) {
                int fileNameEndIndex = token.indexOf('(');
                String fileName = token.substring(0, fileNameEndIndex);
                String fileContent = token.substring(fileNameEndIndex + 1, token.length() - 1);
                groups.computeIfAbsent(fileContent, key -> new ArrayList<>()).add(baseDir + '/' + fileName);
            }
        }
        return collect(groups);
    }

    private List<List<String>> collect(Map<String, List<String>> groups) {
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : groups.values()) {
            if (group.size() > 1) {
                result.add(group);
            }
        }
        return result;
    }
}
