package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/featured/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3474/">Evaluate Division</a>
 */
public class EvaluateDivisionJava {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        return processQueries(queries, graph);
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];

            String a = equation.get(0);
            String b = equation.get(1);
            graph.computeIfAbsent(a, key -> new HashMap<>()).put(b,value);
            graph.computeIfAbsent(b, key -> new HashMap<>()).put(a, 1 / value);
        }
        return graph;
    }

    private double[] processQueries(List<List<String>> queries, Map<String, Map<String, Double>> graph) {
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            result[i] = evaluateDivision(query.get(0), query.get(1), graph);
        }
        return result;
    }

    private double evaluateDivision(String q1, String q2, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(q1) || !graph.containsKey(q2)) {
            return -1.0;
        }
        if (q1.equals(q2)) {
            return 1.0;
        }
        return dfs(graph, q1, q2, new HashSet<>());
    }

    private double dfs(Map<String, Map<String, Double>> graph, String source, String target, Set<String> visited) {
        if (source.equals(target)) {
            return 1.0;
        }
        if (visited.contains(source)) {
            return -1.0;
        }
        visited.add(source);
        Map<String, Double> adjList = graph.get(source);
        for (Map.Entry<String, Double> adj : adjList.entrySet()) {
            double result = dfs(graph, adj.getKey(), target, visited);
            if (result > 0) {
                return result * adj.getValue();
            }
        }
        return -1.0;
    }
}
