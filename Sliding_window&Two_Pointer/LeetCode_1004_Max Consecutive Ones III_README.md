# 1004. Max Consecutive Ones III

## Problem Statement

Given a binary array `nums` and an integer `k`, return the maximum number of consecutive `1`'s in the array if you can flip at most `k` `0`'s.

## Examples

### Example 1

**Input:** `nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2`
**Output:** `6`
**Explanation:** The subarray `[0,0,1,1,1,1]` (from index 4 to 9) contains two zeros. By flipping them, we get a sequence of six 1s. This is the longest possible.

### Example 2

**Input:** `nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3`
**Output:** `10`
**Explanation:** The subarray `[1,1,0,0,1,1,1,0,1,1]` (from index 2 to 11) contains three zeros. By flipping them, we get a sequence of ten 1s.

## Constraints

- `1 <= nums.length <= 10^5`
- `nums[i]` is either `0` or `1`.
- `0 <= k <= nums.length`

## Approaches

### Approach 1: Brute Force

This approach checks every possible subarray. We use two nested loops: an outer loop `i` to fix the starting point and an inner loop `j` to fix the ending point. For each subarray `[i...j]`, we count the number of zeros. If the count is less than or equal to `k`, we update our maximum length.

- **Time Complexity:** `O(N^2)` — We check all subarrays, which takes quadratic time.
- **Space Complexity:** `O(1)` — No extra space is used besides a few variables.

### Approach 2: Sliding Window (Optimal)

A more efficient solution is to use the sliding window technique with two pointers, `l` (left) and `r` (right). The goal is to maintain a "window" `[l...r]` that contains at most `k` zeros.

1.  Initialize `l = 0`, `r = 0`, and `zeros_count = 0`.
2.  Expand the window by incrementing the right pointer `r`. If `nums[r]` is a `0`, increment `zeros_count`.
3.  If `zeros_count` becomes greater than `k`, our window is invalid. We must shrink it from the left by incrementing the left pointer `l`. If the element we are moving past (`nums[l]`) was a `0`, we decrement `zeros_count`.
4.  At each step, the current valid window size is `r - l + 1`. We continuously update our `max_len` with the largest window size seen so far.
5.  The process continues until `r` reaches the end of the array.

This ensures that each element is visited at most twice (once by `r` and once by `l`), leading to a linear time complexity.

- **Time Complexity:** `O(N)` — Both pointers `l` and `r` traverse the array at most once.
- **Space Complexity:** `O(1)` — We only use a few variables to keep track of the pointers and zero count.

## Solution (Java)

Here is a clean and correct implementation of the optimal sliding window approach.

```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int max_len = 0;
        int l = 0; // Left pointer of the window
        int zeros_count = 0; // Number of zeros in the current window

        // Expand the window with the right pointer 'r'
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                zeros_count++;
            }

            // If the number of zeros exceeds k, the window is invalid.
            // Shrink the window from the left until it's valid again.
            while (zeros_count > k) {
                if (nums[l] == 0) {
                    zeros_count--;
                }
                l++;
            }

            // The window [l, r] is now valid. Update the maximum length.
            max_len = Math.max(max_len, r - l + 1);
        }

        return max_len;
    }
}
```
