package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/design-browser-history/">Design Browser History</a>
 * <p>
 * You have a browser of one tab where you start on the homepage and you can visit another url,
 * get back in the history number of steps or move forward in the history number of steps.
 * <p>
 * Implement the BrowserHistory class:
 * <ul>
 *  <li>BrowserHistory(string homepage) Initializes the object with the homepage of the browser.</li>
 *  <li>void visit(string url) Visits url from the current page. It clears up all the forward history.</li>
 *  <li>string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x,
 *  you will return only x steps. Return the current url after moving back in history at most steps.
 *  </li>
 *  <li>string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x,
 *  you will forward only x steps. Return the current url after forwarding in history at most steps.
 *  </li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= homepage.length <= 20</li>
 *  <li>1 <= url.length <= 20</li>
 *  <li>1 <= steps <= 100</li>
 *  <li>homepage and url consist of  '.' or lower case English letters.</li>
 *  <li>At most 5000 calls will be made to visit, back, and forward.</li>
 * </ul>
 */
public abstract class BrowserHistory {

    public BrowserHistory(String homepage) {
        // implement
    }

    public abstract void visit(String url);

    public abstract String back(int steps);

    public abstract String forward(int steps);

    public static class BrowserHistoryRev1 extends BrowserHistory {
        private final List<String> pages = new ArrayList<>();
        private int currPage = 0;
        private int lastPage = 0;

        public BrowserHistoryRev1(String homepage) {
            super(homepage);
            pages.add(homepage);
        }

        @Override
        public void visit(String url) {
            if (currPage < pages.size() - 1) {
                pages.set(currPage + 1, url);
            } else {
                pages.add(url);
            }
            currPage++;
            lastPage = currPage;
        }

        @Override
        public String back(int steps) {
            currPage = Math.max(currPage - steps, 0);
            return pages.get(currPage);
        }

        @Override
        public String forward(int steps) {
            currPage = Math.min(currPage + steps, lastPage);
            return pages.get(currPage);
        }
    }
}
