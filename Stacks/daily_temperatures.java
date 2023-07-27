/*
Given an array of integers temperatures that represents the daily temperatures, your task is to return an array "answer" such that "answer[i]" is the number of days you have to wait after the "i-th" day to get a warmer temperature. If there is no future day for which this is possible, keep "answer[i]" equal to 0.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]

Constraints:
1. The length of the "temperatures" array is between 1 and 10^5, inclusive. 
2. Each temperature in the "temperatures" array is an integer between 30 and 100, inclusive.
*/

// Optimal Solution : The brute force solution can be found in the arrays section
class Solution {
    /*
     * This solution uses a stack. The stack stores the index of the temperature and the temperature itself. As we iterate
     * over the array, we check if the current temperature is greater than the temperature at the top of the stack. If it is,
     * we pop the stack and calculate the difference between the current index and the index at the top of the stack. We
     * store this difference in the temperatures array at the index of the top of the stack. We keep doing this until the
     * current temperature is less than the temperature at the top of the stack. We then push the current temperature and
     * its index onto the stack. We repeat this process until we reach the end of the array. At the end, we pop the stack
     * and set the value in the temperatures array at the index of the top of the stack to 0. We repeat this until the stack
     * is empty. We then return the temperatures array.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1) { return new int[]{0}; }
        Stack<int[]> stack = new Stack<>();
        int[] popped = new int[2];
        for (int index = 0; index < temperatures.length; index++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && temperatures[index] > stack.peek()[0]) {
                    popped = stack.pop();
                    temperatures[popped[1]] = index - popped[1];
                }
            }
            stack.push(new int[] {temperatures[index], index});
        }
        while (!stack.isEmpty()) {
            popped = stack.pop();
            temperatures[popped[1]] = 0;
        }
        return temperatures;
    }
}
