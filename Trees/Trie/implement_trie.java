/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset 
 * of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 * 
 * Implement the Trie class:
 * - Trie() Initializes the trie object.
 * - void insert(String word) Inserts the string word into the trie.
 * - boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * - boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false 
 * otherwise.
 */

import java.util.HashMap;

/**
This class represents a single TrieNode. 
Each TrieNode has a HashMap representing it's children. In the HashMap, each key is a String
representing the character. This key is mapped to a TrieNode of that character. Each TrieNode also
has an instance variable which marks if the node is the end of a word.
 */
class TrieNode {
    /**
    Since this is a coding challenge meant to be completed within a timeframe, I'm using a public 
    instance variable, however in an ideal scenario, I understand the importance of using private
    instance variables along with getters and setters.
     */
    public HashMap<Character, TrieNode> children;
    public Boolean end_of_a_word;

    public TrieNode() {
        this.children = new HashMap<>();
        this.end_of_a_word = false;
    }
}

class Trie {
    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    /**
    Each TrieNode has a hashmap of children. We check if each character is in it's children, if so
    we move the current pointer to that child node and continue.
     */
    public void insert(String word) {
        char c;
        TrieNode curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);

            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.end_of_a_word = true;
    }
    
    /**
    We start with the root and check if each character is a child of the curr node. At the end we check
    if the last node marks the end of a word and if so, we return true.
     */
    public boolean search(String word) {
        char c;
        TrieNode curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                return false;
            } else {
                curr = curr.children.get(c);
            }
        }
        return curr.end_of_a_word;
    }
    
    /**
    Same as seach but we don't check for end of the word
     */
    public boolean startsWith(String prefix) {
        char c;
        TrieNode curr = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            c = prefix.charAt(i);
            if (!curr.children.containsKey(c)) {
                return false;
            } else {
                curr = curr.children.get(c);
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */