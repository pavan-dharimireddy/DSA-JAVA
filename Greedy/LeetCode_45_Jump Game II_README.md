# 45. Jump Game II

## Problem Statement

You are given a **0-indexed** array of integers `nums` of length `n`. You are initially positioned at `nums[0]`.

Each element `nums[i]` represents the maximum length of a forward jump from index `i`. In other words, if you are at `nums[i]`, you can jump to any `nums[i + j]` where:

- `0 <= j <= nums[i]`
- `i + j < n`

Return _the minimum number of jumps to reach `nums[n - 1]`_. The test cases are generated such that you can reach `nums[n - 1]`.

## Examples

### Example 1

**Input:** `nums = [2,3,1,1,4]`  
**Output:** `2`  
**Explanation:** The minimum number of jumps to reach the last index is `2`. Jump `1` step from index `0` to `1`, then `3` steps to the last index.

### Example 2

**Input:** `nums = [2,3,0,1,4]`  
**Output:** `2`

## Constraints

- `1 <= nums.length <= 10^4`
- `0 <= nums[i] <= 1000`
- It's guaranteed that you can reach `nums[n - 1]`.

## Approach: Greedy (Implicit BFS)

The problem can be visualized using an implicit Breadth-First Search (BFS) or window-based greedy approach. We divide the array into contiguous "levels" or "windows" representing the minimum number of jumps required to reach the elements inside them.

1. We use two pointers, `l` (left) and `r` (right), to define the current window of indices we can reach with our current number of `jumps`.
2. While `r` is less than the target index (`nums.length - 1`), we loop through all the elements in the current window `[l, r]`.
3. For each element `i` in the window, we determine the farthest we can reach and store it in `maxIndex` (`maxIndex = Math.max(maxIndex, i + nums[i])`).
4. After evaluating the entire current window, we transition to the next window:
   - The new left boundary `l` becomes `r + 1`.
   - The new right boundary `r` becomes `maxIndex`.
5. We increment the `jumps` counter to account for stepping into the new window.

## Complexity Analysis

- **Time Complexity:** `O(N)` — Although there is a nested `for` loop, the `l` and `r` pointers ensure that every element in the array is visited exactly once, resulting in linear time complexity.
- **Space Complexity:** `O(1)` — The algorithm modifies pointers and boundaries but uses only a constant amount of auxiliary extra space.

## Solution (Java)

```java
// T.C --- O(N) , S.C --- O(1)
class Solution {
    public int jump(int[] nums) {
        int jumps = 0, l = 0, r = 0;
        while (r < nums.length - 1) {
            int maxIndex = 0;
            for (int i = l; i <= r; i++) {
                maxIndex = Math.max(i + nums[i], maxIndex);
            }
            l = r + 1;
            r = maxIndex;
            jumps++;
        }
        return jumps;
    }
}
```
