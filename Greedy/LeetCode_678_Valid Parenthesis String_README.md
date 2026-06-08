# 678. Valid Parenthesis String

## Problem Statement

Given a string `s` containing only three types of characters: `'('`, `')'` and `'*'`, return `true` if `s` is valid.

The following rules define a valid string:
1. Any left parenthesis `'('` must have a corresponding right parenthesis `')'`.
2. Any right parenthesis `')'` must have a corresponding left parenthesis `'('`.
3. Left parenthesis `'('` must go before the corresponding right parenthesis `')'`.
4. `'*'` could be treated as a single right parenthesis `')'`, a single left parenthesis `'('`, or an empty string `""`.

## Examples

### Example 1
**Input:** `s = "()"`  
**Output:** `true`

### Example 2
**Input:** `s = "(*)"`  
**Output:** `true`  
**Explanation:** The `'*'` can be treated as an empty string.

### Example 3
**Input:** `s = "(*))"`  
**Output:** `true`  
**Explanation:** The `'*'` can be treated as a left parenthesis `'('` to make the string valid as `"(())"`.

## Constraints

- `1 <= s.length <= 100`
- `s[i]` is `'('`, `')'`, or `'*'`.

## Approach: Greedy (Two Counters)

Since the `'*'` character introduces multiple possibilities (it can be `'('`, `')'`, or empty), branching out to test every possibility would result in an exponential time complexity `O(3^N)`. 

To optimize this, we can use a **Greedy Approach** by keeping track of the **range** of possible open left parentheses at any given time.

- We use two variables: 
  - `max`: The maximum possible number of open parentheses (treating `'*'` as `'('`).
  - `min`: The minimum possible number of open parentheses (treating `'*'` as `')'`).
- As we iterate through the string:
  - If we see `(`, both `min` and `max` increase.
  - If we see `)`, both `min` and `max` decrease.
  - If we see `*`, it could be `)` (so `min` decreases) or `(` (so `max` increases) or empty (no change).
- **Invalidity checks during traversal:**
  - If `max < 0` at any point, it means that even if we turned all `'*'` into `'('`, we still have too many closing brackets `)`. Thus, the string is invalid (`return false`).
  - `min` can drop below `0` if we change too many `'*'` into `')'`. However, since `'*'` can also just be an empty string, we shouldn't let our minimum possible open count become negative. We simply reset `min = 0` if it drops below `0`.
- **Final Check:**
  - For a string to be valid at the end, all opened parentheses must be closed. This means the minimum possible open parentheses `min` must exactly be `0`.

## Complexity Analysis

- **Time Complexity:** `O(N)` — We iterate through the string of length `N` exactly once.
- **Space Complexity:** `O(1)` — We only use two integer variables (`min` and `max`), requiring constant extra space.

## Solution (Java)

```java
class Solution {
    public boolean checkValidString(String s) {

        // Variable to track minimum possible open brackets at current index
        int min = 0;

        // Variable to track maximum possible open brackets at current index
        int max = 0;

        // Traverse through each character in the string
        for (char c : s.toCharArray()) {

            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                min--;
                max--;
            } else { // character is '*'
                min--; // if '*' is treated as ')'
                max++; // if '*' is treated as '('
            }

            // If max becomes negative → too many closing brackets → invalid
            if (max < 0) return false;

            // min can't go below 0 (we can't have negative open brackets)
            if (min < 0) min = 0;
        }

        return min == 0;
    }
}
```
