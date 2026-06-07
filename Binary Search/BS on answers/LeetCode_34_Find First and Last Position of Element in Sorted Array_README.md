# 34. Find First and Last Position of Element in Sorted Array

## Problem Statement

Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value.

If `target` is not found in the array, return `[-1, -1]`.

You must write an algorithm with `O(log n)` runtime complexity.

## Examples

### Example 1

**Input:** `nums = [5,7,7,8,8,10]`, `target = 8`  
**Output:** `[3,4]`

### Example 2

**Input:** `nums = [5,7,7,8,8,10]`, `target = 6`  
**Output:** `[-1,-1]`

### Example 3

**Input:** `nums = []`, `target = 0`  
**Output:** `[-1,-1]`

## Constraints

- `0 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
- `nums` is a non-decreasing array.
- `-10^9 <= target <= 10^9`

## Approaches

### Approach 1: Linear Search (Brute Force)

Iterate through the array from start to finish. Record the index the first time the `target` is seen, and continuously update the last seen index as long as the `target` is encountered.

- **Time Complexity:** `O(N)` — We traverse the entire array in the worst case.
- **Space Complexity:** `O(1)` — Only a couple of variables are used.

### Approach 2: Lower Bound and Upper Bound

Use the concept of bounds to find the range.

- **Lower Bound:** Finds the first index where `nums[i] >= target`.
- **Upper Bound:** Finds the first index where `nums[i] > target`. The last occurrence of the target will be at `upperBound - 1`.
- **Time Complexity:** `O(log N)` — Requires two separate binary search traversals.
- **Space Complexity:** `O(1)`.

### Approach 3: Two Binary Searches (Optimal)

Instead of strict lower/upper bounds, we run two tailored binary searches:

1.  **First Occurrence:** Standard binary search, but when `nums[mid] == target`, we record the index and continue searching the left half (`high = mid - 1`) to find earlier occurrences.
2.  **Last Occurrence:** Standard binary search, but when `nums[mid] == target`, we record the index and continue searching the right half (`low = mid + 1`) to find later occurrences.

- **Time Complexity:** `O(log N)` — The algorithm performs two independent binary searches, each taking `O(log N)` time.
- **Space Complexity:** `O(1)` — Only constant auxiliary space is used for pointers (`low`, `high`, `mid`).

## Optimal Solution (Java)

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurance(nums, target);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int last = lastOccurance(nums, target);
        return new int[]{first, last};
    }

    public int firstOccurance(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int first_index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                first_index = mid;
                high = mid - 1; // shrink to left half
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return first_index;
    }

    public int lastOccurance(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int last_index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                last_index = mid;
                low = mid + 1; // shrink to right half
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return last_index;
    }
}
```
