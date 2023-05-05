# Write a function to find the longest common prefix string amongst an array of strings.
# If there is no common prefix, return an empty string "".

def longestCommonPrefix(strs: List[str]) -> str:
    len_strs = len(strs)
    index = 0
    return_str = ""
    while True:
        if index>=len(strs[0]):
            return return_str
        toCheck = strs[0][index]
        for count in range(len_strs):
            if index>=len(strs[count]) or strs[count][index] != toCheck:
                return return_str
        index+=1
        return_str += toCheck
