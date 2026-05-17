# 4. Median of Two Sorted Arrays

## Problem Statement

Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return the median of the two sorted arrays.

The overall run time complexity should be `O(log (m+n))`.

## Examples

### Example 1

**Input:** `nums1 = [1,3]`, `nums2 = [2]`  
**Output:** `2.00000`  
**Explanation:** merged array = [1,2,3] and median is 2.

### Example 2

**Input:** `nums1 = [1,2]`, `nums2 = [3,4]`  
**Output:** `2.50000`  
**Explanation:** merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

## Constraints

- `nums1.length == m`
- `nums2.length == n`
- `0 <= m <= 1000`
- `0 <= n <= 1000`
- `1 <= m + n <= 2000`
- `-10^6 <= nums1[i], nums2[i] <= 10^6`

## Approaches

### Approach 1: Brute Force (Merge Arrays)

Create a new array of size `m + n`. Use two pointers to iterate through `nums1` and `nums2`, comparing elements and adding the smaller one to the new array. Once merged, find the median based on whether the total length is even or odd.

- **Time Complexity:** `O(m + n)` — We iterate through both arrays entirely.
- **Space Complexity:** `O(m + n)` — We use an extra array to store the merged elements.

### Approach 2: Two Pointers (Space Optimized)

Instead of creating a new merged array, we only need to traverse up to the median index `(m + n) / 2`. By maintaining two variables (`prev` and `curr`), we can track the elements at the median positions during our traversal.

- **Time Complexity:** `O(m + n)` — We still iterate up to half of the total elements.
- **Space Complexity:** `O(1)` — We only use a few variables, eliminating the extra array.

### Approach 3: Binary Search (Optimal)

To achieve logarithmic time complexity, we apply **Binary Search** on the smaller of the two arrays.

- We try to partition both arrays into two halves: a left half and a right half.
- The goal is to ensure that the left half contains the same number of elements as the right half (or one extra if the total is odd) and that every element on the left is less than or equal to every element on the right.
- We maintain `low` and `high` pointers for the smaller array and calculate `cut1` (partition in `nums1`) and `cut2` (partition in `nums2`).
- If the condition `l1 <= r2 && l2 <= r1` is met, we have found the correct partition.

> **Note: Why binary search on the smaller array?**  
> The complexity is bounded by the search space. Picking the smaller array guarantees `O(log(min(m, n)))` instead of `O(log(max(m, n)))`. It also avoids index out of bounds errors when computing partitions.

## Complexity Analysis (Optimal)

- **Time Complexity:** `O(log(min(m, n)))` — We are halving the search space of the smaller array in each step.
- **Space Complexity:** `O(1)` — Constant extra space is used for variables.

## Solution (Java)

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Step 1: Always binary search on smaller array to minimize search space
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length;
        int n = nums2.length;

        int low = 0, high = m;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int r1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            // Correct partition found
            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) { // Move left
                high = cut1 - 1;
            } else { // Move right
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
}
```
