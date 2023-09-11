package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/">Group the People Given the Group Size They Belong To</a>
 * <p>
 * There are n people that are split into some unknown number of groups. Each person is labeled with a unique ID from 0 to n - 1.
 * <p>
 * You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in.
 * For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.
 * <p>
 * Return a list of groups such that each person i is in a group of size groupSizes[i].
 * <p>
 * Each person should appear in exactly one group, and every person must be in a group.
 * If there are multiple answers, return any of them. It is guaranteed that there will be at least one valid solution for the given input.
 * <p>
 * Constraints:
 * <ul>
 *  <li>groupSizes.length == n</li>
 *  <li>1 <= n <= 500</li>
 *  <li>1 <= groupSizes[i] <= n</li>
 * </ul>
 */
public interface GroupPeopleGivenGroupSizeTheyBelongTo {

    List<List<Integer>> groupThePeople(int[] groupSizes);

    class GroupPeopleGivenGroupSizeTheyBelongToRev1 implements GroupPeopleGivenGroupSizeTheyBelongTo {

        @Override
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            int n = groupSizes.length;

            // size -> groups
            Map<Integer, List<List<Integer>>> groupsBySize = new HashMap<>();
            for (int i = 0; i < n; i++) {
                List<List<Integer>> groups = groupsBySize.computeIfAbsent(groupSizes[i], __ -> new ArrayList<>());
                if (groups.isEmpty() || groups.get(groups.size() - 1).size() == groupSizes[i]) {
                    List<Integer> newGroup = new ArrayList<>();
                    newGroup.add(i);
                    groups.add(newGroup);
                } else {
                    List<Integer> lastGroup = groups.get(groups.size() - 1);
                    lastGroup.add(i);
                }
            }

            List<List<Integer>> ans = new ArrayList<>();
            for (List<List<Integer>> groups : groupsBySize.values()) {
                ans.addAll(groups);
            }
            return ans;
        }
    }
}
