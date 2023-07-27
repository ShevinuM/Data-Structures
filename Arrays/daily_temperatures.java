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

class Solution {
    // Brute Force Approach
    /*
     * For each day, I iterate through the rest of the array to find the next day that has a higher temperature. If I find
     * a day with a higher temperature, I add the difference between the two days to the result array.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1) { return new int[]{0}; }
        int[] res = new int[temperatures.length];
        for (int day = 0; day < temperatures.length - 1; day++) {
            for (int index=day+1 ; index < temperatures.length; index++) {
                if (temperatures[index] > temperatures[day]) {
                    res[day] = index - day; 
                    break;
                }
            }
        }
        return res;
    }
}

