# Time Complexity - O(n), Memory Complexity - O(n). It uses built in methods of python
'''
class Solution:
    def isPalindrome(s: str) -> bool:
        new_string = ""
        for character in s:
            if character.isalnum():
                new_string+=character.lower()
        return True if new_string == new_string[::-1] else False

    def test(s):
        print("Input : {0} \n"
            "Output: {1}".format(s, Solution.isPalindrome(s)))
        print()

    test("A man, a plan, a canal: Panama")
    test("race a car")
    test(" ")
'''

# An alternative solution which does not use any python built in methods and have a O(1) memory complexity
class Solution:
    def isPalindrome(self, s: str) -> bool:
        l, r = 0, len(s)-1
        while l < r:
            while l < r and not self.isAlphaNum(s[l]):
                l += 1
            while r > l and not self.isAlphaNum(s[r]):
                r -= 1
            if s[l].lower() != s[r].lower():
                return False
            l, r = l+1, r-1
        return True
            
    def isAlphaNum(self, c):
        return ord('a') <= ord(c) <= ord('z') or \
                ord('A') <= ord(c) <= ord('Z') or \
                ord('0') <= ord(c) <= ord('9')