# 704. Binary Search

## Problem Statement

Given an array of integers `nums` which is sorted in ascending order, and an integer `target`, write a function to search `target` in `nums`. If `target` exists, then return its index. Otherwise, return `-1`.

You must write an algorithm with `O(log n)` runtime complexity.

## Examples

### Example 1
**Input:** `nums = [-1,0,3,5,9,12]`, `target = 9`  
**Output:** `4`  
**Explanation:** 9 exists in `nums` and its index is 4.

### Example 2
**Input:** `nums = [-1,0,3,5,9,12]`, `target = 2`  
**Output:** `-1`  
**Explanation:** 2 does not exist in `nums` so return -1.

## Constraints

- `1 <= nums.length <= 10^4`
- `-10^4 < nums[i], target < 10^4`
- All the integers in `nums` are **unique**.
- `nums` is sorted in ascending order.

## Approaches

### Approach 1: Iterative Binary Search (Loop)
We maintain two pointers, `start` and `end`, representing the bounds of our search space. In each step, we find the middle index `index` and compare `nums[index]` with our `target`.
- If `nums[index] == target`, we found the element and return `index`.
- If `nums[index] < target`, the target must lie to the right, so we update `start = index + 1`.
- If `nums[index] > target`, the target must lie to the left, so we update `end = index - 1`.
- **Time Complexity:** `O(log N)` — The search space is halved in every iteration.
- **Space Complexity:** `O(1)` — We only use a few integer variables.

### Approach 2: Recursive Binary Search
This follows the same logic as the iterative approach but uses recursion to traverse the array halves. We pass `start` and `end` bounds into our recursive calls.
- The base case to stop recursion is when `start > end`, returning `-1` (target not found).
- Otherwise, we check the middle element and recursively call the function on either the left or right half.
- **Time Complexity:** `O(log N)` — The array is continuously halved.
- **Space Complexity:** `O(log N)` — Memory is consumed on the call stack due to recursive calls.

> **Note on Calculating Mid-Index:**  
> In the current implementation, the middle index is calculated using `(start + end) / 2`. While this works for typical arrays, if `start` and `end` are very large integers, adding them together could exceed the maximum value of a 32-bit signed integer, causing an overflow. 
> A safer alternative is to use: `int index = start + (end - start) / 2;`

## Solution (Java)

```java
/*
// Iterative Approach
*/
class Solution {
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            // Safe alternative to avoid overflow: start + (end - start) / 2;
            int index = (start+end)/2; 
            if(nums[index] == target){
                return index;
            }
            else if(nums[index]<target){
                start = index+1;
            }
            else{
                end = index-1;
            }
        }
        return -1;
    }
}

/*
// Recursive Approach
class Solution {
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        return binarySearch(start,end,nums,target);
    }

    public int binarySearch(int start,int end, int nums[], int target){
        if(start>end){
            return -1;
        }
        else{
            int index = (start+end)/2;
            if(nums[index] == target){
                return index;
            }
            else if(nums[index]<target){
                return binarySearch(index+1,end,nums,target);
            }
            else{
                return binarySearch(start,index-1,nums,target);
            }
        }
    }
}
*/
```
