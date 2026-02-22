# 26. Remove Duplicates from Sorted Array

## Problem Statement

Given an integer array `nums` sorted in **non-decreasing order**, remove the duplicates **in-place** such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in `nums`.

Consider the number of unique elements of `nums` to be `k`. To get accepted, you need to do the following things:

1. Change the array `nums` such that the first `k` elements of `nums` contain the unique elements in the order they were present in `nums` initially. The remaining elements of `nums` are not important as well as the size of `nums`.
2. Return `k`.

LeetCode Link

## Examples

### Example 1

**Input:** `nums = [1,1,2]`  
**Output:** `2, nums = [1,2,_]`  
**Explanation:** Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

### Example 2

**Input:** `nums = [0,0,1,1,1,2,2,3,3,4]`  
**Output:** `5, nums = [0,1,2,3,4,_,_,_,_,_]`  
**Explanation:** Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

## Constraints

- `1 <= nums.length <= 3 * 10^4`
- `-100 <= nums[i] <= 100`
- `nums` is sorted in **non-decreasing** order.

## Approaches

### Approach 1: Brute Force (Using TreeSet)

Use a `SortedSet` (specifically `TreeSet` in Java) to store unique elements. Since a Set automatically removes duplicates and a TreeSet keeps them sorted, we can simply add all elements to the set and then rewrite the `nums` array with elements from the set.

**Complexity:**

- **Time Complexity:** O(N log N) - Adding N elements to a TreeSet takes O(log N) per element.
- **Space Complexity:** O(N) - To store the unique elements in the set.

### Approach 2: Two Pointers (Optimal)

Since the array is already sorted, duplicate elements will always be adjacent. We can use two pointers, `i` and `j`.

- `i` (slow pointer): Tracks the position of the last unique element found.
- `j` (fast pointer): Iterates through the array to find new unique elements.

1. Initialize `i = 0`.
2. Iterate `j` from `1` to `nums.length - 1`.
3. If `nums[j]` is different from `nums[i]`, it means we found a new unique element.
   - Increment `i`.
   - Update `nums[i] = nums[j]`.
4. Return `i + 1` (since `i` is 0-indexed).

**Complexity:**

- **Time Complexity:** O(N) - Single pass through the array.
- **Space Complexity:** O(1) - In-place modification.

## Solution (Java)

```java
import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {

        /*
        // Approach 1: Brute Force using TreeSet
        // https://www.youtube.com/watch?v=Vzs_vlCIFEw

        // Time Complexity: O(N log N)
        // Space Complexity: O(N)

        SortedSet<Integer> s = new TreeSet<>();
        for(int x : nums){
            s.add(x);
        }

        int i=0;
        while(!s.isEmpty()){
            nums[i] = s.first();
            i++;
            s.remove(s.first());
        }
        return i;
        */

        // Approach 2: Two Pointers (Optimal)
        // https://youtu.be/37E9ckMDdTk?si=legLzhHDwjKi7NXO
        // Time Complexity: O(N)
        // Space Complexity: O(1)

        int n = nums.length;
        int i = 0; // Pointer for the position of unique elements

        // j is the scanner pointer
        for (int j = 1; j < n; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
```
