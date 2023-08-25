/**
 * Design a data structure that supports adding new words and finding if a
 * string matches any previously added string.
 *
 * Implement the WordDictionary class:
 * 
 * - WordDictionary() Initializes the object.
 * - void addWord(word) Adds word to the data structure, it can be matched
 * later.
 * - bool search(word) Returns true if there is any string in the data structure
 * that matches word or false otherwise. word may contain dots '.' where dots
 * can be matched with any letter.
 * 
 * Example:
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 * 
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 * 
 * Constraints:
 * 
 * 1 <= word.length <= 25
 * word in addWord consists of lowercase English letters.
 * word in search consist of '.' or lowercase English letters.
 * There will be at most 2 dots in word for search queries.
 * At most 104 calls will be made to addWord and search.
 */

class WordDictionary {

    Node root;

    private class Node {

        HashMap<Character, Node> children;
        boolean isWord;

        public Node() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }

    public WordDictionary() {
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

    public boolean search(String word) {
        return helper(word, this.root, 0);
    }

    public boolean helper(String word, Node curr, int index) {
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (Node child : curr.children.values()) {
                    if (helper(word, child, i + 1)) {
                        return true;
                    }
                }
                return false;
            }

            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
