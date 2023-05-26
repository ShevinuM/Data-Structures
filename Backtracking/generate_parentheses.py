class Solution:
    def generateParenthesis(self, n: int):
        # The solution to this from my understanding is to use backtracking with depth first search
        # So we use iteration for this problem. 
        # We first define the basecase which checks if the sum of the number of opening and closing
        # paranthesis is equal to twice the n value. I know i could have written this more simply,
        # but this sort of explains the logic more. We then append the obtained string to the result.
        # The first iterative call happens when number of opening paranthesis is less than n. If this
        # is the case we can add an opening paranthesis.
        # The next iterative call happens when the number of opening paranthesis is greater than the 
        # number of closing paranthesis. If this is the case, we can add a closing paranthesis.

        def dfs(opening, closing, s):
            if (opening+closing) == n * 2: 
                res.append(s)
                return

            if opening < n: dfs(opening+1, closing, s +"(")
            
            if opening > closing: dfs(opening, closing+1, s + ")")
            
        res = []
        dfs(0, 0, "")
        return res
    
    def test(self, n):
        print("Input: n = {0}, Output: {1}".format(n, self.generateParenthesis(n)))

sol = Solution()
sol.test(3)
sol.test(1)
sol.test(2)
