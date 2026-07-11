package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/count-the-number-of-complete-components/">Count the Number of Complete Components</a>
 * <p>
 * You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1.
 * You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.
 * <p>
 * Return the number of complete connected components of the graph.
 * <p>
 * A connected component is a subgraph of a graph in which there exists a path between any two vertices,
 * and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.
 * <p>
 * A connected component is said to be complete if there exists an edge between every pair of its vertices.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 50</li>
 *  <li>0 <= edges.length <= n * (n - 1) / 2</li>
 *  <li>edges[i].length == 2</li>
 *  <li>0 <= ai, bi <= n - 1</li>
 *  <li>ai != bi</li>
 *  <li>There are no repeated edges.</li>
 * </ul>
 */
public interface CountNumberOfCompleteComponents {

    int countCompleteComponents(int n, int[][] edges);

    class CountNumberOfCompleteComponentsRev1 implements CountNumberOfCompleteComponents {

        @Override
        public int countCompleteComponents(int n, int[][] edges) {
            var uf = new UnionFind(n);
            for (var edge : edges) {
                uf.union(edge[0], edge[1]);
            }

            var count = 0;
            for (var component : uf.components()) {
                if (component.isComplete()) {
                    count++;
                }
            }
            return count;
        }

        static class UnionFind {
            final int[] parent;
            final Map<Integer, Component> components = new HashMap<>();

            UnionFind(int n) {
                parent = new int[n];
                for (var i = 0; i < n; i++) {
                    parent[i] = i;
                    components.put(i, new Component(1, 0));
                }
            }

            int find(int x) {
                if (x != parent[x]) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            boolean union(int x, int y) {
                var px = find(x);
                var py = find(y);

                var cx = components.get(px);
                if (px == py) {
                    components.put(px, cx.addEdge());
                    return false;
                }

                parent[px] = py;
                components.put(py, components.get(py).union(cx));
                components.remove(px);
                return true;
            }

            Collection<Component> components() {
                return components.values();
            }
        }

        record Component(
                int numVertices,
                int numEdges
        ) {
            Component union(Component that) {
                return new Component(numVertices + that.numVertices, numEdges + that.numEdges + 1);
            }

            Component addEdge() {
                return new Component(numVertices, numEdges + 1);
            }

            boolean isComplete() {
                // num pairs = C(n, 2) = n * (n - 1) / 2;
                return numVertices * (numVertices - 1) / 2 == numEdges;
            }
        }
    }

    class CountNumberOfCompleteComponentsRev2 implements CountNumberOfCompleteComponents {

        @Override
        public int countCompleteComponents(int n, int[][] edges) {
            var adj = new HashMap<Integer, Set<Integer>>();
            for (var edge : edges) {
                adj.computeIfAbsent(edge[0], _ -> new HashSet<>()).add(edge[1]);
                adj.computeIfAbsent(edge[1], _ -> new HashSet<>()).add(edge[0]);
            }

            var count = 0;
            var visited = new boolean[n];
            for (var i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }

                var component = traverse(adj, i, visited);
                if (complete(component, adj)) {
                    count++;
                }
            }
            return count;
        }

        private List<Integer> traverse(Map<Integer, Set<Integer>> adj, int source, boolean[] visited) {
            return dfs(adj, source, visited, new ArrayList<>());
        }

        private List<Integer> dfs(Map<Integer, Set<Integer>> adj, int node, boolean[] visited, List<Integer> result) {
            visited[node] = true;
            result.add(node);
            for (var neighbor : adj.getOrDefault(node, Set.of())) {
                if (!visited[neighbor]) {
                    dfs(adj, neighbor, visited, result);
                }
            }
            return result;
        }

        private boolean complete(List<Integer> component, Map<Integer, Set<Integer>> adj) {
            for (var i = 0; i < component.size() - 1; i++) {
                for (var j = i + 1; j < component.size(); j++) {
                    var u = component.get(i);
                    var v = component.get(j);
                    if (!adj.containsKey(u) || !adj.get(u).contains(v)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
