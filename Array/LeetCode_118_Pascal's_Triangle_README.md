# 118. Pascal's Triangle

## Problem Statement

Given an integer `numRows`, return the first `numRows` of **Pascal's triangle**.

In Pascal's triangle, each number is the sum of the two numbers directly above it. Alternatively, any element at row `n` and column `r` can be directly calculated using the combinations formula `nCr`.

## Examples

### Example 1
**Input:** `numRows = 5`  
**Output:** `[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]`

### Example 2
**Input:** `numRows = 1`  
**Output:** `[[1]]`

## Constraints

- `1 <= numRows <= 30`

## Approaches

### Approach 1: Brute Force (Using Factorials)
For each row `i` (from 1 to `numRows`) and each column `j` (from 1 to `i`), we calculate the exact value using the standard combinations formula: `nCr = n! / (r! * (n-r)!)`.
- **Time Complexity:** O(N³) — where `N` is `numRows`. There are nested loops to iterate through rows and columns `O(N²)`, and calculating the factorial for each element takes `O(N)` time.
- **Space Complexity:** O(1) — Excluding the space used for the result array.
> **Note:** This approach is highly inefficient and quickly leads to integer overflow issues in Java for relatively small inputs because factorials grow extremely fast.

### Approach 2: Optimal (Using Combinatorics / Math)
Instead of calculating factorials from scratch for every element, we can generate the next element in a row dynamically using the previous element. 
For a given row `n` (1-indexed), the `r`-th element (0-indexed) can be found using the mathematical relationship: `current_element = previous_element * (n - r) / r`.
- **Time Complexity:** O(N²) — We iterate through each element of the triangle exactly once to build the rows.
- **Space Complexity:** O(1) — No extra space is required aside from the output lists being returned.

## Solution (Java)

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            l.add(innerList(i));
        }
        return l;
    }

    public List<Integer> innerList(int n) {
        List<Integer> temp = new ArrayList<>();
        int res = 1;
        temp.add(res);
        for (int i = 1; i < n; i++) {
            res = res * (n - i);
            res = res / i;
            temp.add(res);
        }
        return temp;
    }
}
```
