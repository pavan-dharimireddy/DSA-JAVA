# 33. Search in Rotated Sorted Array

## Problem Statement

There is an integer array `nums` sorted in ascending order (with **distinct** values).

Prior to being passed to your function, `nums` is possibly rotated at an unknown pivot index `k` (`1 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (0-indexed).

For example, `[0,1,2,4,5,6,7]` might be rotated at pivot index `3` and become `[4,5,6,7,0,1,2]`.

Given the array `nums` after the possible rotation and an integer `target`, return the index of `target` if it is in `nums`, or `-1` if it is not in `nums`.

You must write an algorithm with `O(log n)` runtime complexity.

## Examples

### Example 1

**Input:** `nums = [4,5,6,7,0,1,2]`, `target = 0`  
**Output:** `4`

### Example 2

**Input:** `nums = [4,5,6,7,0,1,2]`, `target = 3`  
**Output:** `-1`

### Example 3

**Input:** `nums = [1]`, `target = 0`  
**Output:** `-1`

## Constraints

- `1 <= nums.length <= 5000`
- `-10^4 <= nums[i] <= 10^4`
- All values of `nums` are **unique**.
- `nums` is an ascending array that is possibly rotated.
- `-10^4 <= target <= 10^4`

## Approaches

### Approach 1: Linear Search (Brute Force)

A straightforward approach is to iterate through the array and check every element until the target is found.

- **Time Complexity:** `O(N)` — Linear search iterates over all elements in the worst case.
- **Space Complexity:** `O(1)` — Only constant extra space is used.

### Approach 2: Binary Search (Optimal)

Since the problem requires an `O(log n)` runtime complexity, we must use Binary Search. Even though the array is rotated, a key property remains true: **at any midpoint, at least one half of the array will always be perfectly sorted.**

1. Calculate `mid = (low + high) / 2`.
2. Check if `nums[mid] == target`. If so, return `mid`.
3. **Identify the sorted half:**
   - **Left Half is sorted (`nums[low] <= nums[mid]`):**
     - Check if the `target` falls within the range of this sorted left half (`target >= nums[low] && target < nums[mid]`).
     - If it does, narrow the search space to the left half (`high = mid - 1`).
     - Otherwise, the target must be in the right half (`low = mid + 1`).
   - **Right Half is sorted (implicitly, when left is not):**
     - Check if the `target` falls within the range of this sorted right half (`target > nums[mid] && target <= nums[high]`).
     - If it does, narrow the search space to the right half (`low = mid + 1`).
     - Otherwise, the target must be in the left half (`high = mid - 1`).

> **Important Edge Case (`nums = [3, 1], target = 1`):**  
> Pay special attention to the condition `nums[low] <= nums[mid]`. The `=` sign is critical. When the search space shrinks to 2 elements, `mid` will evaluate to `low`. If we used `<` instead of `<=`, the code would falsely assume the left half is unsorted (`3 < 3` is false), incorrectly jump to the right-half logic, and fail to find the target.

## Optimal Solution (Java)

```java
public class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            // Check if the left half is strictly sorted
            else if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
```
