# 31. Next Permutation

## Problem Statement

A **permutation** of an array of integers is an arrangement of its members into a sequence or linear order.

The **next permutation** of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of `arr = [1,2,3]` is `[1,3,2]`.
Similarly, the next permutation of `arr = [2,3,1]` is `[3,1,2]`.
While the next permutation of `arr = [3,2,1]` is `[1,2,3]` because `[3,2,1]` does not have a lexicographical larger rearrangement.

Given an array of integers `nums`, find the next permutation of `nums`.

The replacement must be **in place** and use only constant extra memory.

LeetCode Link

## Examples

### Example 1

**Input:** `nums = [1,2,3]`  
**Output:** `[1,3,2]`

### Example 2

**Input:** `nums = [3,2,1]`  
**Output:** `[1,2,3]`

### Example 3

**Input:** `nums = [1,1,5]`  
**Output:** `[1,5,1]`

## Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 100`

## Approaches

### Approach 1: Brute Force

Generate all possible sorted permutations using recursion. Then, perform a linear search to find the given sequence in the list of permutations, and return the sequence that immediately follows it. If it is the last permutation, return the first one.

- **Time Complexity:** O(N! \* N) — Generating all permutations takes O(N!), and copying/comparing them takes O(N) time.
- **Space Complexity:** O(N! \* N) — To store all the permutations.
- _Note: This approach is highly inefficient and will result in a Time Limit Exceeded (TLE) error for larger arrays._

### Approach 2: Optimal (Single Pass)

We can find the next permutation directly by observing the properties of lexicographical order:

1.  **Find the `break_index`:** Traverse from right to left to find the first index `i` where `nums[i] < nums[i+1]`. This is the point where the permutation can be increased.
2.  **Edge Case (Descending Order):** If no such index exists (i.e., `break_index == -1`), it means the array is in perfectly descending order (the last permutation). We simply reverse the entire array to get the first permutation.
3.  **Find Next Greater Element:** If a `break_index` is found, traverse from right to left again to find the smallest element that is strictly greater than `nums[break_index]`. Swap these two elements.
4.  **Reverse the Right Half:** After swapping, the elements to the right of `break_index` will still be in descending order. Reverse them to make them sorted in ascending order, achieving the smallest lexicographically higher permutation.

- **Time Complexity:** O(N) — In the worst case, we do three passes over the array: one to find the break index, one to find the swap element, and one to reverse the remaining segment. O(N) + O(N) + O(N) = O(N).
- **Space Complexity:** O(1) — The operations are done in-place with no extra space.

## Solution (Java)

```java
class Solution {
    public void nextPermutation(int[] nums) {

        /*
        Approach 1: Brute force
        Time complexity: O(N! * N)
        Steps:
        1. Generate all Sorted permutations by using recursion
        2. Linear search the given permutation
        3. Return the next permutation to the given permutation
        */

        // Approach 2: Optimal
        // Time complexity: O(N) + O(N) + O(N) = O(3N) -> O(N)
        // Extra space complexity: O(1)

        // Example test case: [2,1,5,4,3,0,0]
        int n = nums.length;
        int break_index = -1;

        // Step 1: Finding the break_index
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                break_index = i;
                break;
            }
        }

        // Step 2: If array is purely descending, just reverse it
        if(break_index == -1){
            reverse_array(nums, 0, n - 1);
        } else {
            // Step 3: Finding the element from right which is just greater than break_index element and swapping both
            for(int i = n - 1; i > break_index; i--){
                if(nums[i] > nums[break_index]){
                    int temp = nums[i];
                    nums[i] = nums[break_index];
                    nums[break_index] = temp;
                    break;
                }
            }

            // Step 4: After swapping, reverse the array from break_index + 1 to n - 1
            reverse_array(nums, break_index + 1, n - 1);
        }
    }

    public void reverse_array(int[] arr, int start, int end){
        int temp = 0;
        while(start < end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
```
