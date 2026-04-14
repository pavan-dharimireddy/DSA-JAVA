# 15. 3Sum

## Problem Statement

Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

**Notice** that the solution set must not contain duplicate triplets.

LeetCode Link

## Examples

### Example 1

**Input:** `nums = [-1,0,1,2,-1,-4]`  
**Output:** `[[-1,-1,2],[-1,0,1]]`  
**Explanation:**
`nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0`.
`nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0`.
`nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0`.
The distinct triplets are `[-1,0,1]` and `[-1,-1,2]`.
Notice that the order of the output and the order of the triplets does not matter.

### Example 2

**Input:** `nums = [0,1,1]`  
**Output:** `[]`  
**Explanation:** The only possible triplet does not sum up to 0.

### Example 3

**Input:** `nums = [0,0,0]`  
**Output:** `[[0,0,0]]`  
**Explanation:** The only possible triplet sums up to 0.

## Constraints

- `3 <= nums.length <= 3000`
- `-10^5 <= nums[i] <= 10^5`

## Approaches

### Approach 1: Brute Force

Use three nested loops to find all possible combinations of three numbers. To ensure uniqueness, we sort each valid triplet and store it in a `HashSet`. Finally, we convert the set back to a list.

- **Time Complexity:** `O(N^3)` — Three nested loops iterate over the array to find triplets. Sorting 3 elements and HashSet insertion takes `O(1)`.
- **Space Complexity:** `O(2 * no. of unique triplets)` — We are using a `Set` data structure and a `List` to store the unique triplets.

### Approach 2: Hashing

Instead of three loops, we can use two nested loops and a `HashSet` to look up the third element. For every pair `(nums[i], nums[j])`, we check if the required third element `-(nums[i] + nums[j])` exists in the set.

- **Time Complexity:** `O(N^2)` — Two nested loops iterate over the array.
- **Space Complexity:** `O(2 * no. of unique triplets) + O(N)` — Using a `Set` and a `List` to store the triplets, and an extra `O(N)` for storing elements in the HashSet between the inner and outer loops.

### Approach 3: Optimal (Sorting + Two Pointers)

1. Sort the given array.
2. Fix a pointer `i` iterating through the array. Skip `nums[i]` if it's the same as the previous element to avoid duplicate triplets.
3. Use two pointers, `left = i + 1` and `right = n - 1`.
4. Calculate the sum: `sum = nums[i] + nums[left] + nums[right]`.
5. If `sum < 0`, increment `left` to increase the sum.
6. If `sum > 0`, decrement `right` to decrease the sum.
7. If `sum == 0`, a valid triplet is found. Add it to the answer list, increment `left`, decrement `right`, and skip any neighboring duplicates to avoid redundant combinations.

- **Time Complexity:** `O(N log N) + O(N^2) = O(N^2)` — Sorting takes `O(N log N)`. The outer loop runs `N` times and the inner two-pointer mechanism traverses the remaining elements in `O(N)` time.
- **Space Complexity:** `O(1)` Auxiliary — We are not using any extra space beyond what is needed to store and return the final output (`O(no. of quadruplets/triplets)`).

## Solution (Java)

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // Skip duplicate elements for the first position
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicates for the second and third positions
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
```
