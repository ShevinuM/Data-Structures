/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * 
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 *
 * Constraints:
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */

 /*
  * This is a backtracking problem and therefore we need to explore all possible paths.I visualize this problem as a tree and visit each
  * node in order. After visiting each node, it is added to the combination. Once the length of the combination is equal to k, I add
  * the combination to the result list. I then backtrack and remove the last element from the combination and continue exploring other
  * paths.
  */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int n, k;

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> combi = new ArrayList<>();
        this.n = n;
        this.k = k;
        backtrack(1, combi);
        return res;
    }

    public void backtrack(int start, List<Integer>combi) {
        // base case
        if (combi.size() == k) {
            List<Integer> clone = new ArrayList<>(combi);
            res.add(clone);
            return;
        }
        for (int count = start; count <= n; count++) {
            combi.add(count);
            backtrack(count + 1, combi);
            combi.remove(combi.size() - 1);
        }
    }
}

