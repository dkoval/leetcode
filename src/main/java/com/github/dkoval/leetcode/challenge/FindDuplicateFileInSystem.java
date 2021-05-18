package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3747/">Find Duplicate File in System</a>
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
 */
public class FindDuplicateFileInSystem {

    public List<List<String>> findDuplicate(String[] paths) {
        // holds content -> paths mapping
        Map<String, List<String>> groups = new HashMap<>();
        for (String path : paths) {
            int basedirEndIndex = path.indexOf(' ');
            String basedir = path.substring(0, basedirEndIndex);
            String[] tokens = path.substring(basedirEndIndex + 1).split("\\s+");
            for (String token : tokens) {
                int filenameEndIndex = token.indexOf('(');
                String filename = token.substring(0, filenameEndIndex);
                String content = token.substring(filenameEndIndex + 1, token.length() - 1);
                groups.computeIfAbsent(content, key -> new ArrayList<>()).add(basedir + '/' + filename);
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
