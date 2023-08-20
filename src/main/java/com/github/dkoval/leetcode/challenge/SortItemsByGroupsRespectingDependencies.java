package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/">Sort Items by Groups Respecting Dependencies (Hard)</a>
 * <p>
 * There are n items each belonging to zero or one of m groups where group[i] is the group that the i-th item belongs to
 * and it's equal to -1 if the i-th item belongs to no group. The items and the groups are zero indexed.
 * A group can have no item belonging to it.
 * <p>
 * Return a sorted list of the items such that:
 * <ul>
 *  <li>The items that belong to the same group are next to each other in the sorted list.</li>
 *  <li>There are some relations between these items where beforeItems[i] is a list containing all the items that should come before the i-th item in the sorted array (to the left of the i-th item).</li>
 * </ul>
 * Return any solution if there is more than one solution and return an empty list if there is no solution.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= m <= n <= 3 * 104</li>
 *  <li>group.length == beforeItems.length == n</li>
 *  <li>-1 <= group[i] <= m - 1</li>
 *  <li>0 <= beforeItems[i].length <= n - 1</li>
 *  <li>0 <= beforeItems[i][j] <= n - 1</li>
 *  <li>i != beforeItems[i][j]</li>
 *  <li>beforeItems[i] does not contain duplicates elements.</li>
 * </ul>
 */
public interface SortItemsByGroupsRespectingDependencies {

    int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems);

    // Resource: https://www.youtube.com/watch?v=--ZX-B0_hBA
    class SortItemsByGroupsRespectingDependenciesRev1 implements SortItemsByGroupsRespectingDependencies {

        @Override
        public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
            // handle items that belong to no group, i.e. group[i] == -1
            int newGroupId = m;
            for (int i = 0; i < n; i++) {
                if (group[i] == -1) {
                    // assign a new group id
                    group[i] = newGroupId++;
                }
            }

            // idea: topological sort on items and groups
            GraphInfo info = buildPrereqs(n, newGroupId, group, beforeItems);

            List<Integer> itemsInOrder = topologicalSort(info.itemsPrereq);
            if (itemsInOrder.isEmpty()) {
                return new int[0];
            }

            List<Integer> groupsInOrder = topologicalSort(info.groupsPrereq);
            if (groupsInOrder.isEmpty()) {
                return new int[0];
            }

            // order items within each group
            Map<Integer, List<Integer>> itemsByGroup = new HashMap<>();
            for (int i : itemsInOrder) {
                itemsByGroup.computeIfAbsent(group[i], __ -> new ArrayList<>()).add(i);
            }

            int[] ans = new int[n];
            int idx = 0;
            for (int g : groupsInOrder) {
                for (int i : itemsByGroup.getOrDefault(g, Collections.emptyList())) {
                    ans[idx++] = i;
                }
            }
            return ans;
        }

        private GraphInfo buildPrereqs(int numItems, int numGroups, int[] group, List<List<Integer>> beforeItems) {
            Prereq itemsPrereq = new Prereq(numItems);
            Prereq groupsPrereq = new Prereq(numGroups);

            for (int i = 0; i < numItems; i++) {
                for (int prereq : beforeItems.get(i)) {
                    itemsPrereq.dependOn.computeIfAbsent(prereq, __ -> new ArrayList<>()).add(i);
                    itemsPrereq.indegree[i]++;

                    // `prereq` and `i` must belong to different groups
                    if (group[prereq] != group[i]) {
                        groupsPrereq.dependOn.computeIfAbsent(group[prereq], __ -> new ArrayList<>()).add(group[i]);
                        groupsPrereq.indegree[group[i]]++;
                    }
                }
            }
            return new GraphInfo(itemsPrereq, groupsPrereq);
        }

        private List<Integer> topologicalSort(Prereq prereq) {
            List<Integer> ans = new ArrayList<>();
            Queue<Integer> q = new ArrayDeque<>();

            // start with items that have no dependencies
            for (int i = 0; i < prereq.indegree.length; i++) {
                if (prereq.indegree[i] == 0) {
                    q.offer(i);
                }
            }

            while (!q.isEmpty()) {
                int curr = q.poll();
                ans.add(curr);
                for (int neighbor : prereq.dependOn.getOrDefault(curr, Collections.emptyList())) {
                    prereq.indegree[neighbor]--;
                    if (prereq.indegree[neighbor] == 0) {
                        // all dependencies for neighbor got resolved
                        q.offer(neighbor);
                    }
                }
            }

            // check if there's a cycle
            if (ans.size() != prereq.indegree.length) {
                return Collections.emptyList();
            }
            return ans;
        }

        // Information required to perform a topological sort
        private static class Prereq {
            // dependOn[i] denotes items that depend on `i`, i.e. `i` is a prerequisite for every item in the dependOn[i] list
            final Map<Integer, List<Integer>> dependOn = new HashMap<>();
            final int[] indegree;

            Prereq(int n) {
                this.indegree = new int[n];
            }
        }

        private static class GraphInfo {
            final Prereq itemsPrereq;
            final Prereq groupsPrereq;

            GraphInfo(Prereq itemsPrereq, Prereq groupsPrereq) {
                this.itemsPrereq = itemsPrereq;
                this.groupsPrereq = groupsPrereq;
            }
        }
    }
}
