'''
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
'''

from collections import Counter

# This was my initial solution to this problem. It has a time complexity of O(n^2) and a space complexity of O(n)
class Solution:
    def intersect(self, nums1, nums2):
        nums1, nums2 = (nums2, nums1) if len(nums2) > len(nums1) else (nums1, nums2)
        res = []
        nums1_map = dict(Counter(nums1))
        for elementA in nums2:
            for elementB in nums1_map:
                if elementA == elementB and nums1_map[elementB] > 0:
                    res.append(elementA)
                    nums1_map[elementB] = nums1_map.get(elementB) - 1
                    break
        return res
