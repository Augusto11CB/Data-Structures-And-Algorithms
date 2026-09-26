# 88. Merge Sorted Array

## Intuition
The main point is that both arrays are already sorted in non-decreasing order. Since we need to return the ``nums1`` array that contains the merge of `nums1` and `nums2`, I tried to come up with a solution that does not require a third array to contain the result of the merge of `nums1` and `nums2`. To do this, I came up with the idea of traversing both arrays from the end, comparing their largest number, and inserting at the end of the array numb1, which is filled with zeros. This allows us to avoid a third structure that could increase the space complexity of our solution.

## Complexity
- Time complexity: `O(m+n)`
    - `m` and `n` are the lengths of the input arrays `nums1` and `nums2`, respectively. This is because the algorithm iterates through each element of the two input arrays at most once.

- Space complexity: `O(1)`
    - It uses a constant amount of additional space regardless of the input size.