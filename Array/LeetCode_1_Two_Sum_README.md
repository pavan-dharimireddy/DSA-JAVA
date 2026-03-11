# 1. Two Sum

## Problem Statement

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input would have **exactly one solution**, and you may not use the _same_ element twice.

You can return the answer in any order.

LeetCode Link

## Examples

### Example 1

**Input:** `nums = [2,7,11,15]`, `target = 9`  
**Output:** `[0,1]`  
**Explanation:** Because `nums[0] + nums[1] == 9`, we return `[0, 1]`.

### Example 2

**Input:** `nums = [3,2,4]`, `target = 6`  
**Output:** `[1,2]`

### Example 3

**Input:** `nums = [3,3]`, `target = 6`  
**Output:** `[0,1]`

## Constraints

- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`
- Only one valid answer exists.

## Approaches

### Approach 1: Brute Force

Iterate through each element `nums[i]` and check every other element `nums[j]` (where `j > i`) to see if their sum equals the target.

- **Time Complexity:** O(N²) — Nested loops check every pair.
- **Space Complexity:** O(1) — No extra space is used.

### Approach 2: HashMap (One-pass) — Optimal

We can solve this in linear time by using a HashMap to store values we have already seen and their indices.

As we iterate through the array:

1. Calculate the `complement` needed for the current number to reach the target (`target - nums[i]`).
2. Check if this `complement` exists in the HashMap.
3. If it exists, we found the pair! Return the index from the map and the current index.
4. If not, store the current number and its index in the HashMap.

- **Time Complexity:** O(N) — We traverse the list exactly once. HashMap lookups take O(1) on average.
- **Space Complexity:** O(N) — To store up to N elements in the HashMap.

## Solution (Java)

```java
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Approach: HashMap (One-pass)
        // Time Complexity: O(N)
        // Space Complexity: O(N)

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[]{}; // Should not happen per problem description
    }
}
```
