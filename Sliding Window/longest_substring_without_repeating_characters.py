# Time-Complexity - O(n^2). Non-sliding windows approach.
# This is my initial approach to this problem before I knew the sliding window method
def lengthOfLongestSubstring(s):
        """
        :type s: str
        :rtype: int
        """
        s_copy = s[:]
        temp_index = 0
        index = 0
        new_str = ""
        max_length = 0
        while index < len(s_copy):
            if temp_index < len(s_copy):
                character = s_copy[temp_index]
            if character not in new_str:
                new_str = new_str + character
                if len(new_str) > max_length:
                    max_length = len(new_str)
                temp_index += 1
            else:
                new_str = ""
                index+=1
                temp_index=index

        return max_length