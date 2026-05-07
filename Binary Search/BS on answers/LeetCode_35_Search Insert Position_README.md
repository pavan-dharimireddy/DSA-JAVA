# 35. Search Insert Position

## Problem Statement

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with `O(log n)` runtime complexity.

## Examples

### Example 1
**Input:** `nums = [1,3,5,6]`, `target = 5`  
**Output:** `2`

### Example 2
**Input:** `nums = [1,3,5,6]`, `target = 2`  
**Output:** `1`

### Example 3
**Input:** `nums = [1,3,5,6]`, `target = 7`  
**Output:** `4`

## Approach: Binary Search (Lower Bound)

Since the array is sorted and we need an `O(log n)` solution, **Binary Search** is the optimal choice. 

The problem essentially asks us to find the **lower bound** of the target. The lower bound is the index of the first element in the array that is greater than or equal to the target. 

- We initialize two pointers: `start = 0` and `end = nums.length - 1`.
- We also keep an `insert_index` initialized to `nums.length` (this acts as our fallback if the target is greater than all elements in the array).
- In each step of the loop, we calculate `mid = start + (end - start) / 2`.
- If `nums[mid] >= target`, it means `mid` could potentially be our insertion index. We record `insert_index = mid` and discard the right half by updating `end = mid - 1` to see if there's a smaller valid index on the left.
- If `nums[mid] < target`, the insertion index must be strictly to the right, so we update `start = mid + 1`.

## Complexity Analysis

- **Time Complexity:** `O(log N)` — We are halving the search space in each iteration of the loop, which results in logarithmic time complexity.
- **Space Complexity:** `O(1)` — We are only using a few primitive integer variables (`start`, `end`, `mid`, `insert_index`) which consume constant extra space.

## Code Note: Avoiding Integer Overflow
When calculating the middle index, using `(start + end) / 2` can cause a signed integer overflow if both `start` and `end` are very large (their sum exceeds `2^31 - 1`). 
To prevent this, it's a best practice to calculate the middle index using:
`int mid = start + (end - start) / 2;`
