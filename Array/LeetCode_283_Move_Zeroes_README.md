# 283. Move Zeroes

## Problem Statement

Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

**Note:** You must do this in-place without making a copy of the array.

LeetCode Link

## Examples

### Example 1

**Input:** `nums = [0,1,0,3,12]`  
**Output:** `[1,3,12,0,0]`

### Example 2

**Input:** `nums = [0]`  
**Output:** `[0]`

## Constraints

- `1 <= nums.length <= 10^4`
- `-2^31 <= nums[i] <= 2^31 - 1`

## Approaches

### Approach 1: Using Extra Array (Brute Force)

We can use a temporary array to store the non-zero elements and then copy them back to the original array.

1.  Create a new array `arr` of the same size.
2.  Iterate through `nums`. If an element is non-zero, add it to `arr`.
3.  Copy elements from `arr` back to `nums`. The remaining positions in `nums` will naturally be filled with zeros (or remain zero if initialized that way).

**Complexity:**

- **Time Complexity:** O(N) - We iterate through the array twice.
- **Space Complexity:** O(N) - To store the temporary array.

### Approach 2: Two Pointers (Optimal)

This approach performs the operation in-place using two pointers to swap non-zero elements into their correct positions.

1.  **Find the first zero:** Iterate to find the index `j` of the first `0`. If no zero is found, the array is already processed.
2.  **Swap and Move:** Iterate with a pointer `i` starting from `j + 1`.
3.  If `nums[i]` is non-zero:
    - Swap `nums[i]` with `nums[j]`.
    - Increment `j` (move the zero pointer forward).

**Complexity:**

- **Time Complexity:** O(N) - We iterate through the array once.
- **Space Complexity:** O(1) - In-place modification.

## Solution (Java)

```java
class Solution {
    public void moveZeroes(int[] nums) {
    
        /* Approach 1: Brute Force (Using Extra Space)
        int n = nums.length;
        int[] arr = new int[n];
        int j = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                arr[j] = nums[i];
                j++;
            }
        }
        for(int i = 0; i < n; i++){        
            nums[i] = arr[i];             
        }
        */
        
        // Approach 2: Two Pointers (Optimal)
        int j = -1;
        int n = nums.length;
        
        // 1. Find the first zero
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // If no zero is found, return
        if (j == -1) return;

        // 2. Move pointers i and j and swap
        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                // Swap nums[i] and nums[j]
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }
}
```
