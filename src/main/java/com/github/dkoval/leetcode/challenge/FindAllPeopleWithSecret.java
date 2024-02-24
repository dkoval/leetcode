package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-all-people-with-secret/">Find All People With Secret (Hard)</a>
 * <p>
 * You are given an integer n indicating there are n people numbered from 0 to n - 1.
 * You are also given a 0-indexed 2D integer array meetings where meetings[i] = [xi, yi, timei]
 * indicates that person xi and person yi have a meeting at timei. A person may attend multiple meetings at the same time.
 * Finally, you are given an integer firstPerson.
 * <p>
 * Person 0 has a secret and initially shares the secret with a person firstPerson at time 0. This secret is then shared
 * every time a meeting takes place with a person that has the secret. More formally, for every meeting,
 * if a person xi has the secret at timei, then they will share the secret with person yi, and vice versa.
 * <p>
 * The secrets are shared instantaneously. That is, a person may receive the secret and share it with people
 * in other meetings within the same time frame.
 * <p>
 * Return a list of all the people that have the secret after all the meetings have taken place.
 * You may return the answer in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n <= 10^5</li>
 *  <li>1 <= meetings.length <= 10^5</li>
 *  <li>meetings[i].length == 3</li>
 *  <li>0 <= xi, yi <= n - 1</li>
 *  <li>xi != yi</li>
 *  <li>1 <= timei <= 10^5</li>
 *  <li>1 <= firstPerson <= n - 1</li>
 * </ul>
 */
public interface FindAllPeopleWithSecret {

    List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson);

    class FindAllPeopleWithSecretRev1 implements FindAllPeopleWithSecret {

        @Override
        public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
            // sort meetings by time in asc order
            Arrays.sort(meetings, Comparator.comparingInt(it -> it[2]));

            // model all the meetings happening at the same time as a graph
            List<Graph> groups = new ArrayList<>();
            for (int i = 0; i < meetings.length; i++) {
                if (i == 0 || meetings[i][2] != meetings[i - 1][2]) {
                    groups.add(new Graph());
                }
                Graph last = groups.get(groups.size() - 1);
                last.addEdge(meetings[i][0], meetings[i][1]);
            }

            Set<Integer> knowSecret = new HashSet<>(Arrays.asList(0, firstPerson));
            for (Graph g : groups) {
                traverse(g, knowSecret);
            }
            return new ArrayList<>(knowSecret);
        }

        private void traverse(Graph g, Set<Integer> knowSecret) {
            Set<Integer> visited = new HashSet<>();
            for (int u : g.adj.keySet()) {
                if (knowSecret.contains(u) && !visited.contains(u)) {
                    dfs(g, u, visited, knowSecret);
                }
            }
        }

        private void dfs(Graph g, int u, Set<Integer> visited, Set<Integer> knowSecret) {
            visited.add(u);
            for (int v : g.adj.getOrDefault(u, Collections.emptyList())) {
                if (!visited.contains(v)) {
                    knowSecret.add(v);
                    dfs(g, v, visited, knowSecret);
                }
            }
        }

        private static class Graph {
            final Map<Integer, List<Integer>> adj = new HashMap<>();

            void addEdge(int u, int v) {
                adj.computeIfAbsent(u, __ -> new ArrayList<>()).add(v);
                adj.computeIfAbsent(v, __ -> new ArrayList<>()).add(u);
            }
        }
    }
}
