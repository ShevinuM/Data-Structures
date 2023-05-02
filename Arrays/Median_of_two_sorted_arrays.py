def findMedianSortedArrays(nums1, nums2):
    # assign the two arrays to A and B respectively
    A, B = nums1, nums2

    # use a conditional statement to make sure that A is the array with least elements. If it's not switch A and B
    if len(B) < len(A):
            A, B = B, A

    # find the length of the first and the second array

    # find the half value of the sum of the lengths of first and second arrays. len() is O(1)
    half = (len(A) + len(B)) // 2

    # use a left and right pointer to A
    left = 0
    right = len(A) - 1

    while True:
        # calculate the partition of A using (left + right)/2. Partition of B = half - partition of A
        partitionA = (left + right) // 2
        partitionB = half - partitionA - 2

        # the right most element of the left partition of A and B are assigned to maxLeftPartitionA and maxLeftPartitionB
        maxLeftPartitionA = A[partitionA] if partitionA >= 0 else float("-infinity")
        maxLeftPartitionB = B[partitionB] if partitionB >= 0 else float("-infinity")

        # the left most element of the right partition of A and B are assigned to minRightPartitionA and minRightPartitionB
        minRightPartitionA = A[partitionA+1] if (partitionA+1) < len(A) else float("infinity")
        minRightPartitionB = B[partitionB+1] if (partitionB+1) < len(B) else float("infinity")

        # we check if maxLeftPartitionA <= minRightPartitionB and maxLeftPartitionB <= minRightPartitionA
        if maxLeftPartitionA <= minRightPartitionB and maxLeftPartitionB <= minRightPartitionA:
            # if the above statement holds, we check if the length of the combined array is odd or even
            if (len(A)+len(B))%2 == 0: #is even
                # if the lenght of the combined array is even,
                # then, median = (min(minRightPartitionA, minRightPartitionB)+max(maxLeftPartitionA, maxLeftPartitionB))/2
                return (min(minRightPartitionA, minRightPartitionB)+max(maxLeftPartitionA, maxLeftPartitionB))/2
            else: # is odd
                # if the length of the combined array is odd,
                # then, median = min(minRightPartitionA, minRightPartitionB)
                return min(minRightPartitionA, minRightPartitionB)
        # Binary search algorithm
        elif maxLeftPartitionA > minRightPartitionB:
            right = partitionA - 1
        else:
            left = partitionA + 1


def Test():
    print("Test for Median of Two Sorted Arrays")
    print("____________________________________")
    print("Case 1: nums1 = [1,3], nums2 = [2], expected median = 2, actual median = {}".format(findMedianSortedArrays([1,3],[2])))
    print()
    print("Case 2: nums1 = [1,2], nums2 = [3,4], expected median = 2.5, actual median = {}".format(findMedianSortedArrays([1,2],[3,4])))
    print()

Test()



