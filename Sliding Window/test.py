from longest_substring_without_repeating_characters import *

# Test - non sliding window approach
print("Test for O(n^2) time complexity algorithm")
print("_________________________________________")
print("The length of the substring 'abcabcbb' is -> " + str(lengthOfLongestSubstring("abcabcbb")))
print("The length of the substring 'bbbbb' is -> " + str(lengthOfLongestSubstring("bbbbb")))
print("The length of the substring 'pwwkew' is -> " + str(lengthOfLongestSubstring("pwwkew")))
print()

# Test for sliding window approach
print("Test for O(n) time-complexity sliding window approach")
print("_____________________________________________________")
print("The length of the substring 'abcabcbb' is -> " + str(lengthOfLongestSubstringSlidingWindow("abcabcbb")))
print("The length of the substring 'bbbbb' is -> " + str(lengthOfLongestSubstringSlidingWindow("bbbbb")))
print("The length of the substring 'pwwkew' is -> " + str(lengthOfLongestSubstringSlidingWindow("pwwkew")))
print()