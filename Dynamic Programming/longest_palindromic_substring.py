class Solution:
    # brute-force approach. This was my initial approach with a time complexity of O(n^3)
    def longestPalindrome1(s: str) -> str:
            reversed_string = s[::-1] # reverse the string
            max = 0
            for count in range (len(s)):
                substring = s[count:]
                for index in range (len(substring)):
                    subsubstring = substring[:index+1]
                    if subsubstring == subsubstring[::-1]:
                        len_longest = len(subsubstring)
                        if len_longest > max:
                            max = len_longest
                            longest_substring = subsubstring
            return longest_substring

    # This was my second approach with an overall time complexity of O(n^2)
    def longestPalindrome2(s: str) -> str:
        left, right = 1, 1
        substring =""
        max = 1
        max_substring = ""

        for count in range (len(s)):
            length_of_substring = 0
            substring = ""
            left, right = count, count
            while left >= 0 and right < len(s) and s[left] == s[right]:
                if left != right:
                    length_of_substring += 2
                    substring = s[left] + substring + s[right]
                else:
                    length_of_substring+=1
                    substring = s[left]
                if length_of_substring >= max:
                    max = length_of_substring
                    max_substring = substring
                left, right = left-1, right+1
            
            substring = ""
            length_of_substring = 0
            left, right = count, count+1
            while left >= 0 and right < len(s) and s[left] == s[right]:
                if left != right:
                    length_of_substring += 2
                    substring = s[left] + substring + s[right]
                if length_of_substring >= max:
                    max = length_of_substring
                    max_substring = substring
                left, right = left-1, right+1
            
        return max_substring

class Test:
    print("Test for the second approach of longest Palindrome")
    print("__________________________________________________")
    print("s = 'babad', output = {}".format(Solution.longestPalindrome2('babad')))
    print()
    print("s = 'cbbd', output = {}".format(Solution.longestPalindrome2('cbbd')))
    print()

Test()