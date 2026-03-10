# 136. Single Number

## Problem Statement

Given a **non-empty** array of integers `nums`, every element appears *twice* except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

LeetCode Link

## Examples

### Example 1
**Input:** `nums = [2,2,1]`  
**Output:** `1`

### Example 2
**Input:** `nums = [4,1,2,1,2]`  
**Output:** `4`

### Example 3
**Input:** `nums = [1]`  
**Output:** `1`

## Constraints

- `1 <= nums.length <= 3 * 10^4`
- `-3 * 10^4 <= nums[i] <= 3 * 10^4`
- Each element in the array appears twice except for one element which appears only once.

## Approaches

### Approach 1: Brute Force

Iterate through every element in the array and for each element, check if it appears again in the array.

- **Time Complexity:** O(N²)
- **Space Complexity:** O(1)

### Approach 2: HashMap

Use a HashMap to store the frequency of each element. After populating the map, iterate through it to find the element with a count of 1.

- **Time Complexity:** O(N) — We iterate through the array once to populate the map and once through the map keys.
- **Space Complexity:** O(N) — To store the elements in the map (specifically N/2 + 1 elements).

### Approach 3: Bit Manipulation (XOR) — Optimal

This approach uses the properties of the XOR (`^`) operation:
1. `a ^ a = 0` (XORing a number with itself results in 0)
2. `a ^ 0 = a` (XORing a number with 0 results in the number itself)
3. XOR is commutative and associative.

By XORing all elements in the array together, the duplicate elements will cancel each other out (resulting in 0), leaving only the single number.

- **Time Complexity:** O(N) — We iterate through the array exactly once.
- **Space Complexity:** O(1) — No extra data structures are used.

## Solution (Java)

```java
class Solution {
    public int singleNumber(int[] nums) {
        /* Approach 2: HashMap
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1; 
        */

        // Approach 3: XOR (Optimal)
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}
```
