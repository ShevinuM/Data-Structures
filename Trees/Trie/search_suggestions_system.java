/**
 * You are given an array of strings products and a string searchWord.
 * 
 * Design a system that suggests at most three product names from products after
 * each character of searchWord is typed.
 * Suggested products should have common prefix with searchWord. If there are
 * more than three products with a common prefix,
 * return the three lexicographically minimum products.
 *
 * Return a list of lists of the suggested products after each character of
 * searchWord is typed.
 *
 * Example 1:
 *
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"],
 * searchWord = "mouse"
 * Output:
 * [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
 * Explanation: products sorted lexicographically =
 * ["mobile","moneypot","monitor","mouse","mousepad"].
 * After typing m and mo all products match and we show user
 * ["mobile","moneypot","monitor"].
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"].
 *
 * Example 2:
 *
 * Input: products = ["havana"], searchWord = "havana"
 * Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * Explanation: The only word "havana" will be always suggested while typing the
 * search word.
 *
 * Constraints:
 *
 * 1 <= products.length <= 1000
 * 1 <= products[i].length <= 3000
 * 1 <= sum(products[i].length) <= 2 * 104
 * All the strings of products are unique.
 * products[i] consists of lowercase English letters.
 * 1 <= searchWord.length <= 1000
 * searchWord consists of lowercase English letters.
 */

class Solution {

    private class Trie {

        TrieNode root;

        private class TrieNode {
            HashMap<Character, TrieNode> children;
            List<String> suggestions;

            public TrieNode() {
                this.children = new HashMap<>();
                this.suggestions = new ArrayList<>();
            }
        }

        public Trie() {
            this.root = new TrieNode();
        }

        public void addProduct(String product) {
            TrieNode curr = this.root;
            for (int i = 0; i < product.length(); i++) {
                char c = product.charAt(i);
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
                curr.suggestions.add(product);
                Collections.sort(curr.suggestions);
                if (curr.suggestions.size() > 3) {
                    curr.suggestions.remove(curr.suggestions.size() - 1);
                }
            }
        }

        public List<String> search(String s) {
            TrieNode curr = this.root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!curr.children.containsKey(c)) {
                    return new ArrayList<>();
                }
                curr = curr.children.get(c);
            }
            return curr.suggestions;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.addProduct(product);
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String s = searchWord.substring(0, i + 1);
            res.add(trie.search(s));
        }
        return res;
    }
}
