package striverSDEsheet.day27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/search-suggestions-system/
 */
public class SearchSuggestionSystems {

    public static void main(String[] args) {
        String[] products = new String[] { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
        String searchWord = "mouse";

        List<List<String>> ans = suggestedProducts(products, searchWord);

        ans.stream().forEach(list -> {
            list.stream().forEach(val -> System.out.print(val + " "));
            System.out.println();
        });
    }

    /**
     * Time complexity: O(m) where m is the number of characters in products.
     * Space complexity: O(m*n) where n is the number of products.
     * 
     * @param products
     * @param searchWord
     * @return
     */
    private static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String product : products)
            insert(root, product);

        List<List<String>> results = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            if ((root = root.children[c - 'a']) == null)
                break;
            results.add(root.getTopThree());
        }

        while (results.size() < searchWord.length())
            results.add(new ArrayList<>());
        return results;
    }

    private static void insert(TrieNode root, String word) {
        for (char c : word.toCharArray()) {
            if (root.children[c - 'a'] == null)
                root.children[c - 'a'] = new TrieNode();
            root = root.children[c - 'a'];
            root.addToPQ(word);
        }
    }

    static class TrieNode {
        public TrieNode[] children;
        public PriorityQueue<String> pq;

        public TrieNode() {
            children = new TrieNode[26];
            pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        }

        public void addToPQ(String word) {
            pq.add(word);
            if (pq.size() > 3)
                pq.poll();
        }

        public List<String> getTopThree() {
            List<String> topThree = new ArrayList<>();
            while (!pq.isEmpty())
                topThree.add(pq.poll());
            Collections.reverse(topThree);
            return topThree;
        }
    }
}
