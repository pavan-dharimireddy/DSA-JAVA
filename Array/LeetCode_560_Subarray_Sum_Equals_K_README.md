# 560. Subarray Sum Equals K

## Problem Statement

Given an array of integers `nums` and an integer `k`, return the total number of continuous subarrays whose sum equals to `k`.

## Approaches

### Approach 1: Brute Force

Iterate through the array to find all possible subarrays. Use two nested loops: the outer loop sets the starting point of the subarray, and the inner loop extends it while keeping a running sum. If the running sum matches `k`, increment the total count.

- **Time Complexity:** O(N²) — Due to the nested loops exploring all contiguous subarrays.
- **Space Complexity:** O(1) — No extra space is required.

### Approach 2: Prefix Sum with HashMap (Optimal)

Use a `HashMap` to store the frequencies of all prefix sums encountered. While iterating through the array, maintain a running `sum`. If `sum - k` exists in the hash map, it indicates that there is a contiguous subarray ending at the current index which sums exactly to `k`. Add the frequency of `sum - k` to the total count, and update the hash map with the current prefix `sum`.

- **Time Complexity:** O(N) average case / O(N log N) depending on internal HashMap operations — Each element is visited once and HashMap lookups/insertions are mostly O(1) on average.
- **Space Complexity:** O(N) — Extra space is utilized to store the prefix sum frequencies in the hash map.

## Solution (Java)

```java
import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int sum = 0;

        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(0, 1); // Base case to account for single elements that equal to 'k'

        for(int i = 0; i < n; i++) {
            sum += nums[i];

            count = count + m.getOrDefault(sum - k, 0);
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
```
