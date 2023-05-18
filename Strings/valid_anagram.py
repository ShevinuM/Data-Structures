'''
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
'''

# This is my initial solution to this problem. It uses two hashmaps to store the characters and checks if the two hashmaps
# are equal at the end because hashmaps compare the contents to be equal. I knew that using a single hashmap would be more efficient
# but would just require more code when coding this.
class Solution1:
    def isAnagram(self, s: str, t: str) -> bool:
        s_map, t_map = {}, {}
        for character in s: s_map[character] = s_map.get(character,0) + 1
        for character in t: t_map[character] = t_map.get(character,0) + 1
        return s_map == t_map
    
    def test(self, s, t):
        print("s = {0}, t = {1}, Output = {2}".format(s, t, self.isAnagram(s, t)))

# A better approach. Space complexity reduced from O(2n) to O(n)
class Solution2:
    def isAnagram(self, s: str, t: str) -> bool:
        s_map= {}
        for character in s: s_map[character] = s_map.get(character,0) + 1
        for character in t:
            if character not in s_map:
                return False
            s_map[character] = s_map.get(character) - 1
        for (character, value) in s_map.items():
            if value != 0:
                return False
        return True
    
    def test(self, s, t):
        print("s = {0}, t = {1}, Output = {2}".format(s, t, self.isAnagram(s, t)))

sol = Solution1()
print("Test for solution 1")
sol.test(s ="anagram", t = "nagaram")
sol.test(s = "rat", t = "car")
print()
sol2 = Solution2()
print("Test for solution 2")
sol2.test(s ="anagram", t = "nagaram")
sol2.test(s = "rat", t = "car")
