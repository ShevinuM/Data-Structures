/**
 * Problem Statement:
 * 
 * In English, we have a concept called "root", which can be followed by another
 * word, known as "successor", to form a longer word.
 * For example, when the root "an" is followed by the successor "other", we get
 * the new word "another".
 * 
 * Given a dictionary of roots and a sentence composed of words separated by
 * spaces, the task is to replace all the successors
 * in the sentence with their corresponding roots. If a successor can be
 * replaced by multiple roots, it should be replaced
 * by the shortest root.
 * 
 * Return the modified sentence after all such replacements.
 * 
 * Constraints:
 * - 1 <= dictionary.length <= 1000
 * - 1 <= dictionary[i].length <= 100
 * - dictionary[i] consists of only lower-case letters.
 * - 1 <= sentence.length <= 10^6
 * - sentence consists of only lower-case letters and spaces.
 * - The number of words in the sentence is between 1 and 1000.
 * - The length of each word in the sentence is between 1 and 1000.
 * - Every two consecutive words in the sentence are separated by exactly one
 * space.
 * - Sentence does not have leading or trailing spaces.
 * 
 * Example 1:
 * Input: dictionary = ["cat", "bat", "rat"], sentence = "the cattle was rattled
 * by the battery"
 * Output: "the cat was rat by the bat"
 * 
 * Example 2:
 * Input: dictionary = ["a", "b", "c"], sentence = "aadsfasf absbs bbab
 * cadsfafs"
 * Output: "a a b c"
 */

class Solution {

    private class Trie {
        Node root;

        private class Node {
            HashMap<Character, Node> children;
            boolean isWord;

            public Node() {
                this.children = new HashMap<>();
                this.isWord = false;
            }
        }

        public Trie() {
            this.root = new Node();
        }

        public void addWord(String word) {
            Node curr = this.root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new Node());
                }
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }

        public String getMatch(String word) {
            Node curr = this.root;
            String res = "";
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.isWord) {
                    return res;
                }
                if (!curr.children.containsKey(c)) {
                    return word;
                }
                res = res + c;
                curr = curr.children.get(c);
            }
            return word;
        }

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String root : dictionary) {
            trie.addWord(root);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String match = trie.getMatch(words[i]);
            words[i] = match;
        }
        return String.join(" ", words);
    }
}