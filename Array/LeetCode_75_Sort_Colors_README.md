# 75. Sort Colors

## Problem Statement

Given an array `nums` with `n` objects colored red, white, or blue, sort them **in-place** so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

LeetCode Link

## Examples

### Example 1
**Input:** `nums = [2,0,2,1,1,0]`  
**Output:** `[0,0,1,1,2,2]`

### Example 2
**Input:** `nums = [2,0,1]`  
**Output:** `[0,1,2]`

## Constraints

- `n == nums.length`
- `1 <= n <= 300`
- `nums[i]` is either `0`, `1`, or `2`.

## Approaches

### Approach 1: Sorting

A simple solution is to use the built-in sorting function.

- **Time Complexity:** O(N log N)
- **Space Complexity:** O(log N) or O(1) depending on implementation.

### Approach 2: Counting Sort (Two-Pass)

Iterate through the array to count the number of 0s, 1s, and 2s. Then, overwrite the array based on the counts.

- **Time Complexity:** O(N) — Two passes (one for counting, one for overwriting).
- **Space Complexity:** O(1) — Constant space for counters.

### Approach 3: Dutch National Flag Algorithm (One-Pass) — Optimal

This algorithm uses three pointers (`low`, `mid`, `high`) to partition the array into three sections:
1. `0`s: `[0, low - 1]`
2. `1`s: `[low, mid - 1]`
3. `2`s: `[high + 1, n - 1]`
4. Unknown: `[mid, high]`

- **Time Complexity:** O(N) — One pass.
- **Space Complexity:** O(1) — Constant extra space.

## Solution (Java)

```java
class Solution {
    public void sortColors(int[] nums) {
        
        /* Approach 2: Counting Sort (Two-Pass)
        int count0 = 0, count1 = 0, count2 = 0;
        for (int x : nums) {
            if (x == 0) count0++;
            else if (x == 1) count1++;
            else count2++;
        }
        int i = 0;
        while (count0-- > 0) nums[i++] = 0;
        while (count1-- > 0) nums[i++] = 1;
        while (count2-- > 0) nums[i++] = 2;
        */

        // Approach 3: Dutch National Flag Algorithm (One-Pass)
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
