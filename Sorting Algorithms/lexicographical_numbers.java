/**
 * Given an integer n, return all the numbers in the range [1, n] sorted in
 * lexicographical order.
 * You must write an algorithm that runs in O(n) time and uses O(1) extra space.
 *
 * Constraints:
 * 1 <= n <= 5 * 10^4
 *
 * Example 1:
 * Input: n = 13
 * Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
 *
 * Example 2:
 * Input: n = 2
 * Output: [1,2]
 */

class Solution {
    /*
     * We are usijng a dfs approach to solve this problem. We start from 1 and
     * traverse. We multiply the current
     * number by 10 and add 0 to 9 to it. We do this until the current number is
     * greater than n. We add the current
     * number to the result list. We then repeat the process for the next number.
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, res, n);
        }
        return res;
    }

    public void dfs(int curr, List<Integer> res, int n) {
        if (curr > n) {
            return;
        }
        res.add(curr);
        for (int i = 0; i <= 9; i++) {
            if ((10 * curr) + i > n) {
                return;
            }
            dfs((10 * curr) + i, res, n);
        }
    }
}