# 128. Longest Consecutive Sequence

## Problem Statement

Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in `O(n)` time.

## Examples

### Example 1
**Input:** `nums = [100,4,200,1,3,2]`  
**Output:** `4`  
**Explanation:** The longest consecutive elements sequence is `[1, 2, 3, 4]`. Therefore its length is `4`.

### Example 2
**Input:** `nums = [0,3,7,2,5,8,4,6,0,1]`  
**Output:** `9`

## Constraints

- `0 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`

## Approaches

### Approach 1: Brute Force
For each element in the array, perform a linear search to find consecutive elements (`num + 1`, `num + 2`, etc.) and continuously track the maximum sequence length found.
- **Time Complexity:** > O(N²) — Due to nested while loops and repeated linear searches for every element.
- **Space Complexity:** O(1) — No extra space utilized.

### Approach 2: Sorting
Sort the array in ascending order. Iterate through the sorted array while keeping track of the consecutive count. If the current element is equal to the previous element plus one, increment the sequence count. Duplicate values are ignored, and if the streak breaks, reset the count.
- **Time Complexity:** O(N log N) — Dominated by the array sorting algorithm.
- **Space Complexity:** O(1) or O(log N) — Depending on the sorting algorithm implementation.

### Approach 3: HashSet (Optimal)
Insert all the elements of the array into a `HashSet` to enable O(1) average time complexity lookups. Iterate through the set, and for each number, check if it's the start of a sequence (i.e., `num - 1` does not exist in the set). If it is the start, continuously check for `num + 1`, `num + 2`, etc., and record the maximum length.
- **Time Complexity:** O(N) — Each element is inserted and checked at most twice (once added to the set, and once checked as part of a sequence iteration).
- **Space Complexity:** O(N) — Extra space needed to store the array elements in the `HashSet`.

## Solution (Java)

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        
        int longest_consecutive = 1;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        
        // Add all elements to the HashSet
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        for (int x : set) {
            // Check if it's the start of a new consecutive sequence
            if (!set.contains(x - 1)) {
                count = 1;
                while (set.contains(x + 1)) {
                    count++;
                    x = x + 1;
                }
                longest_consecutive = Math.max(longest_consecutive, count);
            }        
        }
        return longest_consecutive;
    }
}
```
