# 205. Isomorphic Strings

## Problem Statement

Given two strings `s` and `t`, determine if they are isomorphic.

Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

## Examples

### Example 1
**Input:** `s = "egg", t = "add"`  
**Output:** `true`

### Example 2
**Input:** `s = "foo", t = "bar"`  
**Output:** `false`

### Example 3
**Input:** `s = "paper", t = "title"`  
**Output:** `true`

## Constraints

- `1 <= s.length <= 5 * 10^4`
- `t.length == s.length`
- `s` and `t` consist of any valid ASCII character.

## Approaches

### Approach 1: Two HashMaps
This approach uses two HashMaps to keep track of character mappings from `s` to `t` and from `t` to `s`. As we iterate through both strings, we check if the current character mapping is consistent with previously stored mappings.
- **Time Complexity:** `O(N)` — Where `N` is the length of strings `s` and `t`. We iterate through the strings exactly once.
- **Space Complexity:** `O(1)` — Constant extra space. Even though HashMaps are used, there are only 256 valid ASCII characters, so the maps will store a maximum of 256 key-value pairs.

### Approach 2: Last Seen Index (Optimal)
Instead of explicitly mapping characters to each other, we can track the **last seen index** of each character. We use two integer arrays of size 256 (covering all extended ASCII characters). As we iterate, if the last seen index for the character in `s` differs from the last seen index for the character in `t`, it means the characters have been mapped inconsistently previously.
- **Time Complexity:** `O(N)` — A single pass through the string is required.
- **Space Complexity:** `O(1)` — The algorithm uses two fixed-size arrays of 256 integers, independent of the input string length.

## Solution (Java)

```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        // Assuming ASCII. Use 256 for extended ASCII.
        int[] sLast = new int[256];
        int[] tLast = new int[256];

        // Initialize with -1 (meaning "not seen yet")
        for (int i = 0; i < 256; i++) {
            sLast[i] = -1;
            tLast[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int cs = s.charAt(i);
            int ct = t.charAt(i);

            // If last seen positions differ, mapping is inconsistent
            if (sLast[cs] != tLast[ct]) {
                return false;
            }

            // Mark both as last seen at index i
            sLast[cs] = i;
            tLast[ct] = i;
        }

        return true;
    }
}
```
