package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/reconstruct-itinerary/">Reconstruct Itinerary (Hard)</a>
 * <p>
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight.
 * Reconstruct the itinerary in order and return it.
 * <p>
 * All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK".
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
 * <p>
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
 */
public interface ReconstructItinerary {

    List<String> findItinerary(List<List<String>> tickets);

    class ReconstructItineraryRev2 implements ReconstructItinerary {

        @Override
        public List<String> findItinerary(List<List<String>> tickets) {
            int n = tickets.size();

            tickets.sort((ticket1, ticket2) -> {
                String src1 = ticket1.get(0);
                String dst1 = ticket1.get(1);

                String src2 = ticket2.get(0);
                String dst2 = ticket2.get(1);

                return src1.equals(src2) ? dst1.compareTo(dst2) : src1.compareTo(src2);
            });

            Map<String, List<String>> adj = new LinkedHashMap<>();
            for (List<String> ticket : tickets) {
                adj.computeIfAbsent(ticket.get(0), __ -> new ArrayList<>()).add(ticket.get(1));
            }

            List<String> ans = new ArrayList<>();
            ans.add("JFK");
            return dfs(adj, "JFK", ans, new HashMap<>(), n) ? ans : Collections.emptyList();
        }

        private boolean dfs(Map<String, List<String>> adj, String curr, List<String> ans, Map<String, Set<Integer>> used, int tickets) {
            if (ans.size() == tickets + 1) {
                return true;
            }

            int i = 0;
            Set<Integer> usedNow = used.computeIfAbsent(curr, __ -> new HashSet<>());
            for (String next : adj.getOrDefault(curr, Collections.emptyList())) {
                if (!usedNow.contains(i)) {
                    ans.add(next);
                    usedNow.add(i);

                    if (dfs(adj, next, ans, used, tickets)) {
                        return true;
                    }

                    // backtrack
                    ans.remove(ans.size() - 1);
                    usedNow.remove(i);
                }
                i++;
            }
            return false;
        }
    }
}
