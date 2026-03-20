# 2149. Rearrange Array Elements by Sign

## Problem Statement

You are given a **0-indexed** integer array `nums` of **even** length consisting of an **equal** number of positive and negative integers.

You should rearrange the elements of `nums` such that the modified array follows the given conditions:

1.  Every **consecutive pair** of integers have **opposite signs**.
2.  For all integers with the same sign, the **order** in which they were present in `nums` is **preserved**.
3.  The rearranged array begins with a positive integer.

Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

LeetCode Link

## Examples

### Example 1
**Input:** `nums = [3,1,-2,-5,2,-4]`  
**Output:** `[3,-2,1,-5,2,-4]`  
**Explanation:** 
The positive integers in `nums` are [3, 1, 2].
The negative integers are [-2, -5, -4].
The only possible way to rearrange them such that they satisfy all conditions is `[3,-2,1,-5,2,-4]`.

### Example 2
**Input:** `nums = [-1,1]`  
**Output:** `[1,-1]`  
**Explanation:** 
1 is the only positive integer and -1 the only negative integer in nums.
So `[1,-1]` is the only correct answer.

## Constraints

- `2 <= nums.length <= 2 * 10^5`
- `nums.length` is **even**.
- `1 <= |nums[i]| <= 10^5`
- `nums` consists of **equal** number of positive and negative integers.

## Approaches

### Approach 1: Using LinkedHashMap

We can use `LinkedHashMap` to map the target indices to their corresponding positive and negative values. Since `nums` won't have `0`, we can differentiate signs easily. 

- **Time Complexity:** O(N) — Iterating through the array, though the average case for `LinkedHashMap` insertion is O(1), the constant factors and potential worst-case O(N) hash collisions make it less efficient in practice.
- **Space Complexity:** O(N) — Extra space needed for the Maps.

### Approach 2: Using Two ArrayLists

Instead of Maps, we can separate the positive and negative numbers into two separate `ArrayList`s. Then, we overwrite the original array by taking elements from the lists alternately.

- **Time Complexity:** O(N) — One pass to separate into lists, and one pass to reconstruct the array.
- **Space Complexity:** O(N) — Extra space to store positive and negative elements in lists.

### Approach 3: Two Pointers / Optimal (One-Pass)

We can optimize the approach by directly placing elements into a new `result` array. We use two pointers: `even_position` starting at `0` for positive elements, and `odd_position` starting at `1` for negative elements. As we iterate through the input array, we place the elements directly into their final destination and increment the respective pointer by 2.

- **Time Complexity:** O(N) — We traverse the given array exactly once.
- **Space Complexity:** O(N) — We use an extra `result` array to store the modified numbers.

## Follow Up

**What if the array has an unequal number of positive and negative elements?**
The optimal one-pass approach won't work directly because it assumes an equal split. If lengths are unequal, we must fall back to a variation of **Approach 2** (using Lists/Arrays). We would pair them up until one list is exhausted, and then append the remaining elements of the larger list at the end of the array.
Video Solution & Explanation

## Solution (Java)

```java
class Solution {
    public int[] rearrangeArray(int[] nums) {

        /* Approach 1: Using LinkedHashMap
        int n = nums.length;
        LinkedHashMap<Integer,Integer> lhmp = new LinkedHashMap<>();
        LinkedHashMap<Integer,Integer> lhmn = new LinkedHashMap<>();
        int evencounter = 0,oddcounter = 1;

        for(int i=0;i<n;i++){
            if(nums[i]<0){
                lhmn.put(oddcounter,nums[i]);
                oddcounter += 2;
            }
            else{  
                lhmp.put(evencounter,nums[i]);
                evencounter += 2;
            }
        }
        for(int i=0;i<n;i=i+2){ nums[i] = lhmp.get(i); }
        for(int i=1;i<n;i=i+2){ nums[i] = lhmn.get(i); }
        return nums;
        */

        /* Approach 2: Using ArrayList
        int n = nums.length;
        ArrayList<Integer> alp = new ArrayList<>();
        ArrayList<Integer> aln = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]<0) aln.add(nums[i]);
            else alp.add(nums[i]);
        }
        for(int i=0;i<alp.size();i++) nums[2*i] = alp.get(i);
        for(int i=0;i<aln.size();i++) nums[2*i+1] = aln.get(i);
        return nums;
        */

        // Approach 3: Optimal (One-Pass)
        int n = nums.length;
        int[] result = new int[n];
        int even_position = 0, odd_position = 1;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                result[even_position] = nums[i];
                even_position += 2;
            } else {
                result[odd_position] = nums[i];
                odd_position += 2;
            }
        }
        return result;
    }
}
```
