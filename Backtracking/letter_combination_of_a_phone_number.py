'''
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
'''

class Solution:
    def letterCombinations(self, digits: str):
        res = []
        letter_map = {}
        letter_map["2"] = "abc"
        letter_map["3"] = "def"
        letter_map["4"] = "ghi"
        letter_map["5"] = "jkl"
        letter_map["6"] = "mno"
        letter_map["7"] = "pqrs"
        letter_map["8"] = "tuv"
        letter_map["9"] = "wxyz"
        
        def createString(index, formedString):
            if len(formedString) == len(digits):
                res.append(formedString)
                return
            for character in letter_map[digits[index]]: createString(index + 1, formedString + character)
        
        createString(0, "")
        return res if digits else []
    
    def test(self, digits):
        print("Input: digits = {0}, Output: {1}".format(digits, self.letterCombinations(digits)))

sol = Solution()
sol.test("23")
sol.test("")
sol.test("2")
sol.test("234")