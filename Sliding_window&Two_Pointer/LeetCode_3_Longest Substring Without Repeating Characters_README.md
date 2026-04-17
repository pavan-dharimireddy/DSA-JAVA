# 3. Longest Substring Without Repeating Characters

## Problem Statement

Given a string `s`, find the length of the **longest substring** without repeating characters.

## Examples

### Example 1

**Input:** `s = "abcabcbb"`
**Output:** `3`
**Explanation:** The answer is "abc", with the length of 3.

### Example 2

**Input:** `s = "bbbbb"`
**Output:** `1`
**Explanation:** The answer is "b", with the length of 1.

## Approaches

### Approach 1: Brute Force

This approach checks every possible substring to see if it has repeating characters.
We iterate through the string with an outer loop `i` (starting point of substring) and an inner loop `j` (ending point). We use an integer array of size 256 to act as a fast hash map to keep track of characters we've seen in the current substring. If we see a character again, we break the inner loop and update our maximum length.

- **Time Complexity:** `O(N^2)` — We check all substrings which takes quadratic time in the worst case.
- **Space Complexity:** `O(1)` — We use a constant size array of 256 integers. _(Note: Creating a new 256-length array for each `i` increases allocation frequency and garbage collection overhead, but doesn't change the asymptotic peak memory usage.)_

### Approach 2: Sliding Window using HashMap (Optimal)

Instead of checking all substrings from scratch, we can use a sliding window approach with two pointers, `l` (left) and `r` (right). We use a `HashMap` to store each character and its most recently seen index.

1. We expand the window by moving the right pointer `r` across the string.
2. If the current character `s.charAt(r)` is already in the `HashMap` (meaning we've seen it), it might be inside our current window.
3. If it is inside the window, we jump the left pointer `l` to the index immediately following the last occurrence of the character (`hm.get(ch) + 1`). We use `Math.max(l, hm.get(ch) + 1)` to ensure `l` never moves backwards.
4. Calculate the current valid window size `r - l + 1` and update `max_len`.
5. Update the character's last seen index in the `HashMap` to the current `r`.

- **Time Complexity:** `O(N)` — The right pointer `r` iterates through the string exactly once. The left pointer `l` only moves forward.
- **Space Complexity:** `O(N)` — Due to the `HashMap`. We can further optimize the space complexity to `O(1)` by replacing the `HashMap` with a fixed-size integer array of length 256 (for extended ASCII).

## Solution (Java)

```java
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int max_len = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (hm.containsKey(ch)) {
                l = Math.max(l, hm.get(ch) + 1);
            }
            max_len = Math.max(max_len, r - l + 1);
            hm.put(ch, r);
        }
        return max_len;
    }
}
```
