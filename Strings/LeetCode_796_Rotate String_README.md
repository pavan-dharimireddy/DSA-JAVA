# 796. Rotate String

## Problem Statement

Given two strings `s` and `goal`, return `true` if and only if `s` can become `goal` after some number of shifts on `s`.

A shift on `s` consists of moving the leftmost character of `s` to the rightmost position.

- For example, if `s = "abcde"`, then it will be `"bcdea"` after one shift.

## Examples

### Example 1

**Input:** `s = "abcde"`, `goal = "cdeab"`  
**Output:** `true`

### Example 2

**Input:** `s = "abcde"`, `goal = "abced"`  
**Output:** `false`

## Constraints

- `1 <= s.length, goal.length <= 100`
- `s` and `goal` consist of lowercase English letters.

## Approaches

### Approach 1: Brute Force

This approach involves generating all possible rotations of the string `s` and comparing each one against the `goal` string.

- First, check if `s` and `goal` have the same length.
- Loop through the string `s` and in each iteration, build a new string by taking a substring from the current index to the end, and appending the substring from the beginning to the current index.
- Check if the newly formed rotated string matches `goal`.
- **Time Complexity:** `O(N^2)` where `N` is the length of string `s`. Generating `N` rotations and each string comparison takes `O(N)` time.
- **Space Complexity:** `O(N)` for the space needed to store each rotated string during the iteration.

### Approach 2: String Concatenation (Optimal)

A more elegant and optimal approach relies on a simple observation: if you concatenate string `s` with itself (`s + s`), the newly formed string will contain all possible valid rotations of `s` as its substrings.

- First, check if the lengths of `s` and `goal` are equal. If they differ, `s` can never be rotated to match `goal`.
- Concatenate `s` with itself to create `newString = s + s`.
- Check if `goal` is a substring of `newString` using the built-in `.contains()` method.
- **Time Complexity:** `O(N)` where `N` is the length of string `s`. The `.contains()` method (which searches for a substring) runs in linear time.
- **Space Complexity:** `O(N)` to store the concatenated string `s + s`.

## Solution (Java)

```java
/*
Time Complexity: O(N), because checking for a substring in s + s is linear in time.
Space Complexity: O(N) for the space needed to store the concatenated string s + s.
*/
class Solution {
    public boolean rotateString(String s, String goal) {
        // If lengths differ, they cannot be rotations of each other
        if(s.length() != goal.length()){
            return false;
        }

        // Concatenate the original string with itself
        String newString = s + s;

        // Check if goal is a substring of the concatenated string
        return newString.contains(goal);
    }
}
```
