'''
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
'''

from collections import Counter

# This solution has a time complexity of O(n) and a space complexity of O(n)
class Solution:
    def firstUniqChar(self, s: str) -> int:
        s_map = dict(Counter(s))
        for count in range(len(s)):
            if s_map.get(s[count]) == 1:
                return count
        return -1
    
    def test(self, s):
        print("Input: s = {0}, Output = {1}".format(s, self.firstUniqChar(s)))

sol = Solution()
sol.test("leetcode")
sol.test("loveleetcode")
sol.test("aabb")
sol.test("aaabbb")