# 189. Rotate Array

## Problem Statement

Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

LeetCode Link

## Examples

### Example 1

**Input:** `nums = [1,2,3,4,5,6,7], k = 3`  
**Output:** `[5,6,7,1,2,3,4]`  
**Explanation:**  
rotate 1 steps to the right: `[7,1,2,3,4,5,6]`  
rotate 2 steps to the right: `[6,7,1,2,3,4,5]`  
rotate 3 steps to the right: `[5,6,7,1,2,3,4]`

### Example 2

**Input:** `nums = [-1,-100,3,99], k = 2`  
**Output:** `[3,99,-1,-100]`  
**Explanation:**  
rotate 1 steps to the right: `[99,-1,-100,3]`  
rotate 2 steps to the right: `[3,99,-1,-100]`

## Constraints

- `1 <= nums.length <= 10^5`
- `-2^31 <= nums[i] <= 2^31 - 1`
- `0 <= k <= 10^5`

## Approaches

### Approach 1: Using Extra Array

We can use a temporary array to store the elements that need to be moved to the front.

1.  Calculate effective rotation `k = k % n`.
2.  Create a temporary array of size `k` to store the last `k` elements of the original array.
3.  Shift the first `n - k` elements of the original array to the right by `k` positions.
4.  Copy the elements from the temporary array back to the beginning of the original array.

**Complexity:**

- **Time Complexity:** O(N) - We iterate through the array segments.
- **Space Complexity:** O(K) - To store the temporary array.

### Approach 2: Reverse Algorithm (Optimal)

This approach rotates the array in-place by reversing specific segments of the array.

1.  Calculate effective rotation `k = k % n`.
2.  **Reverse the last `k` elements:** This puts the elements that should be at the front in reverse order at the end.
3.  **Reverse the first `n - k` elements:** This reverses the remaining part of the array.
4.  **Reverse the entire array:** This flips the two reversed segments into their correct rotated positions.

**Complexity:**

- **Time Complexity:** O(N) - Each element is reversed twice.
- **Space Complexity:** O(1) - In-place modification.

## Solution (Java)

```java
class Solution {
    public void rotate(int[] nums, int k) {

        /*
        // Approach 1: Using Extra Array
        // Time Complexity: O(N)
        // Space Complexity: O(K)

        int n = nums.length;
        k = k % n;  // if k > n, avoid unwanted rotations
        int[] arr = new int[k];

        // Store the last k elements
        for(int i = 0; i < k; i++){
            arr[i] = nums[n - k + i];
        }

        // Shift the first n-k elements to the right
        for(int j = 0; j < n - k; j++){
             nums[n - 1 - j] = nums[n - k - 1 - j];
        }

        // Copy stored elements to the front
        for(int z = 0; z < k; z++){
            nums[z] = arr[z];
        }
        */

        // Approach 2: Reverse Algorithm (Optimal)
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int n = nums.length;
        k = k % n;  // if k > n, avoid unwanted rotations

        reverse(nums, n - k, n - 1);   // Reverse last k elements
        reverse(nums, 0, n - k - 1);   // Reverse first n-k elements
        reverse(nums, 0, n - 1);       // Reverse entire array
    }

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
}
```
