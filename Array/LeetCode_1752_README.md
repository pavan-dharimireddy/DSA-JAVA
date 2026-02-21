# 1752. Check if Array Is Sorted and Rotated

## Problem Statement

Given an array `nums`, return `true` if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return `false`.

There may be duplicates in the original array.

**Note:** An array `A` rotated by `x` positions results in an array `B` of the same length such that `A[i] == B[(i+x) % A.length]`.

LeetCode Link

## Examples

### Example 1

**Input:** `nums = [3,4,5,1,2]`  
**Output:** `true`  
**Explanation:** `[1,2,3,4,5]` is the original sorted array.  
You can rotate the array by x = 3 positions to begin on the the element of value 3: `[3,4,5,1,2]`.

### Example 2

**Input:** `nums = [2,1,3,4]`  
**Output:** `false`  
**Explanation:** There is no sorted array once rotated that can make nums.

### Example 3

**Input:** `nums = [1,2,3]`  
**Output:** `true`  
**Explanation:** Original array is `[1,2,3]`. The array is rotated by x = 0 positions.

## Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 100`

## Approaches

### Approach 1: Find Pivot and Reverse (Un-rotate)

This approach attempts to restore the array to its original sorted state by reversing specific segments.

1.  **Find Pivot:** Iterate through the array to find the index `i` where `nums[i] > nums[i+1]`. This index represents the pivot point of rotation.
2.  **Check if Sorted:** If no such pivot is found, the array is already sorted, return `true`.
3.  **Un-rotate:**
    - Reverse the first part: `0` to `pivot`.
    - Reverse the second part: `pivot + 1` to `length - 1`.
    - Reverse the entire array: `0` to `length - 1`.
4.  **Verify:** Check if the modified array is sorted in non-decreasing order.

**Complexity:**

- **Time Complexity:** O(N) (Finding pivot + Reversing + Checking sorted).
- **Space Complexity:** O(1) (In-place modification).

### Approach 2: Check Sorted Window in Circular Array

This approach checks if there is a continuous sequence of `N` sorted elements by treating the array as circular (or concatenated with itself).

1.  Iterate from `i = 1` up to `2 * n`.
2.  Compare current element `nums[i % n]` with previous element `nums[(i - 1) % n]`.
3.  If `nums[(i - 1) % n] <= nums[i % n]`, increment a counter.
4.  If the order breaks, reset the counter to 1.
5.  If the counter reaches `n`, it means the array (in some rotation) is fully sorted.

**Complexity:**

- **Time Complexity:** O(N) (Loop runs up to 2N times).
- **Space Complexity:** O(1).

## Solution (Java)

```java
class Solution {
    public boolean check(int[] nums) {

        /* Approach 1: Find Pivot and Reverse
        int pivot = -1;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot == -1){
            return true;
        }
        reverse(nums, 0, pivot);
        reverse(nums, pivot+1, nums.length-1);
        reverse(nums, 0, nums.length-1);

        for(int j=0; j<nums.length-1; j++){
            if(nums[j] > nums[j+1]){
                return false;
            }
        }
        return true;
        */

        // Approach 2: Check Sorted Window (Circular Check)
        int n = nums.length;
        int count = 1;

        // Iterate up to 2*n to simulate circular array
        for(int i = 1; i < 2 * n; i++){
            if(nums[(i - 1) % n] <= nums[i % n]){
                count++;
            } else {
                count = 1;
            }
            if(count == n){
                return true;
            }
        }

        return n == 1;
    }

    /* Helper for Approach 1
    public void reverse(int[] nums, int start, int end){
        int temp = 0;
        while(start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    */
}
```
