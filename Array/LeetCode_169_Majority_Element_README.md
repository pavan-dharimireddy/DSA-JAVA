# 169. Majority Element

## Problem Statement

Given an array `nums` of size `n`, return the majority element.

The majority element is the element that appears more than `⌊n / 2⌋` times. You may assume that the majority element always exists in the array.

LeetCode Link

## Examples

### Example 1
**Input:** `nums = [3,2,3]`  
**Output:** `3`

### Example 2
**Input:** `nums = [2,2,1,1,1,2,2]`  
**Output:** `2`

## Constraints

- `n == nums.length`
- `1 <= n <= 5 * 10^4`
- `-10^9 <= nums[i] <= 10^9`

## Approaches

### Approach 1: Brute Force
Iterate through the array and count the occurrences of each element using a nested loop. If an element's count exceeds `n / 2`, return it.
- **Time Complexity:** O(N^2)
- **Space Complexity:** O(1)

### Approach 2: Sorting
Sort the array. The majority element will always be present at index `n / 2` because it appears more than `n / 2` times. You can also iterate and count after sorting.
- **Time Complexity:** O(N log N)
- **Space Complexity:** O(1) or O(log N) depending on the sorting algorithm.

### Approach 3: Hashing
Use a `HashMap` to store the frequency of each element. Iterate through the map to find the element with a frequency greater than `n / 2`.
- **Time Complexity:** O(N)
- **Space Complexity:** O(N)

### Approach 4: Moore's Voting Algorithm (Optimal)
This algorithm maintains a `candidate` element and a `count`. When traversing the array, if the `count` is `0`, we assign the current element as the `candidate`. If the current element matches the `candidate`, we increment the `count`; otherwise, we decrement it. The final `candidate` will be the majority element.

- **Time Complexity:** O(N) — One pass.
- **Space Complexity:** O(1) — Constant extra space.

## Solution (Java)

```java
class Solution {
    public int majorityElement(int[] nums) {
        
        // Approach 4: Moore's Voting Algorithm (Optimal)
        int n = nums.length;
        int count = 0;
        int element = nums[0];
        
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                element = nums[i];
                count = 1;
            } else if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        
        // The problem guarantees a majority element always exists,
        // so we don't need a second pass for verification.
        return element;
    }
}
```
