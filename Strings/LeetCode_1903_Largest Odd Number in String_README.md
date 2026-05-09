# 1903. Largest Odd Number in String

## Problem Statement

You are given a string `num`, representing a large integer. Return the **largest-valued odd integer** (as a string) that is a **non-empty substring** of `num`, or an empty string `""` if no odd integer exists.

A **substring** is a contiguous sequence of characters within a string.

## Examples

### Example 1
**Input:** `num = "52"`  
**Output:** `"5"`  
**Explanation:** The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.

### Example 2
**Input:** `num = "4206"`  
**Output:** `""`  
**Explanation:** There are no odd numbers in "4206".

### Example 3
**Input:** `num = "35427"`  
**Output:** `"35427"`  
**Explanation:** "35427" is already an odd number.

## Constraints

- `1 <= num.length <= 10^5`
- `num` only consists of digits and does not contain any leading zeros.

## Approaches

### Approach 1: String Traversal from Right to Left (Optimal)
To find the largest odd number, we should find the longest odd prefix. A number is odd if its rightmost digit is odd. Therefore, we can iterate through the string from the last character to the first. As soon as we find an odd digit, we know that the substring from the beginning of `num` up to this digit is the largest odd number. 

- **Time Complexity:** `O(N)` — In the worst case, we traverse the entire string of length `N`. Constructing the resulting substring takes up to `O(N)` time. Overall time complexity is `O(N)`.
- **Space Complexity:** `O(N)` — The `substring()` operation returns a new string, taking up to `O(N)` space to store the output.

### Approach 2: Integer Parsing (Not Recommended)
We could theoretically parse the string into an integer (`Integer.parseInt()`), check if it's odd, and if not, repeatedly divide it by 10 (removing the last digit) until an odd number remains.
- **Why this approach fails:** The input string `num` can be up to `10^5` characters long. The maximum value for an `int` in Java is `2^31 - 1` (approx. 10 digits). Attempting to parse larger strings will cause a `NumberFormatException` due to overflow.

## Solution (Java)

```java
class Solution {
    public String largestOddNumber(String num) {
        int n = num.length() - 1; // start from the last index
        
        while (n >= 0) { // iterate backwards through the string
            // check if the last char is odd
            if (num.charAt(n) % 2 == 1) { 
                break; // found an odd-ending; stop
            }
            n--; // move left if current digit is even
        }
        
        // return prefix up to the last odd digit (empty string if none)
        return num.substring(0, n + 1); 
    }
}
```
