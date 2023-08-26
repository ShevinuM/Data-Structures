/**
 * Given an m x n board of characters and a list of strings words, return all
 * words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where "adjacent cells" are
 * horizontally or vertically neighboring. The same letter cell may not be used
 * more than once in a word.
 *
 * Example 1:
 * Input: board =
 * [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
 * words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * 
 * Example 2:
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 * 
 * Constraints:
 * - m == board.length
 * - n == board[i].length
 * - 1 <= m, n <= 12
 * - board[i][j] is a lowercase English letter.
 * - 1 <= words.length <= 3 * 10^4
 * - 1 <= words[i].length <= 10
 * - words[i] consists of lowercase English letters.
 * - All the strings of words are unique.
 */

class Solution {
    /*
     * This solution uses backtracking and a trie to solve the problem. We first store the words in a trie. Then we iterate through the board and search for words in the trie. We use backtracking to search for words in the trie. When we visit a cell, we mark it as '#' to indicate that we have visited it. We then check if the current character is in the trie. If it is, we continue searching for words in the trie. If we find a word, we add it to the result list. We then backtrack by marking the cell as the original character and continue searching for words in the trie.
     */

    private class Trie {
        Node root;
        List<String> res;

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
            this.res = new ArrayList<>();
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

        public List<String> search(char[][] board) {
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[0].length; y++) {
                    searchHelper(board, this.root, x, y, "");
                }
            }

            return this.res;
        }

        public void searchHelper(char[][] board, Node curr, int x, int y, String word) {
            /**
             * go right -> board[m][n+1]
             * go left -> board[m][n-1]
             * go up -> board[m-1][n]
             * go down -> board[m+1][n]
             */
            int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
            if (x >= board.length || x < 0 || y >= board[0].length || y < 0) {
                return;
            }
            char c = board[x][y];
            if (c == '#' || !curr.children.containsKey(c)) {
                return;
            }
            board[x][y] = '#';
            curr = curr.children.get(c);
            word += c;
            if (curr.isWord) {
                this.res.add(word);
                curr.isWord = false;
            }
            for (int[] direction : directions) {
                searchHelper(board, curr, x + direction[0], y + direction[1], word);
            }
            board[x][y] = c;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        return trie.search(board);
    }
}