/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas 
and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead 
and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23

Constraints:
1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
*/

class Solution {
    int[] piles;
    int h;

    public int minEatingSpeed(int[] piles, int h) {
        /*
         * [3, 6, 7, 11]
         * 0th pile -> 3
         * 1st pile -> 6
         * 2nd pile -> 7
         * 3rd pile -> 11
         * 
         * k = bananas per hour eating speed
         * 
         * each hour -> k-bananas in 1 pile
         * 
         * goal: eat all bananas in h hours with the least k value
         * 
         * The maximum possible time it could take is if koko eats 1 per
         * hour.
         * 
         * The minimum possible it could take is if koko eats the max
         * value of piles[i]
         */
        this.piles = piles;
        this.h = h;
        long right = Arrays.stream(piles).max().getAsInt();
        long left = 1;
        long mid;
        long min = right;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (kokoCanEat(mid)) {
                min = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int) min;

    }

    public Boolean kokoCanEat(long k) {
        long max = 0;
        for (long pile : this.piles) {
            max = max + (pile - 1) / k + 1;
        }
        return max <= h;
    }

}
