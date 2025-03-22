package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/">Find All Possible Recipes from Given Supplies</a>
 * <p>
 * You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients.
 * The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i].
 * A recipe can also be an ingredient for other recipes, i.e., ingredients[i] may contain a string that is in recipes.
 * <p>
 * You are also given a string array supplies containing all the ingredients that you initially have,
 * and you have an infinite supply of all of them.
 * <p>
 * Return a list of all the recipes that you can create. You may return the answer in any order.
 * <p>
 * Note that two recipes may contain each other in their ingredients.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == recipes.length == ingredients.length</li>
 *  <li>1 <= n <= 100</li>
 *  <li>1 <= ingredients[i].length, supplies.length <= 100</li>
 *  <li>1 <= recipes[i].length, ingredients[i][j].length, supplies[k].length <= 10</li>
 *  <li>recipes[i], ingredients[i][j], and supplies[k] consist only of lowercase English letters.</li>
 *  <li>All the values of recipes and supplies combined are unique.</li>
 *  <li>Each ingredients[i] does not contain any duplicate values.</li>
 * </ul>
 */
public interface FindAllPossibleRecipesFromGivenSupplies {

    List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies);

    class FindAllPossibleRecipesFromGivenSuppliesRev1 implements FindAllPossibleRecipesFromGivenSupplies {

        @Override
        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            final var n = recipes.length;

            var cookbook = new HashMap<String, List<String>>();
            for (var i = 0; i < n; i++) {
                cookbook.put(recipes[i], ingredients.get(i));
            }

            var canCook = new HashMap<String, Boolean>();
            for (var supply : supplies) {
                canCook.put(supply, true);
            }

            var ans = new ArrayList<String>();
            for (var recipe : recipes) {
                if (dfs(recipe, cookbook, canCook)) {
                    ans.add(recipe);
                }
            }
            return ans;
        }

        private boolean dfs(String recipe, Map<String, List<String>> cookbook, Map<String, Boolean> canCook) {
            if (canCook.containsKey(recipe)) {
                return canCook.get(recipe);
            }

            if (!cookbook.containsKey(recipe)) {
                return false;
            }

            canCook.put(recipe, false); // handles cycle detection
            for (var ingredient : cookbook.get(recipe)) {
                if (!dfs(ingredient, cookbook, canCook)) {
                    return false;
                }
            }

            canCook.put(recipe, true);
            return true;
        }
    }
}
