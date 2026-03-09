# 485. Max Consecutive Ones

## Problem Statement

Given a binary array `nums`, return the maximum number of consecutive `1`'s in the array.

LeetCode Link

## Examples

### Example 1

**Input:** `nums = [1,1,0,1,1,1]`  
**Output:** `3`  
**Explanation:** The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

### Example 2

**Input:** `nums = [1,0,1,1,0,1]`  
**Output:** `2`

## Constraints

- `1 <= nums.length <= 10^5`
- `nums[i]` is either `0` or `1`.

## Approaches

### Approach 1: Single Pass

Iterate through the array maintaining a count of consecutive ones.

1.  Initialize `max_count` to 0.
2.  Iterate through each element `x` in `nums`.
3.  If `x` is `1`, increment the current `count`.
4.  If `x` is `0`, update `max_count` with the maximum of `max_count` and `count`, then reset `count` to 0.
5.  After the loop, perform a final check to update `max_count` (to handle cases where the array ends with 1s).

**Complexity:**

- **Time Complexity:** O(N) - Single pass through the array.
- **Space Complexity:** O(1) - No extra space used.

## Solution (Java)

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_count = 0;
        int count = 0;
        for(int x : nums){
            if(x == 1){
                count++;
            }
            else{
                max_count = Math.max(max_count, count);
                count = 0;
            }
        }
        max_count = Math.max(max_count, count);

        return max_count;
    }
}
```
