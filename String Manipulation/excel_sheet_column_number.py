'''
Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
'''
class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        count = 1
        char_map = {}
        for char in 'ABCDEFGHIJKLMNOPQRSTUVWXYZ':
            char_map[char] = count
            count += 1
        count = len(columnTitle)-1
        col_no = 0
        for char in columnTitle:
            col_no += (26**count)*char_map[char]
            count-=1
        return col_no

    def test(self, columnTitle):
        print("Input: columnTitle = {0}, " 
              "Output : {1}".format(columnTitle, self.titleToNumber(columnTitle)))
        print()

sol = Solution()
sol.test("A")
sol.test("AB")
sol.test("ZY")