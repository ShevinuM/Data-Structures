/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Example 3:
 * Input: candidates = [2], target = 1
 * Output: []
 *
 * Constraints:
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 */

class Solution1 {
    int [] candidates;
    int target;
    Set<List<Integer>> combi_set = new HashSet<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*
            We can have a set which contains the lists of combinations.
            Each list will be sorted so that the set will remove duplicates.
            We can explore every single path and keep track of the sum while exploring.
            If the sum == target, we add it to the set and break.
            If the sum > target, we break
            Else we keep exploring.
            At the end we convert the set to a list.

            Time Complexity: O(K * 2^N) where k is the average length of each combination and N is the number of candidates.
        */
        this.candidates = candidates;
        this.target = target;
        backtrack(new ArrayList<>(), 0);
        for (List<Integer> combi : this.combi_set) { this.res.add(combi); }
        return this.res;
    }

    public void backtrack(List<Integer> combi, int curr_sum) {
        // Base Case 1
        if (curr_sum == this.target) {
            Collections.sort(combi);
            combi_set.add(combi);
            return;
        }
        // Base Case 2
        if (curr_sum > this.target) { return; }
        for (int candidate : this.candidates) {
            combi.add(candidate);
            backtrack(new ArrayList<>(combi), curr_sum + candidate);
            combi.remove(combi.size()-1);
        }
    }
}

class Solution2 {
    int [] candidates;
    int target;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*
            More optimized solution which avoids dulplicates without using a set. For each path, 
            the number of elements of each type is unique. When we go down one path and include one
            of the candidates, in the other path we don't include the candidate.

            Time Complexity: O(2^n)
        */
        this.candidates = candidates;
        this.target = target;
        backtrack(new ArrayList<>(), 0, new ArrayList<>());
        return this.res;
    }

    public void backtrack(List<Integer> combi, int curr_sum, List<Integer> toAvoid) {
        // Base Case 1
        if (curr_sum == this.target) {
            this.res.add(combi);
            return;
        }
        // Base Case 2
        if (curr_sum > this.target) { return; }
        for (int candidate : this.candidates) {
            if (toAvoid.contains(candidate)) { continue; }
            combi.add(candidate);
            backtrack(new ArrayList<>(combi), curr_sum + candidate, new ArrayList<>(toAvoid));
            combi.remove(combi.size()-1);
            toAvoid.add(candidate);
        }
    }
}