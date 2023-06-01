'''
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
'''
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        nmap = {}
        res = []
        arr = []

        # We first use a hashmap to count the occurences of each number in nums and add it to the hashmap
        for num in nums: nmap[num] = nmap.get(num, 0) + 1

        '''
        I'm using bucket sort for this which uses and array of the form below.
        Take for example nums = [1,1,1,2,2,3]
        
        no of occurences | 0  | 1   | 2   | 3   | 4  | 5  | 6  |
        value            | [] | [3] | [2] | [1] | [] | [] | [] |

        arr = [[], [], [], [], [], [], []]
        
        We first add everything to the array arr from hashmap.

        Then we read arr from the last index and add to our result res iterating only k times where count is
        incremented only when an element is added to res.
        '''

        for count in range(len(nums)+1): arr.append([])

        for num, freq in nmap.items(): arr[freq].append(num)

        count = len(arr)-1
        while len(res) < k and count >= 0:
            if len(arr[count]) > 0:
                value = arr[count].pop()
                res.append(value)
            else:
                count -= 1
        return res
    