# 1539. Kth Missing Positive Number

## Problem Statement

Given an array `arr` of positive integers sorted in a **strictly increasing order**, and an integer `k`.

Return the `k`th positive integer that is missing from this array.

LeetCode Link

## Examples

### Example 1

**Input:** `arr = [2,3,4,7,11], k = 5`  
**Output:** `9`  
**Explanation:** The missing positive integers are `[1, 5, 6, 8, 9, 10, 12, 13, ...]`. The 5th missing positive integer is 9.

### Example 2

**Input:** `arr = [1,2,3,4], k = 2`  
**Output:** `6`  
**Explanation:** The missing positive integers are `[5, 6, 7, ...]`. The 2nd missing positive integer is 6.

## Constraints

- `1 <= arr.length <= 1000`
- `1 <= arr[i] <= 1000`
- `1 <= k <= 1000`
- `arr[i] < arr[j]` for `1 <= i < j <= arr.length`

## Approaches

### Approach 1: Brute Force (Simulation)

We can simulate the process of checking every positive integer starting from 1.

1.  Use a pointer `current` to track the position in the array `arr`.
2.  Use a variable `i` to represent the current positive integer being checked.
3.  Iterate while `k > 0`:
    - If `i` matches `arr[current]`, it is present in the array. Move the `current` pointer and increment `i`.
    - If `i` does not match `arr[current]` (or we reached the end of the array), it is missing. Decrement `k` and increment `i`.
4.  Return `i - 1` (since `i` is incremented one last time after finding the kth missing).

**Complexity:**

- **Time Complexity:** O(N + K) - In the worst case, we iterate through the array and up to the kth missing number.
- **Space Complexity:** O(1).

### Approach 2: Brute Force (Shift K)

We can determine the kth missing number by iterating through the array.

1.  Iterate through each number `x` in `arr`.
2.  If `x <= k`, it means `x` occupies one of the spots among the first `k` integers. Thus, the kth missing number must be shifted to the right by 1 (`k++`).
3.  If `x > k`, then the kth missing number is smaller than `x` and we have found the answer (which is the current value of `k`).

**Complexity:**

- **Time Complexity:** O(N).
- **Space Complexity:** O(1).

### Approach 3: Binary Search (Optimal)

We can use binary search to find the position where the kth missing number lies.

1.  For any index `i`, the number of missing positive integers before `arr[i]` is given by `arr[i] - (i + 1)`.
2.  Perform Binary Search:
    - If `missing < k`, it means the kth missing number is to the right of `mid`. Move `low = mid + 1`.
    - Otherwise, it is to the left. Move `high = mid - 1`.
3.  The result is `low + k` (derived from `arr[high] + k - (arr[high] - (high + 1))`).

**Complexity:**

- **Time Complexity:** O(log N).
- **Space Complexity:** O(1).

## Solution (Java)

```java
class Solution {
    public int findKthPositive(int[] arr, int k) {
        /* Approach 1: Brute Force (Simulation)
        int current = 0; // pointer into the sorted array 'arr'
        int i = 1;       // current positive integer we are checking (starts from 1)

        // We will keep moving forward until we've found k missing positive numbers
        while (k > 0) {
            // If 'i' exists in the array at position 'current'
            if (current < arr.length && arr[current] == i) {
                // 'i' is not missing — advance both pointers
                current++;
                i++;
            } else {
                // 'i' is missing (either we've exhausted the array or arr[current] != i)
                // Count this as one missing number
                i++;
                k--;
            }
        }
        // We incremented 'i' one extra time after counting the k-th missing number,
        // so the k-th missing number is 'i - 1'
        return i - 1;
        */

        /* Approach 2: Brute Force (Shift K)
        for (int x : arr) {
            if (x <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
        */

        // Approach 3: Binary Search (Optimal)
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (high + low) / 2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return high + 1 + k;
    }
}
```
