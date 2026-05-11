# 14. Longest Common Prefix

## Problem Statement

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string `""`.

## Examples

### Example 1
**Input:** `strs = ["flower","flow","flight"]`  
**Output:** `"fl"`  

### Example 2
**Input:** `strs = ["dog","racecar","car"]`  
**Output:** `""`  
**Explanation:** There is no common prefix among the input strings.

## Constraints

- `1 <= strs.length <= 200`
- `0 <= strs[i].length <= 200`
- `strs[i]` consists of only lowercase English letters.

## Approach: Lexicographical Sorting

The provided solution uses a sorting-based approach to efficiently find the longest common prefix:
1. **Edge Case:** If the array contains only one string, that string is the common prefix.
2. **Sort the Array:** Sort the array of strings lexicographically (in dictionary order). 
3. **Compare First and Last:** After sorting, the strings with the most differing characters will be at the beginning and the end of the array. Therefore, the longest common prefix for all strings in the array will be exactly the common prefix of just the **first** and **last** strings.
4. **Find the Prefix:** Iterate through the characters of the first and last strings, stopping at the first character that differs. Return the substring up to that point.

## Complexity Analysis

- **Time Complexity:** `O(N * log(N) * M)` where `N` is the number of strings and `M` is the maximum length of a string. Sorting an array of strings takes `O(N * log(N))` comparisons, and each string comparison takes up to `O(M)` time. The final step compares the first and last string, taking `O(M)` time.
- **Space Complexity:** `O(M)` where `M` is the length of the longest common prefix (due to the creation of the return substring). Not counting the output string, the space complexity is `O(1)` aside from the recursion stack overhead of the sorting algorithm.

## Solution (Java)

```java
/* T.C ---> O(N*log(N)*M) , S.C ---> O(M)
N ---> Number of strings in the array
M ---> Minimum length of String
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {

        // If there is only one string, that itself is the longest common prefix
        if (strs.length == 1) {
            return strs[0];
        }

        // Sort the array lexicographically.
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];
        int i = 0;

        for (; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }
        }
        return first.substring(0, i);
    }
}
```
