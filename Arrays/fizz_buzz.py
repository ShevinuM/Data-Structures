'''
Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.

'''

# This solution has a time complexity of O(n) and a space complexity of O(n)
class Solution1:
    def fizzBuzz(self, n: int):
        res = [""]*n
        for count in range(n):
            if (count+1)%3 == 0 and (count+1)%5 == 0:
                res[count] = "FizzBuzz"
            elif (count+1)%3 == 0:
                res[count] = "Fizz"
            elif (count+1)%5 == 0:
                res[count] = "Buzz"
            else:
                res[count] = str(count+1)
        return res

    def test(self, n: int):
        print("Input n: {0:2}, Output: {1}".format(n, self.fizzBuzz(n)))

sol = Solution1()
sol.test(3)
sol.test(5)
sol.test(15)
sol.test(1)