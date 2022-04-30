package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/evaluate-division/">Evaluate Division</a>
 * <p>
 * You are given an array of variable pairs equations and an array of real numbers values,
 * where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
 * Each Ai or Bi is a string that represents a single variable.
 * <p>
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 * <p>
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 * <p>
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= equations.length <= 20</li>
 *  <li>equations[i].length == 2</li>
 *  <li>1 <= Ai.length, Bi.length <= 5</li>
 *  <li>values.length == equations.length</li>
 *  <li>0.0 < values[i] <= 20.0</li>
 *  <li>1 <= queries.length <= 20</li>
 *  <li>queries[i].length == 2</li>
 *  <li>1 <= Cj.length, Dj.length <= 5</li>
 *  <li>Ai, Bi, Cj, Dj consist of lower case English letters and digits</li>
 * </ul>
 */
public interface EvaluateDivision {

    double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries);

    class EvaluateDivisionUsingDFS implements EvaluateDivision {

        @Override
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, Map<String, Double>> graph = buildGraph(equations, values);
            return processQueries(queries, graph);
        }

        private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
            Map<String, Map<String, Double>> graph = new HashMap<>();
            for (int i = 0; i < equations.size(); i++) {
                List<String> equation = equations.get(i);
                String a = equation.get(0);
                String b = equation.get(1);
                // a / b
                graph.computeIfAbsent(a, key -> new HashMap<>()).put(b, values[i]);
                // b / a
                graph.computeIfAbsent(b, key -> new HashMap<>()).put(a, 1 / values[i]);
            }
            return graph;
        }

        private double[] processQueries(List<List<String>> queries, Map<String, Map<String, Double>> graph) {
            double[] result = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                List<String> query = queries.get(i);
                String src = query.get(0);
                String dst = query.get(1);
                // src / dst = ?
                result[i] = evaluateDivision(src, dst, graph);
            }
            return result;
        }

        private double evaluateDivision(String src, String dst, Map<String, Map<String, Double>> graph) {
            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                return -1.0;
            }
            if (src.equals(dst)) {
                return 1.0;
            }
            return dfs(graph, src, dst, new HashSet<>());
        }

        private double dfs(Map<String, Map<String, Double>> graph, String src, String dst, Set<String> visited) {
            if (src.equals(dst)) {
                return 1.0;
            }
            if (visited.contains(src)) {
                return -1.0;
            }
            visited.add(src);
            Map<String, Double> adjList = graph.get(src);
            for (Map.Entry<String, Double> adj : adjList.entrySet()) {
                double result = dfs(graph, adj.getKey(), dst, visited);
                if (result > 0) {
                    return result * adj.getValue();
                }
            }
            return -1.0;
        }
    }

    class EvaluateDivisionUsingBFS implements EvaluateDivision {

        @Override
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, Map<String, Double>> graph = buildGraph(equations, values);
            return processQueries(graph, queries);
        }

        private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
            Map<String, Map<String, Double>> graph = new HashMap<>();
            for (int i = 0; i < equations.size(); i++) {
                List<String> equation = equations.get(i);
                String a = equation.get(0);
                String b = equation.get(1);
                // a / b
                graph.computeIfAbsent(a, key -> new HashMap<>()).put(b, values[i]);
                // b / a
                graph.computeIfAbsent(b, key -> new HashMap<>()).put(a, 1 / values[i]);
            }
            return graph;
        }

        private double[] processQueries(Map<String, Map<String, Double>> graph, List<List<String>> queries) {
            double[] ans = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                List<String> query = queries.get(i);
                String src = query.get(0);
                String dst = query.get(1);
                // src / dst = ?
                ans[i] = eval(graph, src, dst);
            }
            return ans;
        }

        private double eval(Map<String, Map<String, Double>> graph, String src, String dst) {
            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                return -1.0;
            }
            if (src.equals(dst)) {
                return 1.0;
            }
            return bfs(graph, src, dst);
        }

        private static class EvalResult {
            final String var;
            final double result;

            EvalResult(String var, double result) {
                this.var = var;
                this.result = result;
            }
        }

        private double bfs(Map<String, Map<String, Double>> graph, String src, String dst) {
            Queue<EvalResult> q = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();

            q.offer(new EvalResult(src, 1.0));
            visited.add(src);
            while (!q.isEmpty()) {
                EvalResult curr = q.poll();
                if (curr.var.equals(dst)) {
                    return curr.result;
                }

                Map<String, Double> adj = graph.get(curr.var);
                for (Map.Entry<String, Double> entry : adj.entrySet()) {
                    String var = entry.getKey();
                    double weight = entry.getValue();
                    if (!visited.contains(var)) {
                        q.offer(new EvalResult(var, weight * curr.result));
                        visited.add(var);
                    }
                }
            }
            return -1.0;
        }
    }
}
