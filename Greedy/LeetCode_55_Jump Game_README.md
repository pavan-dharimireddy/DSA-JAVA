# 55. Jump Game

## Problem Statement

You are given an integer array `nums`. You are initially positioned at the array's **first index**, and each element in the array represents your maximum jump length at that position.

Return `true` if you can reach the last index, or `false` otherwise.

## Examples

### Example 1
**Input:** `nums = [2,3,1,1,4]`  
**Output:** `true`  
**Explanation:** Jump 1 step from index 0 to 1, then 3 steps to the last index.

### Example 2
**Input:** `nums = [3,2,1,0,4]`  
**Output:** `false`  
**Explanation:** You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

## Constraints

- `1 <= nums.length <= 10^4`
- `0 <= nums[i] <= 10^5`

## Approach: Greedy Algorithm

The problem asks if we can reach the end of the array. Instead of simulating all possible jumps, we can use a Greedy approach to efficiently keep track of the maximum reachable index at any point.

1. Initialize a variable `maxIndex` to 0. This variable stores the furthest index we can currently reach.
2. Iterate through the array using an index `i`.
3. At each step, check if the current index `i` is greater than `maxIndex`. If `i > maxIndex`, it means the current index is unreachable from any of the previous indices. In this case, our progress is completely halted, and we return `false`.
4. If the current index is reachable, we update `maxIndex` by taking the maximum of its current value and the furthest index we can reach from the current position (`i + nums[i]`).
5. If the loop completes without ever encountering an unreachable index, it means we can reach (or even jump past) the last index, so we return `true`.

## Complexity Analysis

- **Time Complexity:** `O(N)` — We iterate through the array of size `N` exactly once.
- **Space Complexity:** `O(1)` — We only use a single integer variable (`maxIndex`), which requires constant extra space.

## Solution (Java)

```java
class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }
}
```