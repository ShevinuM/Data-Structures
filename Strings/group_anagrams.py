'''
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
'''

class Solution:
    def groupAnagrams(self, strs):
        string_map = {}
        res = []
        
        for string in strs:
            sorted_str = "".join(sorted(string))
            if sorted_str in string_map:
                string_map["".join(sorted(string))].append(string)
            else:
                string_map["".join(sorted(string))] = [string]
        
        for value in string_map.values():
            res.append(value)
        
        return list(string_map.values())

    def test(self, strs):
        print("Input: strs = {0}, Output = {1}".format(strs, self.groupAnagrams(strs)))

sol = Solution()
sol.test(["eat","tea","tan","ate","nat","bat"])
sol.test([""])
sol.test(["a"])
sol.test(["a", "b"])
sol.test(["ab", "ba"])